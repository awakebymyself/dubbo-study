package com.lzg.dubbostudy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘志钢
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("service-consumer.xml");
        //context.start();
        // obtain proxy object for remote invocation
        GreetingService demoService = (GreetingService) context.getBean("greetingService");
        // execute remote invocation
        String hello = demoService.sayHello("mao mao");

        System.out.println(hello);

    }
}
