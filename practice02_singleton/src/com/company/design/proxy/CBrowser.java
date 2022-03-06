package com.company.design.proxy;

public class CBrowser {

    private String url;
    public CBrowser(String url){
        this.url = url;
    }

    public Html show(){
        System.out.println("browser loading html from : "+url);
        return new Html(url);
    }
}
