package com.carrot.admin.model.network;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Pagination {

    private Integer totalPages;
    private Long totalElements;
    private Integer currentPage; //현재페이지
    private Integer currentElements;//현재페이지에 몇개의 데이터가 왔는지
}
