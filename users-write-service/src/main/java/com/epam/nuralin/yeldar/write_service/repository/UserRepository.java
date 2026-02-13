package com.epam.nuralin.yeldar.write_service.repository;

import com.epam.nuralin.yeldar.write_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);

    boolean existsById(Long id);
}
