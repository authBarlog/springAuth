package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
          new ApplicationUser(
                  STUDENT.getGrantedAuthorities(),
                  passwordEncoder.encode("pass"),
                  "anna",
                  true,
                  true,
                  true,
                  true),
          new ApplicationUser(
                  ADMIN.getGrantedAuthorities(),
                  passwordEncoder.encode("pass123"),
                  "linda",
                  true,
                  true,
                  true,
                  true),
          new ApplicationUser(
                  ADMINTRAINEE.getGrantedAuthorities(),
                  passwordEncoder.encode("pass123"),
                  "tom",
                  true,
                  true,
                  true,
                  true)
        );
    }

}
