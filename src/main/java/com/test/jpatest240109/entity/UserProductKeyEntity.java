package com.test.jpatest240109.entity;

import com.test.jpatest240109.dto.UserProductKeyDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_product_key_entity")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserProductKeyEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_idx")
    private Long product_idx;

    @Column(name = "useYN")
    private String useYN;

/*
    @ManyToOne(targetEntity = User_Entity.class ,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", insertable = false, updatable = false) // - name : 맵핑할 외래키의 이름(Entity에 선언한 객체이름) , - referencedColumnName : 외래키가 참조하는 대상 태이블의 pk 이름
    private User_Entity userEntity;


    @Column(name ="user_idx")
    private  int user_idx;

*/
/*

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User_Entity userEntity;

    public void updateUserEntity(User_Entity userEntity){
        this.userEntity = userEntity;
    }
*/

    @Column(name ="user_idx")
    private  int user_idx;

    public UserProductKeyEntity convertUserProductKeyEntity(UserProductKeyDTO userProductKeyDTO){
        return UserProductKeyEntity.builder()
                .product_idx(userProductKeyDTO.getProduct_idx())
                .useYN(userProductKeyDTO.getUseYN())
                .user_idx(userProductKeyDTO.getUser_idx())
                .build();
    }

}
