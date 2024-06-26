package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.AuthenticationRequest;
import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.AuthenticationResponse;
import com.cwift.cwiftMarketplace_backend.model.RoleName;
import com.cwift.cwiftMarketplace_backend.model.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public AuthenticationResponse loqin( AuthenticationRequest authenticationRequest ) throws Exception;

    long countUsers ();

    public boolean verifyAccount( String userEmail, String otp);
    public String addRolesToUser( String username, RoleName roleName );
    public User getUserByID(long id);
    User getUserByUsernameOrEmailOrPhone ( String username );
    public List<User> getAllUsers();
    public User editUser(long id, User user);
    User editUserPassword ( String username, User user );
    public String deleteUser( long id);
    String deleteAllUsers (  );
    List<String> getAllRoleNames ();
    Boolean sendNewOtp ( String userEmail );
    User createAdminUser ( User user );
}
