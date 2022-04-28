package com.example.demo17.Security;

import com.example.demo17.Models.UtilisateurModel;
import com.example.demo17.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailSecurity implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UtilisateurModel utilisateurModel = utilisateurRepository.findBynom(username);
        if(utilisateurModel == null)
            throw new UsernameNotFoundException("utilisateur introuvable");
        return new UserPrincipal(utilisateurModel);
    }
}
