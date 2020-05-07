package com.example.usuario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.commons.users.domains.model.Role;

@RepositoryRestResource(path = "roles")
public interface RoleRespository extends PagingAndSortingRepository<Role, Long>{
	
}
