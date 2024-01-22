package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Role;
import com.cwift.cwiftMarketplace_backend.model.RoleName;
import com.cwift.cwiftMarketplace_backend.model.User;
import com.cwift.cwiftMarketplace_backend.repository.UserRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser ( User user ) {
        user.setRoles ( List.of (Role.builder ().roleName ( RoleName.USER ).build ()) );
        return userRepository.save ( user );
    }

    @Override
    public String addRolesToUser ( String username, RoleName roleName ) {
        try{
            User user = userRepository.findByUsername( username ).get ();
            user.getRoles ().add ( Role.builder ().roleName ( roleName ).build () );
            userRepository.save ( user );
            return "Role " + roleName + " added to user " + username;
        }
        catch ( Exception e ) {
            log.info ( String.valueOf ( e ) );
        }
        return null;
    }

    @Override
    public boolean verifyUser ( String username ) {
//        Write logic to verify the user account from here
        return false;
    }


    @Override
    public User getUserByID ( long id ) {
        return userRepository.findById ( id ).get ();
    }

    @Override
    public List<User> getAllUsers () {
        return userRepository.findAll ();
    }

    @Override
    public User editUser ( long id, User user ) {
        return null;
    }

    @Override
    public String deleteUser ( long id ) {
        try{
            userRepository.deleteById ( id );
            return "Success";
        } catch ( Exception e ) {
            log.info ( String.valueOf ( e ) );
        }
        return null;
    }

    @Override
    public String deleteAllUsers (  ) {
        userRepository.deleteAll ();
        return "Success";
    }

    @Override
    public List<String> getAllRoleNames () {
        return Arrays.stream( RoleName.values () ).map ( RoleName:: name ).toList ();
    }
}
