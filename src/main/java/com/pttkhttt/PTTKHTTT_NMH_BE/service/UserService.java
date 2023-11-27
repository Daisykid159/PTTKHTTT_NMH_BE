package com.pttkhttt.PTTKHTTT_NMH_BE.service;

import com.pttkhttt.PTTKHTTT_NMH_BE.domain.UserEntity;
import com.pttkhttt.PTTKHTTT_NMH_BE.repository.UserRepository;
import com.pttkhttt.PTTKHTTT_NMH_BE.response.CommonResponse;
import com.pttkhttt.PTTKHTTT_NMH_BE.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public CommonResponse dangNhap(UserDTO userDTO){
        UserEntity userEntity = userRepository.getUserEntitiesByUserNamePasAndPassword(userDTO.getUserName(), userDTO.getPassword());
        if(userEntity == null) return new CommonResponse().ok(false).message("Tên đăng nhập hoặc mật khẩu không chính xác");
        UserDTO result = new UserDTO();
        userDTO.setUserName(userEntity.getUserName());
        return new CommonResponse().success().data(result);
    }

    public CommonResponse dangKy(UserDTO userDTO){
        UserEntity userEntity = userRepository.getUserEntitiesByUserName(userDTO.getUserName());
        if(userEntity != null) return new CommonResponse().ok(false).message("Đã tồn tại username: " + userDTO.getUserName());
        userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());
        return new CommonResponse().success();
    }

}
