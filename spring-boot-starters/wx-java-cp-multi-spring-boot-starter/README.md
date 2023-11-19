# wx-java-cp-multi-spring-boot-starter

企业微信多账号配置

- 实现多 WxCpService 初始化。
- 未实现 WxCpTpService 初始化，需要的小伙伴可以参考多 WxCpService 配置的实现。
- 未实现 WxCpCgService 初始化，需要的小伙伴可以参考多 WxCpService 配置的实现。

## 快速开始

1. 引入依赖
    ```xml
    <dependency>
        <groupId>com.github.binarywang</groupId>
        <artifactId>wx-java-cp-multi-spring-boot-starter</artifactId>
        <version>${version}</version>
    </dependency>
    ```
2. 添加配置(application.properties)
    ```properties
    # 应用 1 配置
    wx.cp.corps.tenantId1.corp-id = @corp-id
    wx.cp.corps.tenantId1.corp-secret = @corp-secret
    ## 选填
    wx.cp.corps.tenantId1.agent-id = @agent-id
    wx.cp.corps.tenantId1.token = @token
    wx.cp.corps.tenantId1.aes-key = @aes-key
    wx.cp.corps.tenantId1.msg-audit-priKey = @msg-audit-priKey
    wx.cp.corps.tenantId1.msg-audit-lib-path = @msg-audit-lib-path

    # 应用 2 配置
    wx.cp.corps.tenantId2.corp-id = @corp-id
    wx.cp.corps.tenantId2.corp-secret = @corp-secret
    ## 选填
    wx.cp.corps.tenantId2.agent-id = @agent-id
    wx.cp.corps.tenantId2.token = @token
    wx.cp.corps.tenantId2.aes-key = @aes-key
    wx.cp.corps.tenantId2.msg-audit-priKey = @msg-audit-priKey
    wx.cp.corps.tenantId2.msg-audit-lib-path = @msg-audit-lib-path

    # 公共配置
    ## ConfigStorage 配置（选填）
    wx.cp.config-storage.type=memory # 配置类型: memory(默认), jedis, redisson, redistemplate
    ## http 客户端配置（选填）
    wx.cp.config-storage.http-proxy-host=
    wx.cp.config-storage.http-proxy-port=
    wx.cp.config-storage.http-proxy-username=
    wx.cp.config-storage.http-proxy-password=
    ## 最大重试次数，默认：5 次，如果小于 0，则为 0
    wx.cp.config-storage.max-retry-times=5
    ## 重试时间间隔步进，默认：1000 毫秒，如果小于 0，则为 1000
    wx.cp.config-storage.retry-sleep-millis=1000
    ```
3. 支持自动注入的类型: `WxCpMultiServices`

4. 使用样例

```java
import com.binarywang.spring.starter.wxjava.cp.service.WxCpMultiServices;
import com.binarywang.spring.starter.wxjava.cp.service.WxCpServices;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
  @Autowired
  private WxCpMultiServices wxCpMultiServices;

  public void test() {
    // 应用 1 的 WxCpService
    WxCpService wxCpService1 = wxCpMultiServices.getWxCpService("tenantId1");
    WxCpUserService userService1 = wxCpService1.getUserService();
    userService1.getUserId("xxx");
    // todo ...

    // 应用 2 的 WxCpService
    WxCpService wxCpService2 = wxCpMultiServices.getWxCpService("tenantId2");
    WxCpUserService userService2 = wxCpService2.getUserService();
    userService2.getUserId("xxx");
    // todo ...

    // 应用 3 的 WxCpService
    WxCpService wxCpService3 = wxCpMultiServices.getWxCpService("tenantId3");
    // 判断是否为空
    if (wxCpService3 == null) {
      // todo wxCpService3 为空，请先配置 tenantId3 企业微信应用参数
      return;
    }
    WxCpUserService userService3 = wxCpService3.getUserService();
    userService3.getUserId("xxx");
    // todo ...
  }
}
```
