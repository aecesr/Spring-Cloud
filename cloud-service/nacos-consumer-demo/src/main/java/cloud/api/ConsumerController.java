package cloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: cloud-service
 * @description:
 * @Author: 曹红亮
 * @create: 2022-09-01 08:49
 **/
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private final String SERVICE_URL = "http://cloud-goods-service";


    @GetMapping("/consumerTest")
    public String consumerTest() {
        // 返回信息
        return restTemplate.getForObject(SERVICE_URL+"/goodsServiceTest",String.class);
    }
}
