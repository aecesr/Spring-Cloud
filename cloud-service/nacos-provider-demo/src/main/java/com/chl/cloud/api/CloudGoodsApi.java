package com.chl.cloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-service
 * @description:
 * @Author: 曹红亮
 * @create: 2022-09-01 08:49
 **/
@RestController
public class CloudGoodsApi {
    /**
     * 读取应用的启动端口
     */
    @Value("${server.port}")
    private String applicationServicePort;

    @GetMapping("/goodsServiceTest")
    public String goodsServiceTest() {
        // 返回信息
        return "this is goods service from port:"+applicationServicePort;
    }
}
