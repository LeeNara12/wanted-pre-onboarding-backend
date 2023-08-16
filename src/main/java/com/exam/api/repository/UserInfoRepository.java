package com.exam.api.repository;

import com.exam.api.dto.UserJoinBoard;
import com.exam.api.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    boolean existsByEmail(String email);

}
