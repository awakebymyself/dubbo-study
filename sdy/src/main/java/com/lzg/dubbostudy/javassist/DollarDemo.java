package com.lzg.dubbostudy.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author 刘志钢
 */
public class DollarDemo {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool classPool = ClassPool.getDefault();

        CtClass ctClass = classPool.get("com.lzg.dubbostudy.javassist.Point");

        CtMethod move = ctClass.getDeclaredMethod("move");

        move.insertBefore("{System.out.println($1); }");

        Class aClass = ctClass.toClass();

        Point point = (Point) aClass.newInstance();

        point.move(100,2);

    }
}
