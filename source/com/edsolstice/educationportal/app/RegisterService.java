/*
 * (C) Copyright 2002-2013 Hewlett-Packard Development Company, L.P.
 */

package com.edsolstice.educationportal.app;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterService {
    java.lang.String value();
}
