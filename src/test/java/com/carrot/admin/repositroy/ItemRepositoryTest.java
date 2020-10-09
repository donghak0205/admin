package com.carrot.admin.repositroy;

import com.carrot.admin.model.entity.Item;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.asm.Advice;
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

@SpringBootTest
//@DataJpaTest
@ExtendWith(SpringExtension.class)
class ItemRepositoryTest {
    
    @Autowired
    private ItemRepository itemRepository;


    @Test
    @DisplayName("save 테스트")
    public void crated(){

        Item item = new Item();
        item.setName("당근");
        item.setContent("당근주스");
        //item.setPrice(111);
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("DH");

        Item newItem = itemRepository.save(item);
        assertThat(newItem.getId()).isNotNull();

    }

    @Test
    @DisplayName("select 테스트")
    public void read(){
        crated();
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectItem -> Assertions.assertThat(selectItem.getId()).isEqualTo(1L));
    }

    @Test
    public void updated(){
        crated();
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectItem->
                {
                    //selectItem.setPrice(2000);
                    selectItem.setContent("당근파이");
                    selectItem.setUpdatedAt(LocalDateTime.now());
                    selectItem.setUpdatedBy("Lee");
                }
        );

    }

    @Test
    public void deleted(){
        crated();
        Optional<Item> item = itemRepository.findById(3L);
        item.ifPresent(selectItem->{
            itemRepository.delete(selectItem);
        });

    }
    

}