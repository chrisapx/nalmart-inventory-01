package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.AuthenticationRequest;
import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.AuthenticationResponse;
import com.cwift.cwiftMarketplace_backend.model.RoleName;
import com.cwift.cwiftMarketplace_backend.model.User;
import com.cwift.cwiftMarketplace_backend.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(originPatterns = "*")
public class UserController {

    private final UserServiceImpl userService;

    public UserController ( UserServiceImpl userService ) {
        this.userService = userService;
    }

    @PostMapping("/u1")
    public ResponseEntity<User> createUserAccount( @RequestBody User user ){
        return ResponseEntity.ok (userService.createUser ( user ));
    }

    @PostMapping("/admin")
    public ResponseEntity<User> createAdminAccount( @RequestBody User user ){
        return ResponseEntity.ok (userService.createAdminUser ( user ));
    }

    @PutMapping("/pass")
    public ResponseEntity<User> updateUserPassword( @RequestParam String username, @RequestBody User user ){
        return ResponseEntity.ok (userService.editUserPassword ( username, user ));
    }

    @PutMapping("/v/{userEmail}")
    public ResponseEntity<Boolean> verifyAccount( @PathVariable String userEmail, @RequestParam String otp ){
        return ResponseEntity.ok (userService.verifyAccount ( userEmail, otp ));
    }

    @PutMapping("/v/{userEmail}/otp")
    public ResponseEntity<Boolean> sendNewOtp( @PathVariable String userEmail ){
        return ResponseEntity.ok (userService.sendNewOtp ( userEmail ));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login( @RequestBody AuthenticationRequest authenticationRequest ) throws Exception {
        return ResponseEntity.ok ( userService.loqin ( authenticationRequest ));
    }

    @PutMapping("/role")
    public ResponseEntity<String> addRolesToUser( @RequestParam String username , @RequestParam RoleName roleName ){
        return ResponseEntity.ok ( userService.addRolesToUser (username, roleName) );
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getAllRoleName(  ){
        return ResponseEntity.ok (userService.getAllRoleNames (  ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID( @PathVariable long id ){
        return ResponseEntity.ok (userService.getUserByID ( id ));
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalUsers(){
        return ResponseEntity.ok (userService.countUsers ());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsernameOrEmailOrPhone( @PathVariable String username ){
        return ResponseEntity.ok (userService.getUserByUsernameOrEmailOrPhone ( username ));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok (userService.getAllUsers ());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam long id){
        return ResponseEntity.ok (userService.deleteUser ( id ));
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> deleteAllUsers(){
        return ResponseEntity.ok (userService.deleteAllUsers ( ));
    }


}
