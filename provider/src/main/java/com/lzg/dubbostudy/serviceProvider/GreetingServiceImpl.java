package com.lzg.dubbostudy.serviceProvider;

import com.lzg.dubbostudy.GreetingService;

/**
 * @author 刘志钢
 */
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String name) {
        System.out.println("收到客户端请求：" +name);
        return "hello" + name;
    }

}
