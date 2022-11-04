package com.rainpet.petclinic.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rainpet.petclinic.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

	List<Pet> findByUserIdAndOwnerId(Long userId, Long ownerId);

	List<Pet> findByUserId(Long userId);

	List<Pet> findByOwnerId(Long ownerId);



}
