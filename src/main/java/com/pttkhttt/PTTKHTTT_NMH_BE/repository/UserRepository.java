package com.pttkhttt.PTTKHTTT_NMH_BE.repository;

import com.pttkhttt.PTTKHTTT_NMH_BE.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u where u.userName = :username and u.password = :password")
    UserEntity getUserEntitiesByUserNamePasAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("select u from UserEntity u where u.userName = :username")
    UserEntity getUserEntitiesByUserName(@Param("username") String username);

}
