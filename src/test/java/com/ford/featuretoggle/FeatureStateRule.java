package com.ford.featuretoggle;

import org.junit.Assume;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static java.lang.Boolean.valueOf;
import static java.lang.System.getenv;

public class FeatureStateRule implements TestRule {
    private String FLAG_NAME = "FEATURES_%s_ENABLED";

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                OnlyRunIf feature = description.getAnnotation(OnlyRunIf.class);
                if (feature != null) {
                    String flag = getenv(String.format(FLAG_NAME, feature.feature().toString()).toUpperCase());
                    boolean enabled = valueOf(flag != null ? flag : "false");
                    checkAssumptions(enabled, feature);
                    base.evaluate();
                } else {
                    base.evaluate();
                }

            }
        };
    }

    void checkAssumptions(boolean enabled, OnlyRunIf annotation) {
        boolean expectedValue = (annotation.is() == OnlyRunIf.ToggleState.enabled) ? true : false;
        Assume.assumeTrue(enabled == expectedValue );
    }

}
