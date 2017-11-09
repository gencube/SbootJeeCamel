package com.gencube.sbjc.repos;

import com.gencube.sbjc.models.Order;
import com.gencube.sbjc.models.OrderItems;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gencube
 */
public interface OrderItemsRepo extends PagingAndSortingRepository<OrderItems, String> {

    public boolean existsById(String id);

    public OrderItems findById(String id);

    public List<OrderItems> removeById(String id);

    public long countByOrderId(String orderId);

    public List<OrderItems> findByOrderId(String orderId);

    public List<OrderItems> removeByOrderId(String orderId);

    public long countByCustomerId(String customerId);

    public List<Order> findByCustomerId(String customerId);

    void flush();
}
