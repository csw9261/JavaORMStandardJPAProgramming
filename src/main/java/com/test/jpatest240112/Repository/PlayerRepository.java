package com.test.jpatest240112.Repository;

import com.test.jpatest240112.DTO.SelectPlayerAndTeamDTO;
import com.test.jpatest240112.Entity.PlayerEntity;
import com.test.jpatest240112.Entity.TeamEntity;
import com.test.jpatest240112.Repository.Jpa.PlayerJpaRepository;
import com.test.jpatest240112.Repository.Jpa.TeamJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlayerRepository {
    void savePlayerInfo(PlayerEntity playerEntity, TeamEntity teamEntity);

    List<PlayerEntity> findAllPlayerAndTeam();

    List<PlayerEntity> selectPlayerAndTeam();

    List<SelectPlayerAndTeamDTO> selectPlayerAndTeam_JPQL();

    @Repository
    @Slf4j
    class PlayerRepositoryImpl implements PlayerRepository{

        private final PlayerJpaRepository playerJpaRepository;
        private final TeamJpaRepository teamJpaRepository;

        @Autowired
        public PlayerRepositoryImpl(PlayerJpaRepository playerJpaRepository, TeamJpaRepository teamJpaRepository) {
            this.playerJpaRepository = playerJpaRepository;
            this.teamJpaRepository = teamJpaRepository;
        }

        @Override
        public void savePlayerInfo(PlayerEntity playerEntity, TeamEntity teamEntity) {

            playerJpaRepository.save(playerEntity);
            teamJpaRepository.save(teamEntity);


        }

        @Override
        public List<PlayerEntity> findAllPlayerAndTeam() {
            return playerJpaRepository.findAll();
        }

        @Override
        public List<PlayerEntity> selectPlayerAndTeam() {
            List<PlayerEntity> playerEntityList = playerJpaRepository.selectPlayerAndTeam_nativeQuery();
            return playerJpaRepository.selectPlayerAndTeam_nativeQuery();
        }

        @Override
        public List<SelectPlayerAndTeamDTO> selectPlayerAndTeam_JPQL() {
            List<SelectPlayerAndTeamDTO> selectPlayerAndTeamInterfaces = playerJpaRepository.selectPlayerAndTeam();
            return playerJpaRepository.selectPlayerAndTeam();
        }
    }
}
