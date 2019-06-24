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

public class AnZDisabledTests {

    @Rule
    public RuleChain featureNegationRule = RuleChain.outerRule(new FeatureNegationRule());

    @Test
    @FeatureNegation(FeatureNegation.Name.anzFeature)
    public void testVinDetailsForDisabledAnZ() {

        RestTemplate restTemplate  = new RestTemplate();

        ResponseEntity<VinDetails> vinDetailsResponse = restTemplate.exchange("http://localhost:8080/ap1/v1/vins/anz", HttpMethod.GET, null, VinDetails.class);

        //TODO check how to change the assert statements based on annotations
        Assert.assertEquals("MOCK-AnZ",vinDetailsResponse.getBody().getSource());
    }

}