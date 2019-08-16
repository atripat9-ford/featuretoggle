package com.ford.featuretoggle.service;

import com.ford.featuretoggle.FeatureStateRule;
import com.ford.featuretoggle.OnlyRunIf;
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
    public RuleChain featureNegationRule = RuleChain.outerRule(new FeatureStateRule());

    @Test
    @OnlyRunIf(feature = OnlyRunIf.Name.eu40, is= OnlyRunIf.ToggleState.disabled)
    public void testVinDetailsForDisabledE40() {

        RestTemplate restTemplate  = new RestTemplate();

        ResponseEntity<VinDetails> vinDetailsResponse = restTemplate.exchange("http://localhost:8080/ap1/v1/vins/eu40", HttpMethod.GET, null, VinDetails.class);

        Assert.assertEquals("MOCK-EU40",vinDetailsResponse.getBody().getSource());
    }

}
