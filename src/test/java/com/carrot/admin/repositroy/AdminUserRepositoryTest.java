package com.carrot.admin.repositroy;

import com.carrot.admin.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AdminUserRepositoryTest {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void created(){

        String account = "Admin";
        String password = "1234";
        String status = "Good";
        String role = "Developer";


        AdminUser adminUser = new AdminUser();

        adminUser.setAccount(account);
        adminUser.setPassword(password);
        adminUser.setStatus(status);
        adminUser.setRole(role);

        adminUser.setRole("11").setRole("aa");
        adminUserRepository.save(adminUser);




    }


}