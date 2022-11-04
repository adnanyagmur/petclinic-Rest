package com.rainpet.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rainpet.petclinic.entities.Owner;
import com.rainpet.petclinic.entities.Pet;
import com.rainpet.petclinic.entities.User;
import com.rainpet.petclinic.repos.PetRepository;
import com.rainpet.petclinic.requests.PetCreateRequest;
import com.rainpet.petclinic.requests.PetUpdateRequest;

@Service
public class PetService {

	private PetRepository petRepository;
	private UserService userService;
	private OwnerService ownerService;

	public PetService(PetRepository petRepository,UserService userService, OwnerService ownerService) {
		this.petRepository = petRepository;
		this.userService = userService;
		this.ownerService = ownerService;
	}

	public List<Pet> getAllPetsWithParam(Optional<Long> userId, Optional<Long> ownerId) {
		if(userId.isPresent() && ownerId.isPresent()) {
			return petRepository.findByUserIdAndOwnerId(userId.get(), ownerId.get());
		}else if(userId.isPresent()) {
			return petRepository.findByUserId(userId.get());
		}else if(ownerId.isPresent()) {
			return petRepository.findByOwnerId(ownerId.get());
		}else
		return petRepository.findAll();
	}

	public Pet getOnePetById(Long petId) {
		return petRepository.findById(petId).orElse(null);
	}

	public Pet createOnePet(PetCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Owner owner = ownerService.getOneOwnerById(request.getOwnerId());
		if(user !=null  && owner !=null) {
			Pet petToSave = new Pet();
			petToSave.setId(request.getId());
			petToSave.setOwner(owner);
			petToSave.setUser(user);
			petToSave.setName(request.getName());
			petToSave.setAge(request.getAge());
			petToSave.setBreed(request.getBreed());
			petToSave.setDescription(request.getDescription());
			petToSave.setSpecies(request.getSpecies());
			return petRepository.save(petToSave);
		}else
			return null;
	}

	public Pet updateOnePetById(Long petId, PetUpdateRequest request) {
		Optional<Pet> pet = petRepository.findById(petId);
		if(pet.isPresent()) {
			Pet petToUpdate = pet.get();
			petToUpdate.setName(request.getName());
			petToUpdate.setAge(request.getAge());
			petToUpdate.setBreed(request.getBreed());
			petToUpdate.setDescription(request.getDescription());
			petToUpdate.setSpecies(request.getSpecies());
			return petRepository.save(petToUpdate);
		}else
			return null;
	}

	public void deleteOnePetById(Long petId) {
		petRepository.deleteById(petId);
		
	}
	
	
}
