package in.backend.main.repository;

import in.backend.main.enity.User;
import in.backend.main.service.IGeneralService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IGeneralService<User, String>, JpaRepository<User, String> {
}
