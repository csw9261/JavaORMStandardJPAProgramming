package com.test.jpatest240109.repository.jpaRepository;

import com.test.jpatest240109.entity.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User_Entity, Integer> {

}
