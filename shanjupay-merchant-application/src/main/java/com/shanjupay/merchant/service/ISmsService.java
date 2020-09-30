package com.shanjupay.merchant.service;

import com.shanjupay.common.domain.BusinessException;

public interface ISmsService {

    /**
     * 发送手机验证码。
     *
     * @param phone 手机号。
     * @return 验证码对应的 key。
     */
    String sendMsg(String phone);


    /**
     * 校验手机验证码。
     *
     * @param verifyKey  验证码的 key。
     * @param verifyCode 验证码。
     */
    void checkVerifyCode(String verifyKey, String verifyCode) throws BusinessException;

}
