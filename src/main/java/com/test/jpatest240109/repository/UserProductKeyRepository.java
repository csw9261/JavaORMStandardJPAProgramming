package com.test.jpatest240109.repository;

import com.test.jpatest240109.dto.UserProductKeyDTO;
import com.test.jpatest240109.entity.UserProductKeyEntity;
import com.test.jpatest240109.repository.jpaRepository.UserProductKeyJpaRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface UserProductKeyRepository {
    void saveAllUser(List<UserProductKeyDTO> userProductKeyDTOList);

    @Repository
    @Slf4j
    @Builder
    class UserProductKeyRepositoryImpl implements UserProductKeyRepository {

        private final UserProductKeyJpaRepository userProductKeyJpaRepository;

        @Autowired
        public UserProductKeyRepositoryImpl(UserProductKeyJpaRepository userProductKeyJpaRepository) {
            this.userProductKeyJpaRepository = userProductKeyJpaRepository;
        }


        @Override
        public void saveAllUser(List<UserProductKeyDTO> userProductKeyDTOList) {
            List<UserProductKeyEntity> userProductKeyEntityList = new ArrayList<>();
            for(UserProductKeyDTO userProductKeyDTO : userProductKeyDTOList) {
                UserProductKeyEntity userProductKeyEntity = new UserProductKeyEntity();
                UserEntity userEntity = new UserEntity();
                userProductKeyEntityList.add(userProductKeyEntity.convertUserProductKeyEntity(userProductKeyDTO ));

            }
            userProductKeyJpaRepository.saveAll(userProductKeyEntityList);

        }
    }

}
