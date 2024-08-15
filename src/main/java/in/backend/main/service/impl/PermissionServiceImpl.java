package in.backend.main.service.impl;

import in.backend.main.enity.Permission;
import in.backend.main.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Override
    public Optional<Permission> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Iterable<Permission> fillAll() {
        return null;
    }

    @Override
    public Optional<Permission> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Permission save(Permission permission) {
        return null;
    }

    @Override
    public void remove(String id) {

    }
}
