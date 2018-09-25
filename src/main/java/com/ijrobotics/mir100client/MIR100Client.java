/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ijrobotics.mir100client.MIR.GET.Mission;
import com.ijrobotics.mir100client.MIR.GET.Register;
import com.ijrobotics.mir100client.MIR.GET.Status;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Software-01
 */
public class MIR100Client {
    
    StringProperty  host;
    StringProperty  authorization;
    Client client;
    WebTarget baseURL;
    
    public MIR100Client(){
        this(null,null);
    }
    
    public MIR100Client(String _host, String _authorization){
        this.host = new SimpleStringProperty(_host);
        this.authorization = new SimpleStringProperty(_authorization);
        //Client Configuration
        this.client = ClientBuilder.newClient();
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
    }
    
    public void setHost(String _host){
        host.set(_host);
    }
    
    public String getHost(){
        return host.get();
    }
    
    public void setAuthorization(String _authorization){
        authorization.set(_authorization);
    }
    
    public String getAuthorization(){
        return authorization.get();
    }
    
    private Invocation.Builder baseReq(String path){
        baseURL = client.target("http://"+host.get()+"/api/v2.0.0");
        WebTarget target = baseURL.path(path);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("Content-Type", "application/json");
        invocationBuilder.header("Accept-Language", "en_US");
        invocationBuilder.header("Host", host.get()+":8080");
        invocationBuilder.header("Authorization", "Basic "+authorization.get());
        return invocationBuilder;
    }
    
    private String simpleGET(String endPoint){
        Response response = baseReq(endPoint).get();
        return response.readEntity(String.class);
    }
    
    public Status getStatus(){
        Status status = new Gson().fromJson(simpleGET("status"), Status.class);
        return status;
    }
    
    public List<Register> getRegisters(){
        Type targetClassType = new TypeToken<ArrayList<Register>>() { }.getType();
        List<Register> registers = new Gson().fromJson(simpleGET("registers"), targetClassType);
        return registers;
    }
    
    public List<Mission> getMissions(){
        Type targetClassType = new TypeToken<ArrayList<Mission>>() { }.getType();
        List<Mission> missions = new Gson().fromJson(simpleGET("missions"), targetClassType);
        return missions;
    }
    
    public Mission getMission(String guid){
        Mission mission = new Gson().fromJson(simpleGET("missions/"+guid), Mission.class);
        return mission;
    }
    
}
