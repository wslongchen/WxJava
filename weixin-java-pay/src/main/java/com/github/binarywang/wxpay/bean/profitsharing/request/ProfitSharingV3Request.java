package com.github.binarywang.wxpay.bean.profitsharing.request;

import com.github.binarywang.wxpay.v3.SpecEncrypt;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 微信V3接口
 * 请求分账API请求实体
 *
 * @author pg
 * created on  2021-6-24
 */
@Data
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class ProfitSharingV3Request implements Serializable {
  private static final long serialVersionUID = 3644929701624280800L;

  /**
   * <pre>
   * 字段名：子商户号
   * 是否必填：是
   * 描述：微信支付分配的子商户号，即分账的出资商户号。
   * </pre>
   */
  @SerializedName("sub_mchid")
  private String subMchId;

  /**
   * <pre>
   * 字段名：应用ID
   * 是否必填：是
   * 描述：微信分配的商户appid
   * </pre>
   */
  @SerializedName("appid")
  private String appid;

  /**
   * <pre>
   * 字段名：子商户应用ID
   * 是否必填：否
   * 描述：子商户的公众账号ID，分账接收方类型包含PERSONAL_SUB_OPENID时必填
   * </pre>
   */
  @SerializedName("sub_appid")
  private String subAppid;

  /**
   * <pre>
   * 字段名：微信订单号
   * 是否必填：是
   * 描述：微信支付订单号
   * </pre>
   */
  @SerializedName("transaction_id")
  private String transactionId;

  /**
   * <pre>
   * 字段名：商户分账单号
   * 是否必填：是
   * 描述：商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
   * </pre>
   */
  @SerializedName("out_order_no")
  private String outOrderNo;

  /**
   * <pre>
   * 字段名：分账接收方列表
   * 是否必填：是
   * 描述：分账接收方列表，可以设置出资商户作为分账接受方，最多可有50个分账接收方
   * </pre>
   */
  @SpecEncrypt
  @SerializedName("receivers")
  private List<Receiver> receivers;

  /**
   * <pre>
   * 字段名：是否解冻剩余未分资金
   * 是否必填：是
   * 描述：
   * 1、如果为true，该笔订单剩余未分账的金额会解冻回分账方商户；
   * 2、如果为false，该笔订单剩余未分账的金额不会解冻回分账方商户，可以对该笔订单再次进行分账。
   * </pre>
   */
  @SerializedName("unfreeze_unsplit")
  private boolean unfreezeUnsplit;
  /**
   * 分账接收方实体
   */
  @Data
  @NoArgsConstructor
  public static class Receiver implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <pre>
     * 字段名：分账接收方类型
     * 是否必填：是
     * 描述：
     * 1、MERCHANT_ID：商户号
     * 2、PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
     * </pre>
     */
    @SerializedName("type")
    private String type;

    /**
     * <pre>
     * 字段名：分账接收方帐号
     * 是否必填：是
     * 描述：
     * 1、分账接收方类型为MERCHANT_ID时，分账接收方账号为商户号
     * 2、分账接收方类型为PERSONAL_OPENID时，分账接收方账号为个人openid
     * </pre>
     */
    @SerializedName("account")
    private String account;

    /**
     * <pre>
     * 字段名：分账金额
     * 是否必填：是
     * 描述： 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     * </pre>
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * <pre>
     * 字段名：分账个人接收方姓名
     * 是否必填：否
     * 描述：
     * 可选项，在接收方类型为个人的时可选填，若有值，会检查与 name 是否实名匹配，不匹配会拒绝分账请求
     * 1、分账接收方类型是PERSONAL_OPENID，是个人姓名的密文（选传，传则校验） 此字段的加密方法详见：敏感信息加密说明
     * 2、使用微信支付平台证书中的公钥
     * 3、使用RSAES-OAEP算法进行加密
     * 4、将请求中HTTP头部的Wechatpay-Serial设置为证书序列号
     * </pre>
     */
    @SerializedName("name")
    @SpecEncrypt
    private String name;

    /**
     * <pre>
     * 字段名：与分账方的关系类型
     * 是否必填：是
     * 描述：子商户与接收方的关系。 本字段值为枚举：
     * STORE：门店
     * STAFF：员工
     * STORE_OWNER：店主
     * PARTNER：合作伙伴
     * HEADQUARTER：总部
     * BRAND：品牌方
     * DISTRIBUTOR：分销商
     * USER：用户
     * SUPPLIER： 供应商
     * CUSTOM：自定义
     * </pre>
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * <pre>
     * 字段名：自定义的分账关系
     * 是否必填：是
     * 描述：子商户与接收方具体的关系，本字段最多10个字。
     * 当字段relationType的值为CUSTOM时，本字段必填;
     * 当字段relationType的值不为CUSTOM时，本字段无需填写。
     * </pre>
     */
    @SerializedName("custom_relation")
    private String customRelation;
    /**
     * <pre>
     * 字段名：分账描述
     * 是否必填：是
     * 描述： 分账的原因描述，分账账单中需要体现
     * </pre>
     */
    private String description;
  }
}
