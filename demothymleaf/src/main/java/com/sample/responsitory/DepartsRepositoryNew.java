package com.sample.responsitory;

import com.sample.model.Departs;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartsRepositoryNew extends PagingAndSortingRepository<Departs, Long> {
}
