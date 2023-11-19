package me.chanjar.weixin.channel.bean.message.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.message.WxChannelMessage;

/**
 * 提现二维码回调 消息
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JacksonXmlRootElement(localName = "xml")
public class QrNotifyMessage extends WxChannelMessage {

  private static final long serialVersionUID = -4705790895359679423L;
  /** 账户信息 */
  @JsonProperty("qrcode_info")
  @JacksonXmlProperty(localName = "qrcode_info")
  private QrNotifyInfo qrcodeInfo;
}
