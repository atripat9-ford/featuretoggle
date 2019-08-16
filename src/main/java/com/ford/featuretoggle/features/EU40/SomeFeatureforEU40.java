package com.ford.featuretoggle.features.EU40;

import com.ford.featuretoggle.model.VinDetails;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ConditionalOnProperty(name = "features.somefeature.eu40", havingValue = "false", matchIfMissing = true)
@Aspect
@Component
public class SomeFeatureforEU40 {

    @Pointcut("execution(public * com.ford.featuretoggle.service.impl.VinlookupServiceE40.getVinlookupDetails())")
    public void eu40Details() {
    }

    @Around("eu40Details()")
    public VinDetails around(ProceedingJoinPoint pjp) throws Throwable {
        //TODO check the config at run time and decide whether to call the backend system.

        VinDetails vinDetails = new VinDetails("mockVin", "mockColor", new Date(), "MOCK-EU40");
        return vinDetails;
    }
}
