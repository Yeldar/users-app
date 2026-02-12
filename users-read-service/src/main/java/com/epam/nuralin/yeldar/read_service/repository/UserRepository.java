package com.epam.nuralin.yeldar.read_service.repository;

import com.epam.nuralin.yeldar.read_service.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByUsernameStartingWith(String username, Pageable pageable);
}
