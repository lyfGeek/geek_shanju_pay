package com.shanjupay.transaction.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "PayChannelParamDTO", description = "商户原始支付渠道参数配置。")
@Data
public class PayChannelParamDTO implements Serializable {

    @ApiModelProperty("参数配置 id，新增时无需。")
    private Long id;

    @ApiModelProperty("应用的 appId，是业务 id。")
    private String appId;

    @ApiModelProperty("应用绑定的服务类型对应的 code。")
    private String platformChannelCode;

    @ApiModelProperty("参数配置名称。")
    private String channelName;

    @ApiModelProperty("商户 id。")
    private Long merchantId;

    @ApiModelProperty("原始支付渠道编码。")
    private String payChannel;

    @ApiModelProperty("原始支付渠道参数配置内容，json 格式。")
    private String param;

    @ApiModelProperty("应用绑定的服务类型 ID。")
    private Long appPlatformChannelId;

}
