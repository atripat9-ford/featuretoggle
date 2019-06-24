package com.ford.featuretoggle.service.impl;

import com.ford.featuretoggle.model.VinDetails;
import com.ford.featuretoggle.service.VinlookupService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VinlookupServiceAnZ implements VinlookupService {

    public VinDetails getVinlookupDetails(){

        VinDetails vinDetails = new VinDetails("anzVin", "black", new Date(), "AnZ");
        return vinDetails;
    }
}
