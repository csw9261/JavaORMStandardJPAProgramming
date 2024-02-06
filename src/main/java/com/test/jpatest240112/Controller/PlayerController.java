package com.test.jpatest240112.Controller;

import com.test.jpatest240112.DTO.PlayerAndTeamDTO;
import com.test.jpatest240112.DTO.SelectPlayerAndTeamDTO;
import com.test.jpatest240112.Entity.PlayerEntity;
import com.test.jpatest240112.Service.PlayerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/findAllPlayerAndTeam")
    public List<PlayerEntity> findAllPlayerAndTeam(HttpServletRequest request){
        return playerService.findAllPlayerAndTeam(request);
    }

    @GetMapping("/selectPlayerAndTeam")
    public List<PlayerAndTeamDTO> selectPlayerAndTeam(HttpServletRequest request){
        return playerService.selectPlayerAndTeam(request);
    }

    @GetMapping("/selectPlayerAndTeam_JPQL")
    public List<SelectPlayerAndTeamDTO> selectPlayerAndTeam_JPQL(HttpServletRequest request){
        return playerService.selectPlayerAndTeam_JPQL();
    }
}
