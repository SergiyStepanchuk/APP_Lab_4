package testOnline.repositories;

import testOnline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByLoginAndPasswordHash(String login, String passwordHash);
    boolean existsByLogin(String login);
}
