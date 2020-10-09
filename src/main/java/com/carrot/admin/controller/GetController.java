package com.carrot.admin.controller;


import com.carrot.admin.model.SearchParam;
import com.carrot.admin.model.network.Header;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetController {

    @GetMapping("/getMethod")
    public String getMethod(){
        String password = "12345"; //지역내 변순에 미리 패스워드를 사용할 수 있다.

        return password;
    }


    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id , @RequestParam(name="password") String pw){
        String password = "12345"; //지역내 변순에 미리 패스워드를 사용할 수 있다.

        return id+ " " + pw;
    }

    @GetMapping("/getMultiParameter")
    //public String getMultiParameter(SearchParam searchParam){
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println("Accoount === " + searchParam.getAccount());
        System.out.println("Email === " + searchParam.getEmail());
        System.out.println("Page === " + searchParam.getPage());

        //return "OK!!!";
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){
        return Header.builder()
                .resultCode("OK")
                .description("YES")
                .build();
    }
}
