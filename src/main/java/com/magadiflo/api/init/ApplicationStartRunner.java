package com.magadiflo.api.init;

import com.magadiflo.api.model.Role;
import com.magadiflo.api.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class ApplicationStartRunner implements CommandLineRunner {

    private final IRoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L, "123", "ROLE_USER");
        Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");

        this.roleRepository.saveAll(Arrays.asList(roleUser, roleAdmin));
    }

}
