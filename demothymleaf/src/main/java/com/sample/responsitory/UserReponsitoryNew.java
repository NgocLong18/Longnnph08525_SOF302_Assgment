package com.sample.responsitory;

import com.sample.model.Staffs;
import com.sample.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitoryNew extends PagingAndSortingRepository<Users, String> {
}
