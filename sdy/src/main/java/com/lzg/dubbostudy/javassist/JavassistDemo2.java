package com.lzg.dubbostudy.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author 刘志钢
 */
public class JavassistDemo2 {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        //  Hello hell = new Hello();
        System.out.println(System.getProperty("java.class.path"));

        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.lzg.dubbostudy.javassist.Hello");
        CtMethod ctMethod = ctClass.getDeclaredMethod("say");
        ctMethod.insertBefore("{System.out.println(\"Hello.say()\");}");
        Class aClass = ctClass.toClass();

        Hello hello = (Hello) aClass.newInstance();
        hello.say();
    }

}
