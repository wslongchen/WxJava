package me.chanjar.weixin.channel.bean.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

/**
 * 地址id 响应
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressInfoResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 8203853673226715673L;

  /** 地址详情 */
  @JsonProperty("address_detail")
  private AddressDetail addressDetail;
}
