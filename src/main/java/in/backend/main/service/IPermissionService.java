package in.backend.main.service;

import in.backend.main.enity.Permission;

import java.util.Optional;

public interface IPermissionService extends IGeneralService<Permission, String> {
    Optional<Permission> findUserByUsername(String username);
}
