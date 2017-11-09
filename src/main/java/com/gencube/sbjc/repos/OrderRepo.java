package com.gencube.sbjc.repos;

import com.gencube.sbjc.models.Order;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gencube
 */
public interface OrderRepo extends PagingAndSortingRepository<Order, String> {

    public boolean existsByOrderId(String orderId);

    public Order findByOrderId(String orderId);

    public List<Order> removeById(String orderId);

    public long countByGender(boolean gender);

    public Page<Order> findByGender(boolean gender, Pageable pageable);

    void flush();
}
