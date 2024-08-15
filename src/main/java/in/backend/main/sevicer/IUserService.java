package in.backend.main.sevicer;

import in.backend.main.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<Users>, UserDetailsService {
    Optional<Users> findByUserName (String username);
}
