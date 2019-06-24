package com.ford.featuretoggle.controller;

import com.ford.featuretoggle.model.VinDetails;
import com.ford.featuretoggle.service.VinlookupServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VinlookupController {

    @Autowired
    private VinlookupServiceFacade service;

    @GetMapping("/ap1/v1/vins/{country}")
    public VinDetails getVinlookupDetails(@PathVariable("country") String country) {
        return service.getVinlookupDetails(country);
    }
}
