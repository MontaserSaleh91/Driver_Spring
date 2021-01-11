package com.mvc.drive.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.drive.models.Licenses;
import com.mvc.drive.repositories.LicenRepository;

@Service
public class LiceService {
    private final LicenRepository licenRepository;
	private static String newNumber = "000000";

    
    public LiceService(LicenRepository licenRepository) {
        this.licenRepository = licenRepository;
    }
    
    // creates a Licenses
  
	public Licenses createLicense(Licenses l) {

		newNumber = String.format("%06d", Integer.parseInt(newNumber) + 1);
		l.setNumber(newNumber);
		return licenRepository.save(l);
	}
	
    public Licenses findLicen(Long id) {
        Optional<Licenses> optionalLicen = licenRepository.findById(id);
        if(optionalLicen.isPresent()) {
            return optionalLicen.get();
        } else {
            return null;
        }
    }
    


}
