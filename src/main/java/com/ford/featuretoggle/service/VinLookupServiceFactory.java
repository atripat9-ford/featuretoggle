package com.ford.featuretoggle.service;

import com.ford.featuretoggle.service.impl.VinlookupServiceAnZ;
import com.ford.featuretoggle.service.impl.VinlookupServiceE40;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinLookupServiceFactory {

     @Autowired
     VinlookupServiceE40 vinlookupServiceEU40;

     @Autowired
     VinlookupServiceAnZ vinlookupServiceAnZ;

     public VinlookupService getVinlookupService(String country) {

          switch (country.toLowerCase()) {
              case "eu40" : return vinlookupServiceEU40;
              case "anz"  : return vinlookupServiceAnZ;

          }

          return null;
     }
}
