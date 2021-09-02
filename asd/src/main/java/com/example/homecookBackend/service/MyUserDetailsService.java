package com.example.homecookBackend.service;

import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientDAO;
import org.orm.PersistentException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client[] clients = new Client[0];
        try {
            clients = ClientDAO.listClientByQuery("Email = '" + email + "'",null);

            Client c;
            if(clients.length > 0) {
                c = clients[0];
                return new org.springframework.security.core.userdetails.User(c.getEmail(), c.getPassword(), getAuthorityCliente());
            }
            Baker[] bakers = BakerDAO.listBakerByQuery("Email = '" + email + "'",null);
            Baker b;
            if(bakers.length >0) {
                b = bakers[0];
                return new org.springframework.security.core.userdetails.User(b.getEmail(), b.getPassword(), getAuthorityBaker());
            }

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return new org.springframework.security.core.userdetails.User(null, null, new ArrayList<>());
    }

    private Set<SimpleGrantedAuthority> getAuthorityCliente() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        return authorities;
    }

    private Set<SimpleGrantedAuthority> getAuthorityBaker() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_BAKER"));
        return authorities;
    }
}
