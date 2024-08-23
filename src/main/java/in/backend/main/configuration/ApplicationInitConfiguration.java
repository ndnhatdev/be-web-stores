package in.backend.main.configuration;

import in.backend.main.enity.Permission;
import in.backend.main.enity.Role;
import in.backend.main.enity.User;
import in.backend.main.repository.IPermissionRepository;
import in.backend.main.repository.IRoleRepository;
import in.backend.main.repository.IUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfiguration {
    PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USERNAME = "admin";
    @NonFinal
    static final String ADMIN_PASSWORD = "admin";
    @NonFinal
    static final String ADMIN_ROLE = "ADMIN";
    @NonFinal
    static final String USER_ROLE = "USER";

    @Bean
    @ConditionalOnProperty(
        prefix = "spring",
            value = "datasource.driver-class-name",
            havingValue = "org.postgresql.Driver"
    )
    ApplicationRunner applicationRunner (IUserRepository userRepository, IRoleRepository roleRepository, IPermissionRepository permissionRepository) {
        log.info("Initializing Application.....");
        return args -> {
            if (userRepository.findByUsername(ADMIN_USERNAME).isEmpty()) {
                Permission permissionAdmin = Permission.builder()
                        .name(ADMIN_ROLE)
                        .description("Full Permission")
                        .build();
                permissionRepository.save(permissionAdmin);
                var permissions = new HashSet<Permission>();
                permissions.add(permissionAdmin);

                Role roleAdmin = Role.builder()
                        .name(ADMIN_ROLE)
                        .permissions(permissions)
                        .description("Role is Admin")
                        .build();
                roleRepository.save(roleAdmin);
                var roles = new HashSet<Role>();
                roles.add(roleAdmin);

                User user = User.builder()
                        .username(ADMIN_USERNAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .firstName("nd")
                        .lastName("nhat")
                        .email("ndnhat711@gmail.com")
                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("admin user has been created with default password: admin, please change password");
            }
            log.info("Application initialized completed.......");
        };
    }
}
