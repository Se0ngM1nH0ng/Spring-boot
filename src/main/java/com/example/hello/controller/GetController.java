package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping(value = "/variable1/{variable}") // url에 바로 값을 넣음
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }
    @GetMapping(value = "/variable2/{variable}") // 매개변수명 안맞을때 이어주는 것
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name , @RequestParam String email, @RequestParam String organization ){
        return name + " " + email + " " + organization;
    }
//    @GetMapping(value = "/request2")
//    public String getRequestParam2(@RequestParam Map<String, String> map){
//        StringBuilder sb = new StringBuilder();
//
//        param.entrySet().forEach(map -> {
//           sb.append(map.getKey() + ":" + map.getValue() + "\n");
//        });
//
//        return sb.toString();
//    }
}
