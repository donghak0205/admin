package com.carrot.admin.service;

import com.carrot.admin.ifs.CrudInterface;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public abstract class BaseService<req, res, Entity> implements CrudInterface<req,res> {

    @Autowired
    protected JpaRepository<Entity,Long> baseRepository;
//
//    @Autowired
//    private BaseService(JpaRepository<Entity, Long> baseRepository) {
//        this.baseRepository = baseRepository;
//    }


    //서비스 로직에서 직접작성하기 때문에 구현할 필요가 없다.
//    @Override
//    public Header<res> create(Header<req> request) {
//        return null;
//    }
//
//    @Override
//    public Header<res> read(Long id) {
//        return null;
//    }
//
//    @Override
//    public Header<res> update(Header<req> request) {
//        return null;
//    }
//
//    @Override
//    public Header<res> delete(Long id) {
//        return null;
//    }
}
