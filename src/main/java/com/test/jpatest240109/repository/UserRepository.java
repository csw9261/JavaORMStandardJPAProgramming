package com.test.jpatest240109.repository;

import com.test.jpatest240109.dto.UserDTO;
import com.test.jpatest240109.entity.User_Entity;
import com.test.jpatest240109.repository.jpaRepository.UserJpaRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User_Entity> getUserData(int idx);

    void userSave(User_Entity userEntity);

    List<User_Entity> userFindAll();

    void delete(int idx);

    void userUpdate(HttpServletRequest request);

    void saveAllUser(List<UserDTO> userDTOList);

    Page<User_Entity> pagingFindAll(PageRequest pageRequest);

    @Repository
    @Slf4j
    class UserRepositoryImpl implements UserRepository {

        private final UserJpaRepository userJpaRepository;

        @Autowired
        public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
            this.userJpaRepository = userJpaRepository;
        }

        @Override
        public Optional<User_Entity> getUserData(int idx) {
            return userJpaRepository.findById(idx);
        }

        @Override
        public void userSave(User_Entity userEntity) {
            Optional<User_Entity> optionalUserEntity = userJpaRepository.findById(userEntity.getIdx());
            if(optionalUserEntity.isPresent()){
                log.info("optionalUserEntity is NOT null." + optionalUserEntity.get().toString());

            }else{
                log.info("optionalUserEntity is null.");

            }
            userJpaRepository.save(userEntity);
        }

        @Override
        public List<User_Entity> userFindAll() {
           return userJpaRepository.findAll();
        }

        @Override
        public void delete(int idx) {
            //Optional<User_Entity> optionalUserEntity = userJpaRepository.findById(idx);
            var optionalUserEntity = userJpaRepository.findById(idx);

/*
            optionalUserEntity
                    .ifPresentOrElse(
                            userEntity -> userJpaRepository.deleteById(userEntity.getIdx()),
                            () -> {
                              throw new RuntimeException();
                            }
                    );
*/

            if (optionalUserEntity.isPresent()) {
                var userEntity = optionalUserEntity.get();
                userJpaRepository.deleteById(userEntity.getIdx());
            } else {
                throw new RuntimeException("User with ID " + idx + " not found");
            }
        }

        @Override
        public void userUpdate(HttpServletRequest request) {
            Optional<User_Entity> optionalUserEntity = userJpaRepository.findById(Integer.parseInt(request.getParameter("user_idx")));
            if(optionalUserEntity.isPresent()){
                User_Entity userEntity = optionalUserEntity.get();
                userEntity.updateName(request.getParameter("name"));
                userJpaRepository.save(userEntity);
            }else{
                throw new NullPointerException("optionalUserEntity is null.");
            }
        }

        @Override
        public void saveAllUser(List<UserDTO> userDTOList) {
            List<User_Entity> userEntityList = new ArrayList<>();
            for(UserDTO userDTO : userDTOList){
                User_Entity userEntity = new User_Entity();
                userEntityList.add(userEntity.toUserEntity(userDTO));
            }
            log.info("@@@userEntityList -> " + userEntityList);
            userJpaRepository.saveAll(userEntityList);
        }

        @Override
        public Page<User_Entity> pagingFindAll(PageRequest pageRequest) {
            return userJpaRepository.findAll(pageRequest);
        }
    }
}
