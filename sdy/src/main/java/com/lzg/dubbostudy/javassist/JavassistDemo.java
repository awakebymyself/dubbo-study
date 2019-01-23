package com.lzg.dubbostudy.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;

/**
 * @author 刘志钢
 */
public class JavassistDemo {

    public static void main(String[] args) throws CannotCompileException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("Point");

        Class aClass = ctClass.toClass();
        System.out.println(aClass.getName());
    }

}
