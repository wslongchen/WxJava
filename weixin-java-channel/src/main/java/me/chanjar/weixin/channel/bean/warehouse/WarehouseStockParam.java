package me.chanjar.weixin.channel.bean.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.product.SkuStockParam;

/**
 * 库存参数
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
public class WarehouseStockParam extends SkuStockParam {

  private static final long serialVersionUID = -5121207621628542490L;

  /** 外部仓库ID */
  @JsonProperty("out_warehouse_id")
  private String outWarehouseId;
}
