package in.backend.main.sevicer;

import in.backend.main.entity.Roles;
import in.backend.main.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles findByName(String name) {
        return rolesRepository.findByName(name);
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Iterable<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void remove(Long id) {
        rolesRepository.deleteById(id);
    }
}
