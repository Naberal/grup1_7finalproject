package com.group1_7.finalproject.service;

import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class WorkerDetailsService implements UserDetailsService {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Worker worker = workerRepository.findByEmail(email);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(worker.getRole().name());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(authority);
        return new User(email, worker.getPass(), grantedAuthorities);
    }
}
