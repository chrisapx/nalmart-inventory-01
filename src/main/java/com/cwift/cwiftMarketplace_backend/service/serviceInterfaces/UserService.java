package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.RoleName;
import com.cwift.cwiftMarketplace_backend.model.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public String addRolesToUser( String username, RoleName roleName );
    public boolean verifyUser(String username);
    public User getUserByID(long id);
    public List<User> getAllUsers();
    public User editUser(long id, User user);
    public String deleteUser(long id);
    String deleteAllUsers (  );
    List<String> getAllRoleNames ();
}
