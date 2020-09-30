package com.shanjupay.uua.api;

import java.util.Map;

public interface OauthClientDetailsService {

    void createClientDetails(Map map);

    /**
     * 根据 appId 查询 client 信息。
     * appId 也就是 client_id。
     *
     * @param appId
     * @return
     */
    Map getClientDetailsByClientId(String appId);

}
