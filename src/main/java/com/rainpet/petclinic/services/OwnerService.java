package com.rainpet.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.rainpet.petclinic.entities.Owner;
import com.rainpet.petclinic.entities.User;
import com.rainpet.petclinic.repos.OwnerRepository;
import com.rainpet.petclinic.requests.OwnerCreateRequest;
import com.rainpet.petclinic.requests.OwnerUpdateRequest;

@Service
public class OwnerService {

	private OwnerRepository ownerRepository;
	
	private UserService  userService;

	public OwnerService(OwnerRepository ownerRepository, UserService userService) {
		this.ownerRepository = ownerRepository;
		this.userService = userService;
	}

	public List<Owner> getAllOwners(Optional<Long> userId) {
		if(userId.isPresent()) {
			return ownerRepository.findByUserId(userId.get());
		}else{
		return ownerRepository.findAll();
		}
	}

	public Owner getOneOwnerById(Long ownerId) {
		return ownerRepository.findById(ownerId).orElse(null);
	}

	// Burada user sevise gidip ilgli user id ile ilgili istek atılınca owner a
	// Böyle bir user var mı diye kontrol ettiriyoruz
	public Owner createOneOwner(OwnerCreateRequest newOwnerRequest) {
		User user = userService.getOneUserById(newOwnerRequest.getUserId());
		if(user == null) {
			return null;
		}else {
			Owner toSave = new Owner();
			toSave.setId(newOwnerRequest.getId());
			toSave.setAddress(newOwnerRequest.getAddress());
			toSave.setMail(newOwnerRequest.getMail());
			toSave.setName(newOwnerRequest.getName());
			toSave.setPhoneNumber(newOwnerRequest.getPhoneNumber());
			toSave.setSurname(newOwnerRequest.getSurname());
			toSave.setUser(user);
			return ownerRepository.save(toSave);
		}
	}

	public Owner updateOneOwnerById(Long ownerId, OwnerUpdateRequest updateOwner) {
		Optional<Owner> owner = ownerRepository.findById(ownerId);
		if(owner.isPresent()) {
			Owner toUpdate = owner.get();
			toUpdate.setAddress(updateOwner.getAddress());
			toUpdate.setMail(updateOwner.getMail());
			toUpdate.setName(updateOwner.getName());
			toUpdate.setPhoneNumber(updateOwner.getPhoneNumber());
			toUpdate.setSurname(updateOwner.getSurname());
			ownerRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOneOwnerById(Long ownerId) {
		ownerRepository.deleteById(ownerId);
		
	}

	
	
}
