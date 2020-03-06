package com.sample.responsitory;

import com.sample.model.Staffs;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffsRepositoryNew extends PagingAndSortingRepository<Staffs, Long> {
}
