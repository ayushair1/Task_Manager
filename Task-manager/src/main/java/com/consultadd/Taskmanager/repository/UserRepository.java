package com.consultadd.Taskmanager.repository;

import com.consultadd.Taskmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public Optional<UserEntity> findByUsername(String username);
}
