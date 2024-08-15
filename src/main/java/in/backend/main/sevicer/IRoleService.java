package in.backend.main.sevicer;

import in.backend.main.entity.Roles;

public interface IRoleService extends IGeneralService<Roles> {
   Roles findByName(String name);
}
