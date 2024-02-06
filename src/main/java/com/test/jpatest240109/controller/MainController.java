package com.test.jpatest240109.controller;

import com.test.jpatest240109.dto.PlayerAndTeamDTO;
import com.test.jpatest240109.dto.SelectPlayerAndTeamDTO;
import com.test.jpatest240109.dto.UserDTO;
import com.test.jpatest240109.entity.PlayerEntity;
import com.test.jpatest240109.entity.User_Entity;
import com.test.jpatest240109.service.PlayerService;
import com.test.jpatest240109.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/user")
public class MainController {
    private final UserService userService;

    private final PlayerService playerService;

    @Autowired
    public MainController(UserService userService, PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
    }



    @GetMapping("/getUserData_findbyid_returnentity")
    public User_Entity getUserDataEntity(HttpServletRequest request){
        int getUserIdx = Integer.parseInt(request.getParameter("user_idx"));
        Optional<User_Entity> getUserData = userService.getUserData(getUserIdx);

        if(getUserData.isPresent()){
            log.info("getUserData-> " + getUserData.get());
            return getUserData.get();
        }else{
            log.warn("error");
            return null;
        }
    }

    @GetMapping("/getUserData_findbyid_returndto")
    public UserDTO getUserDataDto(HttpServletRequest request){
        int getUserIdx2 = Integer.parseInt(request.getParameter("user_idx"));
        Optional<User_Entity> getUserData = userService.getUserData(getUserIdx2);

        UserDTO userDTO = new UserDTO();

        if(getUserData.isPresent()){
            log.info("getUserData-> " + getUserData.get());
            User_Entity userEntity = getUserData.get();
            return userDTO.toUserDTO(userEntity);
        }else{
            log.warn("error");
            return null;
        }

    }

    @GetMapping("getUserData_findAll")
    public List<User_Entity> getUserDataFindAll(HttpServletRequest request){
        log.info("@@@getUserDataFindAll-> "+userService.getUserDataFindAll().toString());
        return userService.getUserDataFindAll();

    }
    @GetMapping("/insertUser")
    public Boolean insertUser(HttpServletRequest request){
        boolean result = true;

        userService.saveUser(   request.getParameter("name"),
                                request.getParameter("mail"),
                                request.getParameter("password")
        );
        return result;
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request){
        userService.delete(Integer.parseInt(request.getParameter("user_idx")));
    }

    @PutMapping("/updateUserName")
    public void updateUserName(HttpServletRequest request){
        userService.updateUserName(request);
    }

    @PutMapping("/saveAllUser")
    public void saveAllUser(HttpServletRequest request){
        userService.saveAllUser(request);
    }

    // pageRequest 사용 예제
    @GetMapping("/pagingFindAll")
    public Page<User_Entity> pagingFindAll(@RequestParam int pageNumber){
        log.warn("@@@@@@@@@pageNumber->" + pageNumber);
        PageRequest pageRequest = PageRequest.of(pageNumber, 10, Sort.by("idx").descending());
        return userService.pagingFindAll(pageRequest);
    }

    @PutMapping("/savePlayer")
    public void savePlayer(HttpServletRequest request){
        playerService.savePlayer(request);
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
