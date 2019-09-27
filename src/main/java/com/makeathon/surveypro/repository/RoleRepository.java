package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.Role;
import com.makeathon.surveypro.util.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);

}
