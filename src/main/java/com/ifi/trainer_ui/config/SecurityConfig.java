package com.ifi.trainer_ui.config;

import com.ifi.trainer_ui.trainers.bo.Trainer;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TrainerService trainerService;

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserDetailsService userDetailsService() {
        return new TrainerUserDetailsService();
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    private class TrainerUserDetailsService implements UserDetailsService {

        @Override
        public UserDetails loadUserByUsername(String username) {

           Trainer trainer = trainerService.getTrainer(username);

            if (trainer == null) {
                throw new BadCredentialsException("No such user");
            }
            return trainer;
        }
    }


}
