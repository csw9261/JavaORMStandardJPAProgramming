package com.test.jpatest240109.entity;
import com.test.jpatest240109.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User_Entity extends BaseEntity{

    @Id @Column(name = "user_idx") @GeneratedValue
    private int idx;

    @Column(name = "password")
    private String password;

    @Column
    private String mail;

    @Column
    private String name;

    public void updateName(String name){
        this.name = name;
    }

    public User_Entity toUserEntity(UserDTO userDTO){
        return User_Entity.builder()
                .name(userDTO.getName())
                .idx(userDTO.getIdx())
                .password(userDTO.getPassword())
                .mail(userDTO.getMail())
                .build();
    }

}