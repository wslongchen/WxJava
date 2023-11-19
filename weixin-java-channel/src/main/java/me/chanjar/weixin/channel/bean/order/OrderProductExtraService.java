package me.chanjar.weixin.channel.bean.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品额外服务信息
 *
 * @author <a href="https://github.com/qrpcode">北鹤M</a>
 */
@Data
@NoArgsConstructor
public class OrderProductExtraService implements Serializable {

  private static final long serialVersionUID = -8752053507170277156L;

  /** 7天无理由：0：不支持，1：支持 */
  @JsonProperty("seven_day_return")
  private Integer sevenDayReturn;

  /** 商家运费险：0：不支持，1：支持 */
  @JsonProperty("freight_insurance")
  private Integer freightInsurance;

}
