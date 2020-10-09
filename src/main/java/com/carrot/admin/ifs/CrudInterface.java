package com.carrot.admin.ifs;

import com.carrot.admin.model.network.Header;
import com.carrot.admin.model.network.request.UserApiRequest;
import com.carrot.admin.model.network.response.UserApiResponse;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);

}
