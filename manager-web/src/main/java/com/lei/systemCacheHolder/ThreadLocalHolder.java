package com.lei.systemCacheHolder;

/**
 * Created by lei on 11/30/2016.
 */
public abstract class ThreadLocalHolder {

    private static ThreadLocal<String> clientIpThreadLocal=new ThreadLocal<String>();

    public static void clientIp(String clientIp){
        clientIpThreadLocal.set(clientIp);
    }

    public static String clientIp(){
        return clientIpThreadLocal.get();
    }

}
