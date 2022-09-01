package com.example.cosumer.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @program: cosumer
 * @description:
 * @Author: 曹红亮
 * @create: 2022-08-30 16:10
 **/
@RestController
public class ConsumerController {
    private final  String MTH_URL="http://33091f9t08.zicp.fun:21469/api/books";
    private final  String STF_URL="http://2imtpy.natappfree.cc/test1";
    private final  String SYK_URL="http://uqc82x.natappfree.cc/api/searching";
    private final  String CHL_URL="http://yucvsa.natappfree.cc/api/getbook?bookName=aaa&number=123";
    @Resource
    private RestTemplate restTemplate;

    private WebClient webClient = WebClient.builder().baseUrl(STF_URL).build();

    @GetMapping("httpClientTest")
    public String httpClientTest() throws IOException {
        CloseableHttpClient httpClient  = org.apache.http.impl.client.HttpClients.createDefault();
        HttpGet GetMTH = new HttpGet(MTH_URL);
        HttpGet GetSYK = new HttpGet(SYK_URL);
        HttpGet GetCHL = new HttpGet(CHL_URL);
        CloseableHttpResponse execute = null;
        try {
            execute = httpClient.execute(GetSYK);
            // 判断状态码
            if(execute.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(execute.getEntity(), "UTF-8");
                System.out.println("沈永康的結果"+result);
                execute = httpClient.execute(GetMTH);
                String result2 = EntityUtils.toString(execute.getEntity());
                System.out.println("馬天浩的結果"+result2);
                execute = httpClient.execute(GetCHL);
                String result3 = EntityUtils.toString(execute.getEntity());
                System.out.println("曹紅亮的結果"+result3);
            }
        } finally {
            if (execute != null){
                execute.close();
            }
            httpClient.close();
        }
        return "成功";
    }

    @GetMapping("restTemplateTest")
    public String restTemplateTest() {
        System.out.println(restTemplate.getForObject(MTH_URL,String.class));
        return "馬天浩的URL";
    }

    @GetMapping("retTemplateTest")
    public String HttpClients()throws IOException {
        Mono<String> STFURL = webClient.get().uri("").retrieve().bodyToMono(String.class);
        System.out.println("申騰飛的URL"+STFURL);
        return "成功";
    }
}
