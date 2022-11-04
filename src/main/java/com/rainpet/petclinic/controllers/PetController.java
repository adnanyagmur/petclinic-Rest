package com.rainpet.petclinic.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.rainpet.petclinic.entities.Pet;
import com.rainpet.petclinic.requests.PetCreateRequest;
import com.rainpet.petclinic.requests.PetUpdateRequest;
import com.rainpet.petclinic.services.PetService;

@RestController
@RequestMapping("/api/pet")
public class PetController {
	
	private PetService petService;

	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	@GetMapping
	public List<Pet> getAllPets(@RequestParam Optional<Long> userId,
								@RequestParam Optional<Long> ownerId){
		return petService.getAllPetsWithParam(userId,ownerId);
		
	}
	
	@PostMapping
	public Pet createOnePet(@RequestBody PetCreateRequest request) {
		return petService.createOnePet(request);
	}
	
	@GetMapping("/{petId}")
	public Pet getOnePet(@PathVariable Long petId) {
		return petService.getOnePetById(petId);
	}
	
	@PutMapping("/petId")
	public Pet updateOnePet(@PathVariable Long petId, @RequestBody PetUpdateRequest request ) {
		return petService.updateOnePetById(petId, request);
	}
	
	@DeleteMapping("/{petId}")
	public void deleteOnePet(@PathVariable Long petId) {
		petService.deleteOnePetById(petId);
	}

}
