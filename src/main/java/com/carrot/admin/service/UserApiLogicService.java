package com.carrot.admin.service;

import com.carrot.admin.ifs.CrudInterface;
import com.carrot.admin.model.entity.User;
import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.request.UserApiRequest;
import com.carrot.admin.model.network.response.UserApiResponse;
import com.carrot.admin.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;


    //created 해야할것
    //1. request data
    //2. request 기반의 user 생성
    //3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        //1. request data
        UserApiRequest userApiRequest = request.getData();

        //2. User 생성
        User user = User.builder()
                   .account(userApiRequest.getAccount())
                   .password(userApiRequest.getPassword())
                   .status("REGISTERED")
                   .phoneNumber(userApiRequest.getPhoneNumber())
                   .email(userApiRequest.getEmail())
                   .registeredAt(LocalDateTime.now())
                   .build();

        User newUser = userRepository.save(user);
        //UserApiResponse userApiResponse = new UserApiResponse(user);
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user){

        //User -> UserApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                                         .id(user.getId())
                                         .account(user.getAccount())
                                         .password(user.getPassword())
                                         .email(user.getEmail())
                                         .phoneNumber(user.getPhoneNumber())
                                         .status(user.getStatus())
                                         .registeredAt(user.getRegisteredAt())
                                         .unregisteredAt(user.getUnregisteredAt())
                                         .build();
        //HEADER + Data를 return하기 위해서 Header.Ok를 사용합니다.
        System.out.println("aaaaaaa === " + userApiResponse);
        return Header.OK(userApiResponse);
    }
}
