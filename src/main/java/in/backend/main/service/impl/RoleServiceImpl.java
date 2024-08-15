package in.backend.main.service.impl;

import in.backend.main.enity.Role;
import in.backend.main.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Override
    public Iterable<Role> fillAll() {
        return null;
    }

    @Override
    public Optional<Role> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void remove(String id) {

    }
}
