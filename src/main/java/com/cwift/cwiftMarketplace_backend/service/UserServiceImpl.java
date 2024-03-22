package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.AuthenticationRequest;
import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.AuthenticationResponse;
import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.MyUserDetailsService;
import com.cwift.cwiftMarketplace_backend.configuration.securityConfig.jwt.JWTUtil;
import com.cwift.cwiftMarketplace_backend.model.*;
import com.cwift.cwiftMarketplace_backend.repository.OtpRepository;
import com.cwift.cwiftMarketplace_backend.repository.UserRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.UserService;
import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JWTUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final OtpRepository otpRepository;
    private final EmailSenderServiceimpl emailSenderServiceimpl;

    public UserServiceImpl ( UserRepository userRepository, AuthenticationManager authenticationManager, MyUserDetailsService myUserDetailsService, JWTUtil jwtTokenUtil, PasswordEncoder passwordEncoder, OtpRepository otpRepository, EmailSenderServiceimpl emailSenderServiceimpl ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
        this.otpRepository = otpRepository;
        this.emailSenderServiceimpl = emailSenderServiceimpl;
    }

    @Override
    public User createUser(User user) {
        try {
            user.setRoles(List.of(Role.builder().roleName(RoleName.USER).build()));
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            User createdAccount = userRepository.save(user);

            // If the save is successful, proceed to OTP creation
            if(userRepository.existsByUsernameOrEmailOrPhone ( createdAccount.getEmail (), createdAccount.getUsername (), createdAccount.getPhone ())) {
                if (!otpRepository.existsByUsername ( createdAccount.getEmail () )) {
                    Otp otp = Otp.builder ().otp ( IDGenerator.otpGenerator () ).username ( createdAccount.getEmail () ).build ();
                    otpRepository.save ( otp );

                    emailSenderServiceimpl.sendEmail (
                            createdAccount.getEmail (),
                            "Nalmart Verification Code",
                            "Hello \n\n"
                                    +"Your account verification Otp is --------- " + otp.getOtp () + " --------- \nEnter it when prompted to provide Otp for account verification \n"
                                    +"Alternatively, you can follow the link below to verify your account \n\n"
                                    +"http://localhost:8080/users/v/" + createdAccount.getEmail () +"?otp=" +otp.getOtp () +"\n\n\n"
                                    +"Happy shopping..."

                    );
                } else {
                    sendNewOtp ( createdAccount.getEmail () );
                }

                log.info ( "Account created for user" + user.getUserID () );
                return createdAccount;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public AuthenticationResponse loqin ( AuthenticationRequest authenticationRequest ) throws Exception {
        try{
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken (authenticationRequest.getUsername(), authenticationRequest.getPassword()) );
        }catch ( BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        log.info ( "User logged in " + authenticationRequest.getUsername () );

        return new AuthenticationResponse ( jwt );
    }

    @Override
    public boolean verifyAccount ( String userEmail, String otp ) {

        Otp sentOtp = otpRepository.findByUsername ( userEmail );
//        Date currentTime = new Date();
//        long timeDifference = currentTime.getTime() - sentOtp.getCreatedAt ().getTime();
//        long thirtyMinutesInMillis = 30 * 60 * 1000; // 30 minutes in milliseconds which is the time of expiry

        try{
            if( otp.equals ( sentOtp.getOtp () ) ){
                log.info ( "Otps are the same: " );

//                if ( timeDifference <= thirtyMinutesInMillis ) {
//                    log.info ( "Otp valid" );
                    User vUser = userRepository.findByUsernameOrEmailOrPhone ( userEmail, userEmail, userEmail );
                    vUser.setVerified ( true );
                    log.info ( "Setting verified for user: " + userEmail );
                    boolean verified = userRepository.save ( vUser ).isVerified ();

                    if(verified){
                        emailSenderServiceimpl.sendEmail (
                                userEmail,
                                "Nalmart account Verification Success",
                                "Hello \n\n"
                                        +"Your account has been successfully verified \n"
                                        +"Enjoy more privileges with your fully verified account across Nalmart Platform \n\n"
                                        +"Happy shopping..."

                        );
                    }

                    otpRepository.deleteByUsername( userEmail );
                    return verified;
//                }else {
//                    log.info ( "Otp Expired" );
//                }
            } else {
                log.info ( "Invalid OTP" );
                return false;
            }
        }
        catch ( Exception e ) {
            log.info ( String.valueOf ( e ) );
            throw new RuntimeException ( e );
        }
//        return false;
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
    public User getUserByID ( long id ) {
        return userRepository.findById ( id ).get ();
    }

    @Override
    public User getUserByUsernameOrEmailOrPhone ( String username ) {
        log.info ( "User accessed: " +username );
        return userRepository.findByUsernameOrEmailOrPhone ( username, username, username );
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
        return Arrays.stream( RoleName.values () ).map ( RoleName:: name ).collect( Collectors.toList());
    }

    @Override
    public Boolean sendNewOtp ( String userEmail ) {
        try {
            Otp otp1 = otpRepository.findByUsername ( userEmail );

            otp1.setOtp ( IDGenerator.otpGenerator () );
            otp1.setUpdatedAt ( new Date () );

            emailSenderServiceimpl.sendEmail (
                    userEmail,
                    "New Nalmart Verification Otp",
                    "Hello \n\n"
                    +"Your new account verification Otp is ------- " + otp1.getOtp () + " ----- \n\nEnter it when prompted to provide Otp for account verification \n"
                    +"Alternatively, you can follow the link below to verify your account \n\n"
                    +"http://localhost:8080/users/v/" + userEmail +"/otp .. \n\n\n"
                    +"Happy shopping..."

            );
            //        TODO: Send the otp to the user to enter the updated verification code

            otpRepository.save ( otp1 );
            return true;
        }
        catch ( Exception e ) {
            log.info ( String.valueOf ( e ) );
            throw new RuntimeException ( e );
        }
    }
}
