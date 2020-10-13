package com.carrot.admin.controller.api;

import com.carrot.admin.controller.CrudController;
import com.carrot.admin.model.entity.User;
import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.request.UserApiRequest;
import com.carrot.admin.model.network.response.UserApiResponse;
import com.carrot.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
//public class UserApiController implements CrudInterface<UserApiRequest,UserApiResponse> {
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User> {

    //log.info();

    public UserApiController() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssss");
    }


//    @Autowired
//    UserApiLogicService userApiLogicService;
//
//    @PostConstruct
//    public void init(){
//        this.baseService = userApiLogicService;
//    }

//    @Override
//    @PostMapping
//    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
//        log.info("{}",userApiRequest);
//        return userApiLogicService.create(userApiRequest);
//    }
//
//    @Override
//    @GetMapping("{id}")
//    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
//        return userApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping
//    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
//        log.info("{}",userApiRequest);
//        return userApiLogicService.update(userApiRequest);
//    }
//
//    @Override
//    @DeleteMapping("{id}")
//    public Header<UserApiResponse> delete(@PathVariable Long id) {
//        log.info("delete in");
//        return userApiLogicService.delete(id);
//    }


}
