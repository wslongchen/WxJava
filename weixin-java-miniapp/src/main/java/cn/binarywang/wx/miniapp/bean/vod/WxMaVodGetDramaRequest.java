package cn.binarywang.wx.miniapp.bean.vod;

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
public class WxMaVodGetDramaRequest implements Serializable {
  private static final long serialVersionUID = 7495157056049312108L;

  @SerializedName("drama_id")
  private Integer dramaId;

  public String toJson() {
    return WxMaGsonBuilder.create().toJson(this);
  }
}
