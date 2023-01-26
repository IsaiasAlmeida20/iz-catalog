package br.com.izan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.izan.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
