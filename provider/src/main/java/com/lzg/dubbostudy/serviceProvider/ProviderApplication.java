package com.lzg.dubbostudy.serviceProvider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘志钢
 */
public class ProviderApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");

    //    context.start();

        System.in.read();
    }

}
