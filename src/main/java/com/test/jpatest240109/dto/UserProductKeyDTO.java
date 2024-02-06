package com.test.jpatest240109.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.jpatest240109.entity.UserProductKeyEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProductKeyDTO {
    private Long product_idx;
    private String useYN;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;

    private int user_idx;

    public UserProductKeyDTO convertUserProductKeyDTO(UserProductKeyEntity userProductKeyEntity){
        return UserProductKeyDTO.builder()
                .product_idx(userProductKeyEntity.getProduct_idx())
                .useYN(userProductKeyEntity.getUseYN())
                .createdDate(userProductKeyEntity.getCreatedDate())
                .modifiedDate(userProductKeyEntity.getModifiedDate())
                .build();
    }
}
