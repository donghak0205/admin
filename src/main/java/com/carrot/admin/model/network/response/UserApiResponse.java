package com.carrot.admin.model.network.response;


import com.carrot.admin.model.enumclass.UserStatus;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApiResponse {

    private Long id;

    private String account;

    private String password; //요청시에는 평문으로 들어오지만 Response시에는 암호화해서 줘야 한다.

    //private String status;
   // @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

}
