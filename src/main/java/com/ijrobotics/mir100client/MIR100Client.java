/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ijrobotics.mir100client.MIR.GET.Register;
import com.ijrobotics.mir100client.MIR.GET.Status;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software-01
 */
public class MIR100Client {
    
    RESTClient client;
    
    public MIR100Client(){
        client = new RESTClient();
        client.setHost("192.168.1.79");
        client.setAuthorization("YWRtaW46OGM2OTc2ZTViNTQxMDQxNWJkZTkwOGJkNGRlZTE1ZGZiMTY3YTljODczZmM0YmI4YTgxZjZmMmFiNDQ4YTkxOA==");
    }
    
    private Status getStatus(){
        Status status = new Gson().fromJson(client.simpleGET("status"), Status.class);
        return status;
    }
    
    public List<Register> getRegisters(){
        Type targetClassType = new TypeToken<ArrayList<Register>>() { }.getType();
        List<Register> registers = new Gson().fromJson(client.simpleGET("registers"), targetClassType);
        return registers;
    }
    
    public static void main(String args[]){
        MIR100Client mirClient = new MIR100Client();
        mirClient.getRegisters().forEach(register -> {
            System.out.println(register.getId());
            System.out.println(register.getValue());
            System.out.println();
        });
        32323
    }
}
