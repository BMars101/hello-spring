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

//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String createMessage(@RequestParam String name, @RequestParam String language){
        String greeting = "";
        if(language.equals("English")){
            greeting = "Hello";
        } else if(language.equals("German")){
            greeting = "Hallo";
        }else if(language.equals("Italian")){
            greeting = "Ciao";
        }else if(language.equals("Spanish")){
            greeting = "Hola";
        }else if(language.equals("Finnish")){
            greeting = "Hei";
        }
        return greeting + ", " + name + "!";
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
                        "<select name='language' id='language-select'>" +
                        "<option value='English'>English</option>" +
                        "<option value='German'>German</option>" +
                        "<option value='Italian'>Italian</option>" +
                        "<option value='Spanish'>Spanish</option>" +
                        "<option value='Finnish'>Finnish</option>" +
                        "<input type = 'submit' value='Greet Me!'/>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;

    }
}
