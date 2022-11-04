package com.rainpet.petclinic.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rainpet.petclinic.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
