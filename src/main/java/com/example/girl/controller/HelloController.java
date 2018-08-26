package com.example.girl.controller;


import com.example.girl.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="hello")
public class HelloController {

    @Autowired
    private Girl girl;

    @RequestMapping(value="say")
    public String say(){

        return "Say Hello World!" +girl.getName() + girl.getCupSize() +girl.getAge();
    }

    @RequestMapping(value="say/{xi}")
    public String sayAdvice(@PathVariable("xi") String xi){
        System.out.println(xi);
        return "SayAdvice Hello World!" ;
    }

    @RequestMapping(value="eat")
    public String eat(@RequestParam("xi") String myXi){
        System.out.println(myXi);
        return "Eat Hello World!";
    }
}
