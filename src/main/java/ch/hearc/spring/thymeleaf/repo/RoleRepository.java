package ch.hearc.spring.thymeleaf.repo;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.spring.thymeleaf.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
}