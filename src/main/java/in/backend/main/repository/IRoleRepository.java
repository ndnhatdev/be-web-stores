package in.backend.main.repository;

import in.backend.main.enity.Role;
import in.backend.main.service.IGeneralService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends IGeneralService<Role, String>, JpaRepository<Role, String> {
}
