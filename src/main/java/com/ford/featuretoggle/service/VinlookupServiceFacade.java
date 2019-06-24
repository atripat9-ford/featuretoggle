package com.ford.featuretoggle.service;

import com.ford.featuretoggle.model.VinDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinlookupServiceFacade {

    @Autowired
    public VinLookupServiceFactory vinLookupServiceFactory;

    public VinDetails getVinlookupDetails(String country){
        VinlookupService vinlookupService = vinLookupServiceFactory.getVinlookupService(country);
        return vinlookupService.getVinlookupDetails();
    }
}
