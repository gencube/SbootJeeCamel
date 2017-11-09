package com.gencube.sbjc.repos;

import com.gencube.sbjc.models.Customer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gencube
 */
public interface CustomerRepo extends PagingAndSortingRepository<Customer, String> {

    public boolean existsById(String id);

    public Customer findById(String id);

    public List<Customer> removeById(String id);

    public long countByGender(boolean gender);

    public Page<Customer> findByGender(boolean gender, Pageable pageable);

    void flush();
}
