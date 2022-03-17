package com.sda.hibernate.service;

import com.sda.hibernate.dao.OrderDao;
import com.sda.hibernate.model.Cart;
import com.sda.hibernate.model.Order;
import com.sda.hibernate.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceImplTest {

    private final static Product product1 = Product.builder()
             .price(BigDecimal.valueOf(500))
             .build();
    private final static Product product2 = Product.builder()
            .price(BigDecimal.valueOf(1000))
            .build();


    OrderService orderService;
    private final static Order order = new Order(
            1,
            LocalDateTime.now(),
            BigDecimal.valueOf(0),
            null,
            Set.of(
                    new Cart(null, product1, 2),
                    new Cart(null, product2, 1)
            )
    );

    @Test
    void shouldCalculateOrderPrice() {
        //given
        //orderService = new OrderServiceImpl(new LocalOrderDao());
        orderService = new OrderServiceImpl(id -> order);
        //when
        Order result = orderService.reCalculateOrderPrice(1);
        //then
        assertThat(result.getPrice()).isEqualTo(BigDecimal.valueOf(2000.0));
    }

    class LocalOrderDao implements OrderDao {
        @Override
        public Order findByIdWithReferences(int id) {
            return order;
        }
    }

}
