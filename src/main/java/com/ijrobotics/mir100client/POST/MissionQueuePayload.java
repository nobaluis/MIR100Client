/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client.POST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ijrobotics.mir100client.MIR.GET.MissionQueue;
import com.ijrobotics.mir100client.MIR.GET.MissionQueueParameter;
import java.lang.reflect.Type;

/**
 *
 * @author Software-01
 */
public class MissionQueuePayload implements JsonSerializer<MissionQueue>{

    @Override
    public JsonElement serialize(MissionQueue src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jObject = new JsonObject();
        jObject.addProperty("mission_id", src.getMission_id());
        jObject.addProperty("message", src.getMessage());
        jObject.add("parameters", getParamas(src.getParameters()));
        jObject.addProperty("priority", src.getPriority());
        return jObject;
    }
    
    private JsonElement getParamas(MissionQueueParameter params[]){
        GsonBuilder gsonBuildr = new GsonBuilder();
        gsonBuildr.registerTypeAdapter(MissionQueueParameter.class, new MissionParameterPayload());
        return gsonBuildr.create().toJsonTree(params);
    }
    
    
}
