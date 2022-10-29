package com.jwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.entity.UserEntity;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity,Long>{

	UserEntity findByUsername(String username);
}
