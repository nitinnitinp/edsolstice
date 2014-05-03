/*
 * (C) Copyright 2002-2013 Hewlett-Packard Development Company, L.P.
 */

package com.edsolstice.educationportal.logic;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterLinkRelation {
    java.lang.String value();
}
