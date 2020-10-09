package com.carrot.admin.model.network.request;


import lombok.*;


@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApiRequest {

    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

}
