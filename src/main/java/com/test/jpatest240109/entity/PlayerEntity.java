package com.test.jpatest240109.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name= "tb_player")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class PlayerEntity {

    @Id
    @GeneratedValue
    private int player_id;

    @Column
    private int age;

    @Column
    private String position;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "playerEntity", fetch = FetchType.LAZY) // teamEntityList에서 무엇과 mapping 걸려있는지 명시
    List<TeamEntity> teamEntityList;

    public String getTeamName(){
        //return teamEntityList.stream().map(TeamEntity::getTeamName).collect(Collectors.toList());
        return teamEntityList.get(0).getTeamName();
    }

    public int getId(){
        return teamEntityList.get(0).getId();
    }

}
