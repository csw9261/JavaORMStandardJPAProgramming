package com.test.jpatest240109.repository.jpaRepository;

import com.test.jpatest240109.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJpaRepository extends JpaRepository<TeamEntity, Integer> {
}
