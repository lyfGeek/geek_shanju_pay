package com.shanjupay.merchant.service;

import com.shanjupay.common.domain.BusinessException;

public interface IFileService {

    /**
     * 上传文件。
     *
     * @param bytes    文件字节数组。
     * @param fileName 文件名。
     * @return 文件访问路径（绝对的 url）。
     * @throws BusinessException
     */
    String upload(byte[] bytes, String fileName) throws BusinessException;

}
