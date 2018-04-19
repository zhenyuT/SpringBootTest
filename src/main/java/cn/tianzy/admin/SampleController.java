package cn.tianzy.admin;

import cn.tianzy.admin.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class SampleController {

    @Value("${spring.thymeleaf.prefix: hehe}")
    String thPrefix;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!-Admin!aaa";
    }

    @RequestMapping("/page")
    String page() {
        System.out.println(thPrefix);
        return "admin/index";
    }

    @RequestMapping("/async")
    @ResponseBody
    public DeferredResult<String> async() {
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deferredResult.setResult("hahaha");
            }
        }).start();
        return deferredResult;
    }

    @RequestMapping("/events")
    public ResponseBodyEmitter handle() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    emitter.send("hahah1");
                    Thread.sleep(1000);

                    emitter.send("hahah2");
                    Thread.sleep(1000);

                    emitter.send("hahah3");
                    Thread.sleep(1000);

                    emitter.complete();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return emitter;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}