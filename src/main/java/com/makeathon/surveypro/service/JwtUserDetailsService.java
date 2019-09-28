package com.makeathon.surveypro.service;

import com.makeathon.surveypro.entity.Role;
import com.makeathon.surveypro.entity.User;
import com.makeathon.surveypro.exception.RoleNotFoundException;
import com.makeathon.surveypro.exception.UserAlreadyExistException;
import com.makeathon.surveypro.exception.UserNotFoundException;
import com.makeathon.surveypro.model.request.SignUpRequest;
import com.makeathon.surveypro.repository.RoleRepository;
import com.makeathon.surveypro.repository.UserRepository;
import com.makeathon.surveypro.security.UserPrincipal;
import com.makeathon.surveypro.util.ExceptionErrorCodes;
import com.makeathon.surveypro.util.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsernameOrEmail(username, username).orElseThrow(() ->
                new UserNotFoundException("User not found with mobile no: " + username,
                        ExceptionErrorCodes.USER_NOT_FOUND.getErrorCode())
        );
        return UserPrincipal.create(user);
    }


    public User saveUser(SignUpRequest signUpRequest) throws UserAlreadyExistException, RoleNotFoundException {

        if (userExistsByUsername(signUpRequest.getUsername()))
            throw new UserAlreadyExistException("Username is already in use!", ExceptionErrorCodes.USERNAME_ALREADY_REGISTERED.getErrorCode());

        if (userExistByEmail(signUpRequest.getEmail()))
            throw new UserAlreadyExistException("Email is already in use!", ExceptionErrorCodes.EMAIL_ALREADY_REGISTERED.getErrorCode());

        // Creating user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail());

        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RoleNotFoundException(ExceptionErrorCodes.ROLE_NOT_FOUND.getErrorCode()));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        return result;
    }


    private boolean userExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    private boolean userExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

  /*  public User updateUserPIN(UpdatePinRequest updatePinRequest) throws InvalidOTPException {
        User persistedUser = userRepository.findByMobileNo(updatePinRequest.getMobileNo()).orElseThrow(() ->
                new UserNotFoundException("User not found with mobile no: " + updatePinRequest.getMobileNo(),
                        ExceptionErrorCodes.USER_NOT_FOUND.getErrorCode())
        );
        if (!updatePinRequest.getOtp().equals(otpService.getOtp(updatePinRequest.getMobileNo()) + ""))
            throw new InvalidOTPException(updatePinRequest.getMobileNo(), ExceptionErrorCodes.INVALID_OTP.getErrorCode());

        persistedUser.setPin(passwordEncoder.encode(updatePinRequest.getNewPin()));
        User result = userRepository.save(persistedUser);

        //Remove used OTP from cache
        otpService.clearOTP(updatePinRequest.getMobileNo());
        return result;
    }*/


    //Case:New User
    //user generate otp
    //signup
    //login

    //Case: Already registered user installed new app
    //generate otp request-> User Already Exists
    //login

    //forget password
    //gnerate otp
}
