package com.example.projectjava.Service;


import com.example.projectjava.CrudRepo.CrudUser;
import com.example.projectjava.Dto.UserDTO;
import com.example.projectjava.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {
    CrudUser crudUser;
    PasswordEncoder passwordEncoder;

    public UserService(CrudUser crudUser, PasswordEncoder passwordEncoder) {

        this.crudUser = crudUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User transaction = crudUser
                .findByEmail(email);
        if(transaction == null) {
            System.out.println("User name not found");
            return null;
        }
        else{
            return new UserAdapter(transaction);
        }
    }
    public Boolean CreateUser(UserDTO userDTO){
        var user = loadUserByUsername(userDTO.getEmail());
        if(user == null){
            crudUser.save(new User(userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword())));
            return true;
        }
        else{
            return false;
        }
    }
}
