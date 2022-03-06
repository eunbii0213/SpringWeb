package com.company.design.singleton;

public class SocketClient {
    private static SocketClient socketClient=null;
    private SocketClient(){
    }

    public static SocketClient getInstance(){
        //socket이 null인경우 새로 생성
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }
    public void connect(){
        System.out.println("connect");
    }

}
