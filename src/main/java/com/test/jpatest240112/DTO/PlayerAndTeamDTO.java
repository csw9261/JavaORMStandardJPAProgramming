package com.test.jpatest240112.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerAndTeamDTO {

    private Integer player_id;
    private Integer age;
    private String position;
    private String name;
    private Integer id;
    private String teamName;

}
