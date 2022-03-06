package com.company.design.aop;

import com.company.design.proxy.Browser;
import com.company.design.proxy.Html;

public class AOPBrowser implements Browser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AOPBrowser(String url, Runnable before, Runnable after){
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();
        if(html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : "+url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();
        System.out.println("AOPBrowser html cache : "+url);
        return html;
    }
}
