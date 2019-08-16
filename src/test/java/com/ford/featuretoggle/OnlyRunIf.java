package com.ford.featuretoggle;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
public @interface OnlyRunIf {
    ToggleState is();
    Name feature();

    enum Name {
        eu40,
        anz
    }
    enum ToggleState {
        disabled,
        enabled
    }
}

