package com.carrot.admin.repositroy;

import com.carrot.admin.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


//@DataJpaTest
@SpringBootTest
@ExtendWith(SpringExtension.class)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void created(){
        Category category = new Category();
        category.setTitle("카테고리");
        category.setType("A");
        //category.setId(1L);
        //category.setCreatedAt(LocalDateTime.now());

        Category newCategory = categoryRepository.save(category);
        //Assertions.assertTrue(newCategory.getId().is);
        assertThat(newCategory.getId()).isNotNull();

    }

    @Test
    public void read(){
        created();

        Optional<Category> category = categoryRepository.findById(1L);
        category.ifPresent(selectCategory -> assertThat(selectCategory.getId()).isEqualTo(1L));
    }

    @Test
    public void updated(){
        created();

        Optional<Category> selectCategory = categoryRepository.findById(1L);

        selectCategory.ifPresent(selectCategory1 ->
        {
                selectCategory1.setTitle("Title1234");
                selectCategory1.setType("ABCDE");

                Category category1 = categoryRepository.save(selectCategory1);
                System.out.println("category1 == " + category1);
        }
        );
    }
}