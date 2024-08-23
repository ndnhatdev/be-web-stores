package in.backend.main.repository;

import in.backend.main.enity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, String> {
    Optional<Permission> findByName(String name);
}
