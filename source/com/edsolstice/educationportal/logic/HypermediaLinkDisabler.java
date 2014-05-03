/*
 * (C) Copyright 2002-2013 Hewlett-Packard Development Company, L.P.
 */

package com.edsolstice.educationportal.logic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class used to tell the HypermediaList to check to see if a link is valid on an object.  If it is, that link will get serialized.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HypermediaLinkDisabler {
    java.lang.String rel();
    java.lang.String method() default "GET";
}
