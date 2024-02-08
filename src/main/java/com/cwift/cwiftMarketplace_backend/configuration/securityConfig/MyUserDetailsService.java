package com.cwift.cwiftMarketplace_backend.configuration.securityConfig;

import com.cwift.cwiftMarketplace_backend.model.Role;
import com.cwift.cwiftMarketplace_backend.model.RoleName;
import com.cwift.cwiftMarketplace_backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method does processing of user data during Auth
     * @param usernameOrEmailOrPhone
     * @return AuthUser
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {
        Optional<com.cwift.cwiftMarketplace_backend.model.User> authUser = Optional.ofNullable(userRepository.findByUsernameOrEmailOrPhone(
                usernameOrEmailOrPhone,
                usernameOrEmailOrPhone,
                usernameOrEmailOrPhone
        ));
        authUser.orElseThrow(()-> new UsernameNotFoundException("user does not exist"));

        if(authUser.get ().isVerified ()){
            List<GrantedAuthority> authorities = authUser.get()
                    .getRoles().stream()
                    .map( Role::getRoleName)
                    .map ( RoleName :: toString )
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            return new User(authUser.get().getUsername(),authUser.get().getPassword(),authorities);
        }else {
            log.info("User not verified");
            throw new RuntimeException ( " User not verified ");
        }
    }
}