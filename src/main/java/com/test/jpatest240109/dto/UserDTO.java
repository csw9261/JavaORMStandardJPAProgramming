package com.test.jpatest240109.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.jpatest240109.entity.User_Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int idx;
    private String password;
    private String mail;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;

    public UserDTO toUserDTO(User_Entity userEntity){
        if(userEntity == null) {
            return null;
        }else{
            return UserDTO.builder()
                    .createdDate(userEntity.getCreatedDate())
                    .modifiedDate(userEntity.getModifiedDate())
                    .idx(userEntity.getIdx())
                    .password(userEntity.getPassword())
                    .mail(userEntity.getMail())
                    .name(userEntity.getName())
                    .build();
        }
    }
}
