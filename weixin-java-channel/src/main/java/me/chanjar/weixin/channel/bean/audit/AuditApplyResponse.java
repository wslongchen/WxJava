package me.chanjar.weixin.channel.bean.audit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

/**
 * 审核提交结果响应
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuditApplyResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = -3950614749162384497L;

  /** 类目列表 */
  @JsonProperty("audit_id")
  private String auditId;
}
