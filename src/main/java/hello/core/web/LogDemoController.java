package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;    // 프록시

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {

        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());

        MyLogger myLogger = myLoggerProvider.getObject();   // 이 시점에서 만들어짐

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");

        Thread.sleep(1000);

        logDemoService.logic("testId");
        return "OK";
    }




}

