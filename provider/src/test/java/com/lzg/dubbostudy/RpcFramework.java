//package com.lzg.dubbostudy;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @author 刘志钢
// */
//public class RpcFramework {
//
//    @SuppressWarnings("unchecked")
//    public static <T> T refer(final Class<T> tClass, final String host, final int port) {
//        if (tClass == null) {
//            throw new IllegalArgumentException("Class不能为空!");
//        }
//        if (!tClass.isInterface()) {
//            throw new IllegalArgumentException("Class必须为接口!");
//        }
//        if (host == null || host.length() == 0) {
//            throw new IllegalArgumentException("host不能为空!");
//        }
//        if (port <=0 || port >65535) {
//            throw new IllegalArgumentException("port必须在0到65535中间");
//        }
//
//        System.out.println("Get Remoting Service" + tClass.getName() + "from server" + host + ":" + port);
//
//        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, (proxy, method, args) -> {
//            Socket clientSocket = new Socket(host, port);
//
//            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
//            outputStream.writeUTF(method.getName());
//            outputStream.writeObject(method.getParameterTypes());
//            outputStream.writeObject(args);
//
//            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
//            Object result = inputStream.readObject();
//
//            outputStream.close();
//            inputStream.close();
//
//            if (result instanceof Throwable) {
//                throw (Throwable) result;
//            }
//            return result;
//        });
//    }
//
//    public static void export(Object service, int port) {
//        if (service == null) {
//            throw new IllegalArgumentException("service不能为空!");
//        }
//        if (port <=0 || port >65535) {
//            throw new IllegalArgumentException("port必须在0到65535中间");
//        }
//        System.out.println("Export service " + service.getClass().getName() + " on port " + port);
//        try {
//            ServerSocket serverSocket = new ServerSocket(port);
//            for (;;) {
//                Socket clientSocket = serverSocket.accept();
//                System.out.println("收到一个新的连接");
//                new Thread(() -> {
//                    try {
//                        try (ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream())) {
//                            String methodName = inputStream.readUTF();
//                            Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
//                            Object[] arguments = (Object[]) inputStream.readObject();
//
//                            ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
//
//                            Method method = service.getClass().getMethod(methodName, parameterTypes);
//                            try {
//                                Object invoke = method.invoke(service, arguments);
//                                output.writeObject(invoke);
//
//                            } catch (IllegalAccessException e) {
//                                output.writeObject(e);
//                            } catch (InvocationTargetException e) {
//                                e.printStackTrace();
//                            } finally {
//                                output.close();
//                            }
//                        } catch (ClassNotFoundException | NoSuchMethodException e) {
//                            e.printStackTrace();
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
