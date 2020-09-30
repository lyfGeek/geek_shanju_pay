package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.tenant.TenantDTO;
import com.shanjupay.user.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ITenantConvert {

    ITenantConvert INSTANCE = Mappers.getMapper(ITenantConvert.class);

    TenantDTO entity2dto(Tenant entity);

    Tenant dto2entity(TenantDTO dto);

}
