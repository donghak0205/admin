package com.carrot.admin.model.network;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {

    //api 통신시간
    private LocalDateTime transactionTime;

    //api 응답코드
    private String resultCode;


    //api 부가설명
    private String description;

    private T data;


    //(Response) OK
    public static <T> Header<T> OK(){
        return (Header<T>) Header.builder() //Header<T>으로 형변환
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //(Response) DATA OK
    public static <T> Header<T> OK(T data){
        return (Header<T>) Header.builder() //Header<T>으로 형변환
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }


//
//    // DATA OK
//    public static <T> Header<T> OK(T data){
//        return (Header<T>)Header.builder()
//                .transactionTime(LocalDateTime.now())
//                .resultCode("OK")
//                .description("OK")
//                .data(data)
//                .build();
//    }
    //(Response) DATA ERROR
    public static <T> Header<T> ERROR(String description){ //description은 그때그때마다 바뀔수가 있다.
        return (Header<T>) Header.builder() //Header<T>으로 형변환
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description) //어떠한 에러때문에 안된다고 말해주기위해서 이다.
                .build();
    }


}
