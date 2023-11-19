package me.chanjar.weixin.channel.bean.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品类目id
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
public class SpuCategory implements Serializable {

  private static final long serialVersionUID = -8500610555473351789L;

  /** 类目id */
  @JsonProperty("cat_id")
  private String id;
}
