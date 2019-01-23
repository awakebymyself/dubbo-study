//package com.lzg.dubbostudy;
//
///**
// * Hello world!
// *
// */
//public class App
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
//
//    public Object invokeMethod(Object o, String n, Class[] p, Object[] v) throws java.lang.reflect.InvocationTargetException{
//        com.lzg.dubbostudy.GreetingService w;
//        try{ w = ((com.lzg.dubbostudy.GreetingService)$1);
//        }catch(Throwable e){
//            throw new IllegalArgumentException(e); }
//        try{
//            if( "sayHello".equals( $2 )  &&  $3.length == 1 ) {
//                return ($w)w.sayHello((java.lang.String)$4[0]);
//            }
//        } catch(Throwable e) {
//            throw new java.lang.reflect.InvocationTargetException(e);  }
//            throw new com.alibaba.dubbo.common.bytecode.NoSuchMethodException("Not found method \""+$2+"\" in class com.lzg.dubbostudy.GreetingService."); }
//
//
//    public void setPropertyValue(Object o, String n, Object v){
//        com.lzg.dubbostudy.GreetingService w;
//        try{ w = ((com.lzg.dubbostudy.GreetingService)$1);
//        }catch(Throwable e){
//            throw new IllegalArgumentException(e); }
//            throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \""+$2+"\" filed or setter method in class com.lzg.dubbostudy.GreetingService."); }
//
//}
