package com.test.jpatest240112.Repository.Jpa;

import com.test.jpatest240112.DTO.SelectPlayerAndTeamDTO;
import com.test.jpatest240112.Entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerJpaRepository extends JpaRepository<PlayerEntity,Integer> {

    @Query(value = "SELECT tb_player.age, " +
            "       tb_player.player_id, " +
            "       tb_player.name, " +
            "       tb_player.position, " +
            "       tb_team.id, " +
            "       tb_team.team_name " +
            "FROM test.tb_player " +
            "INNER JOIN tb_team ON tb_player.player_id = tb_team.id",
            nativeQuery = true)
    List<PlayerEntity> selectPlayerAndTeam_nativeQuery();

    @Query("SELECT NEW com.test.jpatest240112.DTO.SelectPlayerAndTeamDTO(p.player_id, p.age, p.position, p.name, t.id, t.teamName) " +
            "FROM PlayerEntity p " +
            "INNER JOIN p.teamEntityList t")
    List<SelectPlayerAndTeamDTO> selectPlayerAndTeam();
}
