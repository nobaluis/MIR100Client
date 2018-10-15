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
import com.ijrobotics.mir100client.MIR.GET.Register;
import java.lang.reflect.Type;

/**
 *
 * @author Software-01
 */
public class RegisterPayload  implements JsonSerializer<Register>{

    @Override
    public JsonElement serialize(Register src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jObject = new JsonObject();
        jObject.addProperty("value", src.getValue());
        jObject.addProperty("label", src.getLabel());
        return jObject;
    }
    
}
