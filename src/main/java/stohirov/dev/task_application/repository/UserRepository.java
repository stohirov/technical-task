package stohirov.dev.task_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stohirov.dev.task_application.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRepository, Integer> {
    Optional<User> findByUsername(String username);
}
