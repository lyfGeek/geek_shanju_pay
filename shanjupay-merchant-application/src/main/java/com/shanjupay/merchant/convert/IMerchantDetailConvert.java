package com.shanjupay.merchant.convert;

import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.shanjupay.merchant.vo.MerchantDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 将商户资质申请 vo 和 dto 进行转换。
 */
@Mapper
public interface IMerchantDetailConvert {

    IMerchantDetailConvert INSTANCE = Mappers.getMapper(IMerchantDetailConvert.class);

    // 将 dto 转成 vo。
    MerchantDetailVO dto2vo(MerchantDTO merchantDTO);

    // 将 vo 转成 dto。
    MerchantDTO vo2dto(MerchantDetailVO merchantDetailVO);

}
