package com.test.jpatest240109.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelectPlayerAndTeamDTO {

    private int player_id;
    private int age;
    private String position;
    private String name;
    private Integer id;
    private String teamName;

}
