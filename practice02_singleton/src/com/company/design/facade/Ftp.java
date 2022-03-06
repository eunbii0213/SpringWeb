package com.company.design.facade;

public class Ftp {

    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path){
        this.host = host;
        this.path = path;
        this.port = port;
    }

    public void connect(){
        System.out.println("FTP host :"+host+" port : "+port);
    }

    public void disConnect(){
        System.out.println("FTP 연결 종료");
    }

    public void moveDirectory(){
        System.out.println("path : "+path+"로 move");}
}
