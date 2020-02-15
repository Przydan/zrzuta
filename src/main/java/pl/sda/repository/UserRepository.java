package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
