package in.backend.main.repository;

import in.backend.main.enity.User;
import in.backend.main.service.IGeneralService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IGeneralService<User, String>, JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
