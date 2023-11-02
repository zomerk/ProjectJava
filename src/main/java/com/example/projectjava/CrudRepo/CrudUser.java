package com.example.projectjava.CrudRepo;

import com.example.projectjava.repo.User;
import org.springframework.data.repository.CrudRepository;

public interface CrudUser extends CrudRepository<User,Long> {
    public User findByEmail(String email);
}
