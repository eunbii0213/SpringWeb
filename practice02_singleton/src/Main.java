import com.company.design.adapter.*;
import com.company.design.aop.AOPBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.CBrowser;
import com.company.design.proxy.Html;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        /*AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient a = aClazz.getSocketClient();
        SocketClient b = bClazz.getSocketClient();

        //객체가 동일한지 비교할 때는 equals() 사용

        System.out.println(a.equals(b));
        */

        /*
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(adapter);
        connect(airAdapter);
        */


        /*
        CBrowser browser = new CBrowser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        System.out.println();

        BrowserProxy proxy = new BrowserProxy("www.google.com");
        proxy.show();
        proxy.show();
        proxy.show();
        proxy.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        Browser aop = new AOPBrowser("www.acmicpc.net",()->{
            System.out.println("before");
            start.set(System.currentTimeMillis());
        },()->{
            System.out.println("end");
            long now = System.currentTimeMillis();
            end.set(now-start.get());
        });

        aop.show();
        System.out.println("loading time : " + end.get());


        aop.show();
        System.out.println("loading time : " + end.get());
        */

        /*
        Icar audi = new Audi(1000);
        audi.showPrice();

        //a3
        Icar audi3 = new A3(audi,"A3");
        audi3.showPrice();
        //a4

        Icar audi4 = new A4(audi,"A4");
        audi4.showPrice();

        //a5
        Icar audi5 = new A5(audi,"A5");
        audi5.showPrice();
        */

        /*
        Button button = new Button("button");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("click!");
         */

        /*
        Ftp client = new Ftp("www.foo.co.kr",22,"/home/ect");
        client.connect();
        client.moveDirectory();

        Writer w = new Writer("text.tmp");
        w.fileConnect();
        w.write();

        Reader r = new Reader("text.tmp");
        r.fileConnect();
        r.fileRead();

        r.fileDisconnect();
        w.fileDisconnect();
        client.disConnect();

        SftpClient ftp = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
        ftp.connect();
        ftp.write();
        ftp.read();
        ftp.disConnect();

        */
        //base64
        EncodingStrategy base64 = new Base64Strategy();

        //Normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "java";
        Encoder encoder = new Encoder();
        encoder.setEncodingStrategy(base64);
        String result = encoder.getMessage(message);

        System.out.println(result);

        encoder.setEncodingStrategy(normal);
        result = encoder.getMessage(message);

        System.out.println(result);

        encoder.setEncodingStrategy(new AppendStrategy());
        result = encoder.getMessage(message);
        System.out.println(result);


    }

    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
