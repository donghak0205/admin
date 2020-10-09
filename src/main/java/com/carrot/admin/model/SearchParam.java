package com.carrot.admin.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SearchParam {

    String account;
    String email;
    int page;

}
