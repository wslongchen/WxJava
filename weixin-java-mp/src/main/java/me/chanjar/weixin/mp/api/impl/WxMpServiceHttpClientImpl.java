package me.chanjar.weixin.mp.api.impl;

import me.chanjar.weixin.common.util.http.HttpType;
import me.chanjar.weixin.common.util.http.apache.ApacheHttpClientBuilder;
import me.chanjar.weixin.common.util.http.apache.DefaultApacheHttpClientBuilder;
import me.chanjar.weixin.mp.bean.WxMpStableAccessTokenRequest;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Other.GET_ACCESS_TOKEN_URL;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Other.GET_STABLE_ACCESS_TOKEN_URL;

/**
 * apache http client方式实现.
 *
 * @author someone
 */
public class WxMpServiceHttpClientImpl extends BaseWxMpServiceImpl<CloseableHttpClient, HttpHost> {
  private CloseableHttpClient httpClient;
  private HttpHost httpProxy;

  @Override
  public CloseableHttpClient getRequestHttpClient() {
    return httpClient;
  }

  @Override
  public HttpHost getRequestHttpProxy() {
    return httpProxy;
  }

  @Override
  public HttpType getRequestType() {
    return HttpType.APACHE_HTTP;
  }

  @Override
  public void initHttp() {
    WxMpConfigStorage configStorage = this.getWxMpConfigStorage();
    ApacheHttpClientBuilder apacheHttpClientBuilder = configStorage.getApacheHttpClientBuilder();
    if (null == apacheHttpClientBuilder) {
      apacheHttpClientBuilder = DefaultApacheHttpClientBuilder.get();
    }

    apacheHttpClientBuilder.httpProxyHost(configStorage.getHttpProxyHost())
      .httpProxyPort(configStorage.getHttpProxyPort())
      .httpProxyUsername(configStorage.getHttpProxyUsername())
      .httpProxyPassword(configStorage.getHttpProxyPassword());

    if (configStorage.getHttpProxyHost() != null && configStorage.getHttpProxyPort() > 0) {
      this.httpProxy = new HttpHost(configStorage.getHttpProxyHost(), configStorage.getHttpProxyPort());
    }

    this.httpClient = apacheHttpClientBuilder.build();
  }

  @Override
  protected String doGetAccessTokenRequest() throws IOException {
    String url = String.format(GET_ACCESS_TOKEN_URL.getUrl(getWxMpConfigStorage()), getWxMpConfigStorage().getAppId(), getWxMpConfigStorage().getSecret());

    HttpGet httpGet = null;
    CloseableHttpResponse response = null;
    try {
      httpGet = new HttpGet(url);
      if (this.getRequestHttpProxy() != null) {
        RequestConfig config = RequestConfig.custom().setProxy(this.getRequestHttpProxy()).build();
        httpGet.setConfig(config);
      }
      response = getRequestHttpClient().execute(httpGet);
      return new BasicResponseHandler().handleResponse(response);
    } finally {
      if (httpGet != null) {
        httpGet.releaseConnection();
      }
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
        }
      }
    }
  }

  @Override
  protected String doGetStableAccessTokenRequest(boolean forceRefresh) throws IOException {
    String url = GET_STABLE_ACCESS_TOKEN_URL.getUrl(getWxMpConfigStorage());

    HttpPost httpPost = null;
    CloseableHttpResponse response = null;
    try {
      httpPost = new HttpPost(url);
      if (this.getRequestHttpProxy() != null) {
        RequestConfig config = RequestConfig.custom().setProxy(this.getRequestHttpProxy()).build();
        httpPost.setConfig(config);
      }
      WxMpStableAccessTokenRequest wxMaAccessTokenRequest = new WxMpStableAccessTokenRequest();
      wxMaAccessTokenRequest.setAppid(this.getWxMpConfigStorage().getAppId());
      wxMaAccessTokenRequest.setSecret(this.getWxMpConfigStorage().getSecret());
      wxMaAccessTokenRequest.setGrantType("client_credential");
      wxMaAccessTokenRequest.setForceRefresh(forceRefresh);

      httpPost.setEntity(new StringEntity(wxMaAccessTokenRequest.toJson(), ContentType.APPLICATION_JSON));
      response = getRequestHttpClient().execute(httpPost);
      return new BasicResponseHandler().handleResponse(response);
    } finally {
      if (httpPost != null) {
        httpPost.releaseConnection();
      }
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
        }
      }
    }
  }

}
