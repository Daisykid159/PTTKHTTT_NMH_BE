package com.pttkhttt.PTTKHTTT_NMH_BE.controller;

import com.pttkhttt.PTTKHTTT_NMH_BE.response.CommonResponse;
import com.pttkhttt.PTTKHTTT_NMH_BE.service.UserService;
import com.pttkhttt.PTTKHTTT_NMH_BE.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/dang-nhap")
    public CommonResponse dangNhap(@RequestBody UserDTO userDTO){
        return userService.dangNhap(userDTO);
    }


    @PostMapping("/dang-ky")
    public CommonResponse dangKy(@RequestBody UserDTO userDTO){
        return userService.dangKy(userDTO);
    }

}
