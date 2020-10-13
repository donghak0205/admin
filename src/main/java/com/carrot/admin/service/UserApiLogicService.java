package com.carrot.admin.service;

import com.carrot.admin.ifs.CrudInterface;
import com.carrot.admin.model.entity.User;
import com.carrot.admin.model.enumclass.UserStatus;
import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.Pagination;
import com.carrot.admin.model.network.request.UserApiRequest;
import com.carrot.admin.model.network.response.UserApiResponse;
import com.carrot.admin.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
//public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User>{

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public Header<List<UserApiResponse>> search(Pageable pageable) {
        System.out.println("pageable !!! === " + pageable);

        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList = users.stream()
                                                    .map(user->response(user))
                                                    .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                               .totalPages(users.getTotalPages())
                               .totalElements(users.getTotalElements())
                               .currentPage(users.getNumber())
                               .currentElements(users.getNumberOfElements())
                               .build();

        //return Header.OK(userApiResponseList);
        return Header.OK(userApiResponseList,pagination);
    }

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
                   //.status("REGISTERED")
                   .status(UserStatus.REGISTERED)
                   .phoneNumber(userApiRequest.getPhoneNumber())
                   .email(userApiRequest.getEmail())
                   .registeredAt(LocalDateTime.now())
                   .build();

        //User newUser = userRepository.save(user);
        User newUser = baseRepository.save(user);
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        //return userRepository.findById(id)
        return baseRepository.findById(id)
                .map(user -> response(user)) //map이라는것은 다른 return 형태로 바꾸는것
                .map(userApiResponse -> Header.OK(userApiResponse))
                .orElseGet( //값이 없다면
                        ()->Header.ERROR("데이터 없음")
                );

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        //Request Data get
        UserApiRequest userApiRequest = request.getData();

        //update Data get(id)
        //Optional<User> optional = userRepository.findById(userApiRequest.getId());
        Optional<User> optional = baseRepository.findById(userApiRequest.getId());


        //Update
        return optional.map(user-> {

            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt())
            ;

            return user;
            //update

        }).map(user -> baseRepository.save(user))       //update commit
          .map(updateUser -> response(updateUser))      //userApiResponse Create
          //.map(userApiResponse -> Header.OK(userApiResponse))
          .map(Header::OK)
          .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {

       // Optional<User> optional = userRepository.findById(id);
        Optional<User> optional = baseRepository.findById(id);

       return optional.map(user->{

           //userRepository.deleteById(id);
           baseRepository.deleteById(id);
           return Header.OK();

       }).orElseGet(()->Header.ERROR("데이터가 없습니다."));

    }

    //private Header<UserApiResponse> response(User user){
    private UserApiResponse response(User user){

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
        //return Header.OK(userApiResponse);
        return userApiResponse;
    }
}

