package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.resource.ApplicationDTO;
import com.shanjupay.user.entity.ResourceApplication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IResourceApplicationConvert {

    IResourceApplicationConvert INSTANCE = Mappers.getMapper(IResourceApplicationConvert.class);

    ApplicationDTO entity2dto(ResourceApplication entity);

    ResourceApplication dto2entity(ApplicationDTO dto);

    List<ApplicationDTO> entityList2dto(List<ResourceApplication> bundle);

}
