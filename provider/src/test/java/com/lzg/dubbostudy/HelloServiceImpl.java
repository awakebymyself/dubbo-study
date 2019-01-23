package com.lzg.dubbostudy;

/**
 * @author 刘志钢
 */
public class HelloServiceImpl implements Helloservice {
    @Override
    public String hello(String content) {
        return "Hello" + content;
    }

}
