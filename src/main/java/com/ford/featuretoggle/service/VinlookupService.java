package com.ford.featuretoggle.service;

import com.ford.featuretoggle.model.VinDetails;
import org.springframework.stereotype.Service;

@Service
public interface VinlookupService {

    VinDetails getVinlookupDetails();
}
