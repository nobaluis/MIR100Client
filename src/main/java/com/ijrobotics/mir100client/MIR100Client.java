/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ijrobotics.mir100client.MIR.GET.Mission;
import com.ijrobotics.mir100client.MIR.GET.MissionQueue;
import com.ijrobotics.mir100client.MIR.GET.Path;
import com.ijrobotics.mir100client.MIR.GET.Position;
import com.ijrobotics.mir100client.MIR.GET.Register;
import com.ijrobotics.mir100client.MIR.GET.Status;
import com.ijrobotics.mir100client.POST.MissionQueuePayload;
import com.ijrobotics.mir100client.POST.RegisterPayload;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
    
    public String simpleGET(String endPoint){
        Response response = baseReq(endPoint).get();
        return response.readEntity(String.class);
    }
    
    public String getSerialization(Type type, Object typeAdapter, Object toSerialize){
        GsonBuilder gsonBuildr = new GsonBuilder();
        gsonBuildr.registerTypeAdapter(type, typeAdapter);
        String jsonString = gsonBuildr.create().toJson(toSerialize);
        return jsonString;
    }
    
    public String simplePOST(String endPoint, String payload){
        Response response = baseReq(endPoint).post(Entity.json(payload));
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
    
    public Register getRegister(int id){
        Register register  = new Gson().fromJson(simpleGET("registers/"+id), Register.class);
        return register;
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
    
    public List<MissionQueue> getMissionQueues(){
        Type targetClassType = new TypeToken<ArrayList<MissionQueue>>() { }.getType();
        List<MissionQueue> missionQueues = new Gson().fromJson(simpleGET("mission_queue"), targetClassType);
        return missionQueues;
    }
        
    public MissionQueue getMissionQueue(int id){
        MissionQueue missionQueue = new Gson().fromJson(simpleGET("mission_queue/"+id), MissionQueue.class);
        return missionQueue;
    }
    
    public List<Path> getPaths(){
        Type targetClassType = new TypeToken<ArrayList<Path>>() { }.getType();
        List<Path> paths = new Gson().fromJson(simpleGET("paths"), targetClassType);
        return paths;
    }
    
    public List<Position> getPositions(){
        Type targetClassType = new TypeToken<ArrayList<Position>>() { }.getType();
        List<Position> positions = new Gson().fromJson(simpleGET("positions"), targetClassType);
        return positions;
    }
    
    public Position getposition(String guid){
        Position position = new Gson().fromJson(simpleGET("positions/"+guid), Position.class);
        return position;
    }
    
    public Register setRegister(Register register){
        String payload = getSerialization(Register.class, new RegisterPayload(), register);
        String response = simplePOST("registers/"+register.getId(),payload);
        Register newRegister = new Gson().fromJson(response, Register.class);
        return newRegister;
    }
    
    public MissionQueue setMissionQueue(MissionQueue mission){
        String payload = getSerialization(MissionQueue.class, new MissionQueuePayload(), mission);
        String response = simplePOST("mission_queue",payload);
        MissionQueue newMission = new Gson().fromJson(response, MissionQueue.class);
        return newMission;
    }
    
}
