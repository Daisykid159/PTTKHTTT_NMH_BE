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
        UserEntity userEntity = userRepository.getUserEntitiesByUserNamePasAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if(userEntity == null) return new CommonResponse().ok(false).message("Tên đăng nhập hoặc mật khẩu không chính xác");
        UserDTO result = new UserDTO();
        result.setUsername(userEntity.getUsername());
        return new CommonResponse().success().data(result);
    }

    public CommonResponse dangKy(UserDTO userDTO){
        UserEntity userEntity = userRepository.getUserEntitiesByUserName(userDTO.getUsername());
        if(userEntity != null) return new CommonResponse().ok(false).message("Đã tồn tại username: " + userDTO.getUsername());
        userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userRepository.save(userEntity);
        return new CommonResponse().success();
    }

}
