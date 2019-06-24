package com.ford.featuretoggle.features.AnZ;

import com.ford.featuretoggle.model.VinDetails;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ConditionalOnProperty(name = "features.somefeature.anz", havingValue = "false", matchIfMissing = true)
@Aspect
@Component
public class SomeFeatureForANZ {

    @Pointcut("execution(public * com.ford.featuretoggle.service.impl.VinlookupServiceAnZ.getVinlookupDetails())")
    public void anzDetails() {
    }

    @Around("anzDetails()")
    public VinDetails around(ProceedingJoinPoint pjp) throws Throwable {
        VinDetails vinDetails = new VinDetails("mockVin", "mockColor", new Date(), "MOCK-AnZ");
        return vinDetails;
    }
}
