package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.ActiveRefreshToken;
import testOnline.entity.Test;

public interface ActiveRefreshTokenRepository extends JpaRepository<ActiveRefreshToken,String>
{
}
