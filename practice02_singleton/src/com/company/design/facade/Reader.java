package com.company.design.facade;

public class Reader {
    private String fileName;
    public Reader(String fileName){
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Reader %s로 연결",fileName);
        System.out.println(msg);
    }

    public void fileRead(){
        String msg = String.format("Reader %s의 내용 읽음",fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("Reader %s로 연결종료",fileName);
        System.out.println(msg);
    }
}