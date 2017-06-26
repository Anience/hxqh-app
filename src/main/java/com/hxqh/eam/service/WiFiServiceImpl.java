package com.hxqh.eam.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lh on 2017/4/14.
 */
@Service("wiFiService")
public class WiFiServiceImpl implements WiFiService {

    @Value("${com.hxqh.agp.appid}")
    private String APP_ID;

    @Value("${com.hxqh.agp.securitykey}")
    private String SECURITY_KEY;

    @Value("${com.hxqh.agp.lang.en}")
    private String langEn;

    @Value("${com.hxqh.agp.lang.zh}")
    private String langZh;





}
