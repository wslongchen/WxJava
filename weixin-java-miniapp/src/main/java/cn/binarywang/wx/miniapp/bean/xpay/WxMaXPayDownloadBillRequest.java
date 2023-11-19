package cn.binarywang.wx.miniapp.bean.xpay;

import cn.binarywang.wx.miniapp.json.WxMaGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxMaXPayDownloadBillRequest implements Serializable {
  private static final long serialVersionUID = 7495157056049312108L;

  @SerializedName("begin_ds")
  private Integer beginDs;
  @SerializedName("end_ds")
  private Integer endDs;

  public String toJson() {
    return WxMaGsonBuilder.create().toJson(this);
  }
}
