package com.shanjupay.paymentagent.api.conf;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliConfigParam implements Serializable {

    // 应用 id。
    public String appId;
    // 私钥。
    public String rsaPrivateKey;
    // 异步回调通知。
    public String notifyUrl;
    // 同步回调通知。
    public String returnUrl;
    // 支付宝网关。
    public String url;
    // 编码方式 UTF-8
    public String charset;
    // 格式JSON。
    public String format;
    // ali 公钥。
    public String alipayPublicKey;
    // 日志保存路径， 目前不用。
    public String logPath;
    // RSA2 户生成签名字符串所使用的签名算法类型，目前支持 RSA2 和 RSA，推荐使用 RSA2。
    public String signType;

}
