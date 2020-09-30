package com.shanjupay.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanjupay.common.domain.PageVO;
import com.shanjupay.user.api.IMenuService;
import com.shanjupay.user.api.dto.menu.MenuDTO;
import com.shanjupay.user.api.dto.menu.MenuQueryDTO;
import com.shanjupay.user.convert.IResourceMenuConvert;
import com.shanjupay.user.entity.ResourceMenu;
import com.shanjupay.user.mapper.IResourceMenuMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IResourceMenuMapper resourceMenuMapper;

    /**
     * 根据 ID 查询菜单。
     *
     * @param id
     * @return
     */
    @Override
    public MenuDTO queryMenu(Long id) {
        ResourceMenu resourceMenu = resourceMenuMapper.selectById(id);
        MenuDTO menuDTO = IResourceMenuConvert.INSTANCE.entity2dto(resourceMenu);
        return menuDTO;
    }

    /**
     * 根据应用编码查询菜单列表。
     *
     * @param applicationCode
     * @return
     */
    @Override
    public List<MenuDTO> queryMenuByApplicationCode(String applicationCode) {
        List<ResourceMenu> resourceMenus = resourceMenuMapper.selectList(new QueryWrapper<ResourceMenu>().lambda()
                .eq(ResourceMenu::getApplicationCode, applicationCode));
        List<MenuDTO> menuDTOS = IResourceMenuConvert.INSTANCE.entityList2dto(resourceMenus);
        return menuDTOS;
    }

    /**
     * 根据条件查询菜单列表。
     *
     * @param params
     * @param pageSize
     * @param pageNo
     */
    @Override
    public PageVO<MenuDTO> queryMenu(MenuQueryDTO params, Integer pageNo, Integer pageSize) {
        // 参数 applicationCode（app 表） title status（菜单表）。
        pageSize = (pageSize == null ? 20 : pageSize);
        Page<MenuDTO> page = new Page<>(pageNo, pageSize);// 当前页，总条数构造 page 对象。
        List<MenuDTO> menus = resourceMenuMapper.selectByPage(page, params);
        return new PageVO<>(menus, page.getTotal(), pageNo, pageSize);
    }

    /**
     * 根据权限编码列表获取菜单。
     *
     * @param privileges 权限列表。
     * @return
     */
    @Override
    public List<MenuDTO> queryMenuByPrivileges(String[] privileges) {
        List<String> privilege = Arrays.asList(privileges);
        List<ResourceMenu> resourceMenus = resourceMenuMapper.selectList(new QueryWrapper<ResourceMenu>().lambda()
                .in(ResourceMenu::getPrivilegeCode, privilege));
        List<MenuDTO> menuDTOS = IResourceMenuConvert.INSTANCE.entityList2dto(resourceMenus);
        return menuDTOS;
    }

}
