package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("{name}")
    public String helloWithPathVariable(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action='/hello'>" +
                        "<input type = 'text' name='name' />" +
                        "<input type = 'submit' value='Greet Me!'/>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;

    }
}
