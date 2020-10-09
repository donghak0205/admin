package com.carrot.admin.repositroy;

import com.carrot.admin.model.entity.Item;
import com.carrot.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@DataJpaTest
class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    @DisplayName("save Test입니다")
    public void created(){
        OrderDetail orderDetail = new OrderDetail();
        //orderDetail.setItemId(1L);
       // orderDetail.setOrderAt(LocalDateTime.now());
        //orderDetail.setUserId(2L);

        OrderDetail newOrderDetail1 = orderDetailRepository.save(orderDetail);

        assertThat(newOrderDetail1).isNotNull();

    }

    @Test
    public void read(){
        created();
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);

        orderDetail.ifPresent(selectItem -> org.assertj.core.api.Assertions.assertThat(selectItem.getId()).isEqualTo(1L));

    }

    @Test
    public void updated(){
        created();
        Optional<OrderDetail> item = orderDetailRepository.findById(1L);
        item.ifPresent(selectItem->
                {
                    //selectItem.setUserId(3L);
                    //selectItem.setItemId(99L);
                    //selectItem.setOrderAt(LocalDateTime.now());

                }
        );

    }

    @Test
    public void deleted(){
        created();
        Optional<OrderDetail> item = orderDetailRepository.findById(1L);
        item.ifPresent(selectItem->{
            orderDetailRepository.delete(selectItem);
        });

    }

}