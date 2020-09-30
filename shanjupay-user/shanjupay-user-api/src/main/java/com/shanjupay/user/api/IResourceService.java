package com.shanjupay.user.api;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.common.domain.PageVO;
import com.shanjupay.user.api.dto.authorization.AuthorizationInfoDTO;
import com.shanjupay.user.api.dto.resource.ApplicationDTO;
import com.shanjupay.user.api.dto.resource.ApplicationQueryParams;
import com.shanjupay.user.api.dto.resource.ResourceDTO;

import java.util.List;
import java.util.Map;

/**
 * 资源服务。
 */
public interface IResourceService {
    /**
     * 创建应用。
     * 会关联创建 uaa 服务中的接入客户端，其中 code 为 clientId。
     *
     * @param application
     * @throws BusinessException
     */
    void createApplication(ApplicationDTO application) throws BusinessException;

    /**
     * 修改应用。
     * 仅仅可以修改名称。
     *
     * @param application
     */
    void modifyApplication(ApplicationDTO application) throws BusinessException;

    /**
     * 删除应用。
     * 关联删除 uaa 服务中的接入客户端，若应用下有资源，禁止删除。
     *
     * @param applicationCode
     */
    void removeApplication(String applicationCode) throws BusinessException;

    /**
     * 根据应用编码查找应用。
     *
     * @param applicationCode
     * @return
     */
    ApplicationDTO queryApplication(String applicationCode) throws BusinessException;

    /**
     * 条件分页查找应用。
     *
     * @param applicationQueryParams
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageVO<ApplicationDTO> pageApplicationByConditions(ApplicationQueryParams applicationQueryParams, Integer pageNo, Integer pageSize) throws BusinessException;

    /**
     * 根据权限加载指定应用的资源。
     *
     * @param privilegeCodes
     * @param applicationCode
     * @return
     */
    List<ResourceDTO> loadResources(List<String> privilegeCodes, String applicationCode) throws BusinessException;

    /**
     * 获取多个租户下权限所对应的的资源信息，并按应用拆分。
     *
     * @param tenantAuthorizationInfoMap 多个租户下的权限信息。key 为租户 id，value 为租户下的角色权限信息。
     * @return 多个租户下的资源信息，key 为租户 id，value 为租户下多个应用的资源信息。
     * eg. {租户A: [{应用1权限信息}, {应用2权限信息}], 租户 B: [{}, {}, ...], ...}。
     */
    Map<Long, List<ResourceDTO>> loadResources(Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfoMap) throws BusinessException;

}
