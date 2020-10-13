package com.carrot.admin.ifs;

import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.response.UserApiResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudInterface<Req, Res> {

    Header<List<UserApiResponse>> search(Pageable pageable);

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);

}
