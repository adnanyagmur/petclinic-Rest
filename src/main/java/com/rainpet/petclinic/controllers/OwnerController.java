package com.rainpet.petclinic.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rainpet.petclinic.entities.Owner;
import com.rainpet.petclinic.requests.OwnerCreateRequest;
import com.rainpet.petclinic.requests.OwnerUpdateRequest;
import com.rainpet.petclinic.services.OwnerService;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

	private OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	// Burada bir opsiyenl bir mapping diyoruz User Id gelirse o aydiye göre bir return döneceğiz
	//Gelmediği durumda ise tum hepsini döneceğiz
	@GetMapping
	public List<Owner> getAllOwners(@RequestParam Optional<Long> userId){
		return ownerService.getAllOwners(userId);
	}
	
	@PostMapping
	public Owner createOneOwner(@RequestBody OwnerCreateRequest newOwnerRequest) {
		return ownerService.createOneOwner(newOwnerRequest);
	}
	
	@GetMapping("/{ownerId}")
	public Owner getOneOwner(@PathVariable Long ownerId) {
		return ownerService.getOneOwnerById(ownerId);
	}
	
	@PutMapping("/{ownerId}")
	public Owner updateOneOwner(@PathVariable Long ownerId, @RequestBody OwnerUpdateRequest updateOwner) {
		return ownerService.updateOneOwnerById(ownerId,updateOwner);
	}
	
	@DeleteMapping("/{ownerId}")
	public void deleteOneOwner(@PathVariable Long ownerId) {
		ownerService.deleteOneOwnerById(ownerId);
	}
}
