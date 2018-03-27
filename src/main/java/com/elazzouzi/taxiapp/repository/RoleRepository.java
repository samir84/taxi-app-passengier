package com.elazzouzi.taxiapp.repository;


import org.springframework.data.repository.CrudRepository;

import com.elazzouzi.taxiapp.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	public Role findByName(String name);
}
