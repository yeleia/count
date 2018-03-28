package cn.sicau.count.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yelei
 * @date 18-3-28
 */
@Controller
public class Test {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "dfdgj";
    }
}
