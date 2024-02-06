package com.test.jpatest240109.service;

import com.test.jpatest240109.dto.UserDTO;
import com.test.jpatest240109.dto.UserProductKeyDTO;
import com.test.jpatest240109.entity.User_Entity;
import com.test.jpatest240109.repository.UserProductKeyRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.test.jpatest240109.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User_Entity> getUserData(int user_idx);

    void saveUser(String name, String mail, String password);

    List<User_Entity> getUserDataFindAll();

    void delete(int user_idx);

    void updateUserName(HttpServletRequest request);

    void saveAllUser(HttpServletRequest request);

    Page<User_Entity> pagingFindAll(PageRequest pageRequest);

    @Service
    class UserServiceImpl implements UserService {
        private final UserRepository userRepository;

        private final UserProductKeyRepository userProductKeyJpaRepository;

        @Autowired
        public UserServiceImpl(UserRepository userRepository, UserProductKeyRepository userProductKeyJpaRepository) {
            this.userRepository = userRepository;
            this.userProductKeyJpaRepository = userProductKeyJpaRepository;
        }

        @Override
        public Optional<User_Entity> getUserData(int user_idx) {
            return userRepository.getUserData(user_idx);
        }

        @Override
        public void saveUser(String name, String mail, String password) {
            User_Entity userEntity = User_Entity.builder()
                    .mail(mail)
                    .password(password)
                    .name(name)
                    .build();
            userRepository.userSave(userEntity);
        }

        @Override
        public List<User_Entity> getUserDataFindAll() {
            return userRepository.userFindAll();
        }

        @Override
        public void delete(int user_idx) {
            userRepository.delete(user_idx);
        }

        @Override
        public void updateUserName(HttpServletRequest request) {
            userRepository.userUpdate(request);
        }

        @Override
        public void saveAllUser(HttpServletRequest request) {
            List<UserDTO> userDTOS = new ArrayList<>();
            for(int x=0;x<100;x++){
                UserDTO userDTO = UserDTO.builder()
                        .idx(x+1)
                        .mail("aaa@aaa.com")
                        .name("Park")
                        .password("12345")
                        .build();
                userDTOS.add(userDTO);
            }

            userRepository.saveAllUser(userDTOS);

            List<UserProductKeyDTO> userProductKeyDTOS = new ArrayList<>();
            for(int y=0; y<100;y++){
                UserProductKeyDTO userProductKeyDTO = UserProductKeyDTO.builder()
                        .useYN("Y")
                        .product_idx((long) (115251+1))
                        .user_idx(y+1)
                        .build();
                userProductKeyDTOS.add(userProductKeyDTO);
            }


            userProductKeyJpaRepository.saveAllUser(userProductKeyDTOS);

        }

        @Override
        public Page<User_Entity> pagingFindAll(PageRequest pageRequest) {
            return userRepository.pagingFindAll(pageRequest);
        }
    }
}
