package me.chanjar.weixin.channel.message.rule;

import java.util.Map;
import me.chanjar.weixin.channel.api.WxChannelService;
import me.chanjar.weixin.channel.message.WxChannelMessage;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;

/**
 * 微信消息拦截器，可以用来做验证
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
public interface WxChannelMessageInterceptor {

  /**
   * 拦截微信消息
   *
   * @param message        消息
   * @param content        消息原始内容
   * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
   * @param service        服务实例
   * @param sessionManager session管理器
   * @return true代表OK，false代表不OK
   *
   * @throws WxErrorException 异常
   */
  boolean intercept(WxChannelMessage message, String content, Map<String, Object> context, WxChannelService service,
    WxSessionManager sessionManager) throws WxErrorException;

}
