package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.menu.MenuDTO;
import com.shanjupay.user.entity.ResourceMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IResourceMenuConvert {

    IResourceMenuConvert INSTANCE = Mappers.getMapper(IResourceMenuConvert.class);

    MenuDTO entity2dto(ResourceMenu entity);

    ResourceMenu dto2entity(MenuDTO dto);

    List<MenuDTO> entityList2dto(List<ResourceMenu> resourceMenu);

    List<ResourceMenu> dtoList2entity(List<MenuDTO> menuDTO);

}
