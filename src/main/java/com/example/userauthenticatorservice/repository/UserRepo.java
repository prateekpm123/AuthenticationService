package com.example.userauthenticatorservice.repository;


import com.example.userauthenticatorservice.models.User;
import com.example.userauthenticatorservice.models.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByEmail(String email);

//    @Transactional
//    @Modifying
//    @Query("UPDATE User u SET u.status = ?1 WHERE u.id = ?2")
//    public Integer updateUserByEmail(UserStatus userStatus, Long id);

    @Modifying
    @Query("UPDATE User u SET u.userStatus = :status WHERE u.id = :userId")
    void updateUserByEmail(@Param("status") UserStatus status, @Param("userId") Long userId);
}
