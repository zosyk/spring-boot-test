package spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.model.StackOverflowWebSite;
import spring.boot.service.StackOverflowService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by alex on 30.03.17.
 */
@Controller
@RequestMapping("/api")
public class StackOverFlowController {

    @Autowired
    StackOverflowService stackOverflowService;

    @RequestMapping("/hello-world")
    public String helloWorld() {

        return "hello-world";
    }

    @RequestMapping("/stackoverflow")
    @ResponseBody
    public List<StackOverflowWebSite> getListOfProviders(/*HttpServletResponse response*/) {
//        response.addHeader("Access-Control-Allow-Origin", "*");

        return stackOverflowService.findAll();
    }
}
