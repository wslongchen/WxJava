package me.chanjar.weixin.channel.bean.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

/**
 * 资金流水响应
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FundsFlowResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = -1130785908352355914L;
  /** 流水信息 */
  @JsonProperty("funds_flow")
  private FundsFlow fundsFlow;
}
