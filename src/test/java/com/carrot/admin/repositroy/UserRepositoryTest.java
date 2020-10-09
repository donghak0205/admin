package com.carrot.admin.repositroy;

import com.carrot.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@DataJpaTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    public void crated(){
        //String sql = insert into user(...);

        User user = new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-111-111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        assertThat(newUser.getId()).isNotNull();

    }

    @Test
    @Transactional
    public void read(){
        //crated();
        Optional<User> user = userRepository.findById(5L);
        //user.ifPresent(selectUser -> System.out.println("selectUser ==" + selectUser));

//        user.ifPresent(selectUser ->
//                selectUser.getOrderDetailList().stream().forEach(
//                        detail -> System.out.println("aaa === " +detail.getItem() + "   " + detail.getUser())
//                )
//
//        );
    }

    @Test
    public void updated(){
        crated();
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser->
                {
                    selectUser.setPhoneNumber("12345");
                    selectUser.setEmail("abc@gmail.com");
                    selectUser.setUpdatedAt(LocalDateTime.now());
                    selectUser.setUpdatedBy("update method()");
                }
                );

    }

    @Test
    public void deleted(){
        crated();
        Optional<User> user = userRepository.findById(3L);
        user.ifPresent(selectUSer->{
            userRepository.delete(selectUSer);
        });

    }



}