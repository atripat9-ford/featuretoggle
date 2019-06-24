package com.ford.featuretoggle.service;

import com.ford.featuretoggle.FeatureNegation;
import com.ford.featuretoggle.FeatureNegationRule;
import com.ford.featuretoggle.model.VinDetails;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EU40DisabledTests {

    @Rule
    public RuleChain featureNegationRule = RuleChain.outerRule(new FeatureNegationRule());

    @Test
    @FeatureNegation(FeatureNegation.Name.eu40Feature)
    public void testVinDetailsForDisabledE40() {

        RestTemplate restTemplate  = new RestTemplate();

        ResponseEntity<VinDetails> vinDetailsResponse = restTemplate.exchange("http://localhost:8080/ap1/v1/vins/eu40", HttpMethod.GET, null, VinDetails.class);

        //TODO check how to change the assert statements based on annotations
        Assert.assertEquals("MOCK-EU40",vinDetailsResponse.getBody().getSource());
    }

}
