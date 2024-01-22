//package com.cwift.cwiftMarketplace_backend.configuration.securityConfig;
//
//import com.cwift.cwiftMarketplace_backend.model.Role;
//import com.cwift.cwiftMarketplace_backend.model.RoleName;
//import com.cwift.cwiftMarketplace_backend.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public MyUserDetailsService( UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    /**
//     * This method does processing of user data during Auth
//     * @param userNameOrEmailOrPhone
//     * @return AuthUser
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public User loadUserByUsername(String userNameOrEmailOrPhone) throws UsernameNotFoundException {
//        Optional<com.cwift.cwiftMarketplace_backend.model.User> authUser = Optional.ofNullable(userRepository.findByUserNameOrEmailOrPhone(userNameOrEmailOrPhone, userNameOrEmailOrPhone, userNameOrEmailOrPhone));
//        authUser.orElseThrow(()-> new UsernameNotFoundException("user does not exist"));
//
//        if(authUser.get ().isVerified ()){
//            List<GrantedAuthority> authorities = authUser.get()
//                    .getRoles().stream()
//                    .map( Role::getRoleName)
//                    .map ( RoleName :: toString ) //Testing to see whether it will work
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
//
//            return new User(authUser.get().getUsername(),authUser.get().getPassword(),authorities);
//        }
//
//        return null;
//    }
//}