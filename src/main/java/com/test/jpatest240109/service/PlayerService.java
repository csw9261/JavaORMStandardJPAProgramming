package com.test.jpatest240109.service;

import com.test.jpatest240109.dto.PlayerAndTeamDTO;
import com.test.jpatest240109.dto.SelectPlayerAndTeamDTO;
import com.test.jpatest240109.entity.PlayerEntity;
import com.test.jpatest240109.entity.TeamEntity;
import com.test.jpatest240109.repository.PlayerRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface PlayerService {

    void savePlayer(HttpServletRequest request);

    List<PlayerEntity> findAllPlayerAndTeam(HttpServletRequest request);

    List<PlayerAndTeamDTO> playerAndTeamDtoList();

    List<PlayerAndTeamDTO> selectPlayerAndTeam(HttpServletRequest request);

    List<SelectPlayerAndTeamDTO> selectPlayerAndTeam_JPQL();

    @Service
    @Slf4j
    @Builder
    class PlayerServiceImpl implements PlayerService{

        private final PlayerRepository playerRepository;

        @Autowired
        public PlayerServiceImpl(PlayerRepository playerRepository) {
            this.playerRepository = playerRepository;
        }

        @Override
        public void savePlayer(HttpServletRequest request) {
            PlayerEntity playerEntity =  PlayerEntity.builder()
                    .age(Integer.parseInt(request.getParameter("age")))
                    .name(request.getParameter("name"))
                    .position(request.getParameter("position"))
                    .build();

            TeamEntity teamEntity = TeamEntity.builder()
                    .playerEntity(playerEntity)
                    .teamName(request.getParameter("teamName"))
                    .build();


            playerRepository.savePlayerInfo(playerEntity, teamEntity);
        }

        @Override
        public List<PlayerEntity> findAllPlayerAndTeam(HttpServletRequest request) {
            return playerRepository.findAllPlayerAndTeam();
        }

        @Override
        public List<PlayerAndTeamDTO> playerAndTeamDtoList() {
            List<PlayerEntity> playerEntityList = playerRepository.findAllPlayerAndTeam();

            return playerEntityList.stream()
                    .map(playerEntityList1 -> new PlayerAndTeamDTO(
                            playerEntityList1.getPlayer_id(),
                            playerEntityList1.getAge(),
                            playerEntityList1.getPosition(),
                            playerEntityList1.getName(),
                            playerEntityList1.getId(),
                            playerEntityList1.getTeamName()
                    )).collect(Collectors.toList());
        }

        @Override
        public List<PlayerAndTeamDTO> selectPlayerAndTeam(HttpServletRequest request) {
            List<PlayerEntity> playerEntityList = playerRepository.selectPlayerAndTeam();

            return playerEntityList.stream()
                    .map(playerEntity -> new PlayerAndTeamDTO(
                            playerEntity.getPlayer_id(),
                            playerEntity.getAge(),
                            playerEntity.getPosition(),
                            playerEntity.getName(),
                            playerEntity.getId(),
                            playerEntity.getTeamName()
                    )).collect(Collectors.toList());
        }

        @Override
        public List<SelectPlayerAndTeamDTO> selectPlayerAndTeam_JPQL() {

            return playerRepository.selectPlayerAndTeam_JPQL();
        }
    }
}
