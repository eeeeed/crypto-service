package com.cryptoserver.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
    public static Object toObject(String json, Class clazz)
    throws JsonParseException, JsonMappingException, IOException {

        Object obj = null;
        try {
            obj = new ObjectMapper().readValue(json, clazz);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }

        return obj;
    }


    public static Collection toObjects(String json, Class clazz) {

        Collection coll = new ArrayList();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            coll = objectMapper.readValue(json, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, clazz));
        } catch (IOException e) {
        	System.out.println(e.toString());
        }

        return coll;
    }
    
    public static String toString(Object obj) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
        } catch (Exception e) {
        	System.out.println(e.toString());
        }

        return json;
    }

}
