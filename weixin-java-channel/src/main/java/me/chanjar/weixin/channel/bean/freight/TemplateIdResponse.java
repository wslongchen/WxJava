package me.chanjar.weixin.channel.bean.freight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

/**
 * 运费模板 列表 响应
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TemplateIdResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5179651364165620640L;
  /** 运费模板id */
  @JsonProperty("template_id")
  private String templateId;

}
