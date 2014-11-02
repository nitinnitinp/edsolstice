package com.edsolstice.educationportal.utility;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Example of how @JsonAnyGetter and @JsonAnySetter can be used to
 * create extensible "beans" (dyna-beans)
 *
 * @since 1.9
 */

public class DynaBean
{
	
	@JsonProperty("name")
    public String name;

    protected Map<String,Object> other = new HashMap<String,Object>();
   
    @JsonAnyGetter
    public Map<String,Object> any() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }

}