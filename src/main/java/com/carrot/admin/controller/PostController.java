package com.carrot.admin.controller;

import com.carrot.admin.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PostController {

    //Form <form>
    //ajax 검색
    //-> 여기에 사용된다는것은 검색 parameter가 많다는것이다.
    //post는 http통신을 할때 body에다가 data를 집어넣어서 통신을 한다.
    //post에서 requst를 받을때는 json, xml, multipart-form / text-plain 등으로 할 수 있다.


    @PostMapping("/postMethod" )
    public SearchParam postMethod(@RequestBody SearchParam searchParam){ //Post는 RequestBody를 사용해서 한다.

        System.out.println("ok!");
        return searchParam;
    }
}

