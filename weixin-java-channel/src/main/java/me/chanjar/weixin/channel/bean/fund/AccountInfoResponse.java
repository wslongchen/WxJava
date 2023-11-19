package me.chanjar.weixin.channel.bean.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

/**
 * 账户信息响应
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
public class AccountInfoResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = -8316068503468969533L;
  /** 账户信息 */
  @JsonProperty("account_info")
  private AccountInfo accountInfo;


}
