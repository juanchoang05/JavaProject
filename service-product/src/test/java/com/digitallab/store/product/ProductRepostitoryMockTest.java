package com.digitallab.store.product;

import com.digitallab.store.product.entity.Category;
import com.digitallab.store.product.entity.Product;
import com.digitallab.store.product.repository.CategoryRepository;
import com.digitallab.store.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepostitoryMockTest {
    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Test
    public void whenFindByCategory_thenReturnListProduct(){

        int ls = categoryRepository.findAllBy().size();

        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .descripcion("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);
    }

}
