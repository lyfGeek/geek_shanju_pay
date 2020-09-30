package com.shanjupay.merchant.controller;

import com.shanjupay.merchant.api.IAppService;
import com.shanjupay.merchant.api.dto.AppDTO;
import com.shanjupay.merchant.common.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商户平台 ~ 应用管理。", tags = "商户平台 ~ 应用相关。", description = "商户平台 ~ 应用相关。")
@RestController
public class AppController {

    @Reference
    private IAppService appService;

    @ApiOperation("商户创建应用。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "app", value = "应用信息。", required = true, dataType = "AppDTO", paramType = "body")}
    )
    @PostMapping(value = "/my/apps")
    public AppDTO createApp(@RequestBody AppDTO app) {
        // 得到商户 id。
        Long merchantId = SecurityUtil.getMerchantId();

        return appService.createApp(merchantId, app);
    }

    @ApiOperation("查询商户下的应用列表。")
    @GetMapping(value = "/my/apps")
    public List<AppDTO> queryMyApps() {
        // 商户 id。
        Long merchantId = SecurityUtil.getMerchantId();
        return appService.queryAppByMerchant(merchantId);
    }

    @ApiOperation("根据应用 id 查询应用信息。")
    @ApiImplicitParam(value = "应用 id。", name = "appId", dataType = "String", paramType = "path")
    @GetMapping(value = "/my/apps/{appId}")
    public AppDTO getApp(@PathVariable("appId") String appId) {
        return appService.getAppById(appId);
    }

}
