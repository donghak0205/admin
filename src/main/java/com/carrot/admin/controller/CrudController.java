package com.carrot.admin.controller;

import com.carrot.admin.ifs.CrudInterface;
import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.response.UserApiResponse;
import com.carrot.admin.service.BaseService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//자신이 받은 파라미터를 전달해줘야 하므로 제네릭 Type으로 선언하였습니다.
//public abstract class CrudController<req,res> implements CrudInterface<req,res> {
@Component
@NoArgsConstructor
@Slf4j
public abstract class CrudController<req,res,entity> implements CrudInterface<req,res> {
    //protected는 상속받는 클래스에서만 정의할 수 있다.
    //protected CrudInterface<req,res> baseService; //예를들어 UserApiLogicService는 crudInterface를 상속받기때문에 baseService로 설정해줍니다.
    @Autowired
    protected BaseService<req,res,entity> baseService;//예를들어 UserApiLogicService는 crudInterface를 상속받기때문에 baseService로 설정해줍니다.

    @Override
    @GetMapping
    public Header<List<UserApiResponse>> search(@PageableDefault(sort="id", size = 10) Pageable pageable){
        System.out.println("aaaa");
        log.info("{}",pageable);
        return baseService.search(pageable);

    }


    @Override
    @PostMapping
    public Header<res> create(@RequestBody Header<req> request) {
        return baseService.create(request);
        //return null;
    }

    @Override
    @GetMapping("{id}")
    public Header<res> read(@PathVariable Long id) {
        System.out.println("id === " + id);
        return baseService.read(id);
    }

    @Override
    @PutMapping
    public Header<res> update(@RequestBody Header<req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<res> delete(@PathVariable Long id) {
        return baseService.delete(id);
        //return null;
    }
}

