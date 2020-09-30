package com.shanjupay.paymentagent.api.conf;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WXConfigParam implements Serializable {

    public String returnUrl;
    private String appId;
    private String appSecret;// 是 APPID 对应的接口密码，用于获取接口调用凭证 access_token 时使用。
    private String mchId;
    private String key;

}
