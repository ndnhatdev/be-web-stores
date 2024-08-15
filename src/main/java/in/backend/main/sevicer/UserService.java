package in.backend.main.sevicer;

import in.backend.main.entity.Users;
import in.backend.main.repository.UsersRepository;
import in.backend.main.security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<Users> findByUserName(String username) {
        return usersRepository.findByUserName(username);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Iterable<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.save(users);
    }

    @Override
    public void remove(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> usersOptional = usersRepository.findByUserName(username);
        if (usersOptional.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return UserPrinciple.build(usersOptional.get());
    }


}
