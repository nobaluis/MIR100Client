/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client.POST;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ijrobotics.mir100client.MIR.GET.MissionQueueParameter;
import java.lang.reflect.Type;

/**
 *
 * @author Software-01
 */
public class MissionParameterPayload implements JsonSerializer<MissionQueueParameter>{

    @Override
    public JsonElement serialize(MissionQueueParameter src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jObject = new JsonObject();
        jObject.addProperty("input_name", src.getLabel());
        jObject.addProperty("value", src.getValue());
        return jObject;
    }
    
}
