package me.chanjar.weixin.channel.bean.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 视频号小店订单
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
public class OrderInfo implements Serializable {

  private static final long serialVersionUID = -4562618835611282016L;
  /** 订单号 */
  @JsonProperty("order_id")
  protected String orderId;

  /** 订单状态，枚举值见 {@link me.chanjar.weixin.channel.enums.WxOrderStatus} */
  @JsonProperty("status")
  protected Integer status;

  /** 买家身份标识 */
  @JsonProperty("openid")
  protected String openid;

  /** union id */
  @JsonProperty("unionid")
  protected String unionid;

  /** 订单详细数据信息 */
  @JsonProperty("order_detail")
  protected OrderDetailInfo orderDetail;

  /** 售后信息 */
  @JsonProperty("aftersale_detail")
  protected AfterSaleDetail afterSaleDetail;

  /** 创建时间 秒级时间戳 */
  @JsonProperty("create_time")
  protected Integer createTime;

  /** 更新时间 秒级时间戳 */
  @JsonProperty("update_time")
  protected Integer updateTime;

}
