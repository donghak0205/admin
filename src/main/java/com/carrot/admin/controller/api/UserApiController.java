package com.carrot.admin.controller.api;

import com.carrot.admin.ifs.CrudInterface;
import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.request.UserApiRequest;
import com.carrot.admin.model.network.response.UserApiResponse;
import com.carrot.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest,UserApiResponse> {

    @Autowired
    UserApiLogicService userApiLogicService;

    @Override
    @PostMapping
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
        log.info("{}",userApiRequest);
        return userApiLogicService.create(userApiRequest);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        return null;
    }

    @Override
    @PutMapping
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }


}
