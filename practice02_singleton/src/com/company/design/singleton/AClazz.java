package com.company.design.singleton;

import java.net.Socket;

public class AClazz {

    private SocketClient socketClient;
    public AClazz(){
        this.socketClient = SocketClient.getInstance();
        //다르게 하려면 SocketClient에 있는 socketClient를 public으로 바꾸고
        //AClazz, BClazz 생성자 내용을 this.socketClient = new SocketClient();
    }
    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
