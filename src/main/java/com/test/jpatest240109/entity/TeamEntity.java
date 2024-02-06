package com.test.jpatest240109.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_team")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TeamEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    PlayerEntity playerEntity;
}
