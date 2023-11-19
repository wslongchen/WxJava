package me.chanjar.weixin.channel.bean.after;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 退款信息
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
public class RefundInfo implements Serializable {

  private static final long serialVersionUID = -6994243947898889309L;
  /** 退款金额（分） */
  @JsonProperty("amount")
  private Integer amount;
}
