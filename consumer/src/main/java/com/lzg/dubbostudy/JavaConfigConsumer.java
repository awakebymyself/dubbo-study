package com.lzg.dubbostudy;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘志钢
 */
public class JavaConfigConsumer {

    public static void main(String[] args) throws InterruptedException {

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("demo-consumer");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");
        //        registry.setUsername("aaa");
        //        registry.setPassword("bbb");


        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<GreetingService> reference = new ReferenceConfig<>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(GreetingService.class);
     //   reference.setVersion("1.0.0");

        // 和本地bean一样使用xxxService
        GreetingService greetingService = reference.get(); // 注意：此代理对

        String hello = greetingService.sayHello("mao mao");

        System.out.println(hello);

        TimeUnit.DAYS.sleep(100);
    }
}
