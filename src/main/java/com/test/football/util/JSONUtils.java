package com.test.football.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
	static public <T> List<T> convertFromJsonToList(String json, TypeReference<List<T>> var) throws JsonParseException, JsonMappingException, IOException
	    {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(json, var);
	    }
}
