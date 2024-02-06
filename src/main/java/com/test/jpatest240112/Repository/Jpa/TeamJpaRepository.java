package com.test.jpatest240112.Repository.Jpa;

import com.test.jpatest240112.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJpaRepository extends JpaRepository<TeamEntity, Integer> {
}
