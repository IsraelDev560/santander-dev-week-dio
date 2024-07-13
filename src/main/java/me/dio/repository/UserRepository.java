package me.dio.repository;

import me.dio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameIgnoreCase(String name);

    boolean existsByAccountNumber(String number);
}
