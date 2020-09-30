package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.tenant.BundleDTO;
import com.shanjupay.user.entity.Bundle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IBundleConvert {

    IBundleConvert INSTANCE = Mappers.getMapper(IBundleConvert.class);

    BundleDTO entity2dto(Bundle entity);

    Bundle dto2entity(BundleDTO dto);

    List<BundleDTO> entityList2dto(List<Bundle> bundle);

}
