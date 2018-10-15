/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ijrobotics.mir100client.MIR.GET.Mission;
import com.ijrobotics.mir100client.MIR.GET.MissionQueue;
import com.ijrobotics.mir100client.MIR.GET.MissionQueueParameter;
import com.ijrobotics.mir100client.MIR.GET.Position;
import com.ijrobotics.mir100client.MIR.GET.Register;
import com.ijrobotics.mir100client.MIR.GET.Status;
import com.ijrobotics.mir100client.POST.RegisterPayload;
import java.util.List;

/**
 *
 * @author Software-01
 */
public class test {
    
    MIR100Client client;
    
    public test(){
        client = new MIR100Client();
        client.setHost("192.168.12.20");
        client.setAuthorization("YWRtaW46OGM2OTc2ZTViNTQxMDQxNWJkZTkwOGJkNGRlZTE1ZGZiMTY3YTljODczZmM0YmI4YTgxZjZmMmFiNDQ4YTkxOA==");
        //Status status = client.getStatus();
        //System.out.println(status.getBattery_percentage());
        
        //Test json serialization
//        Register register = new Register();
//        register.setId(1);
//        register.setValue(15);
//        register.setLabel("");
//        Register newRegister = client.setRegister(register);
//        System.out.println("New Value: "+newRegister.getValue());
        
//        GsonBuilder gsonBuildr = new GsonBuilder();
//        gsonBuildr.registerTypeAdapter(Register.class, new RegisterPayload());
//        String jsonString = gsonBuildr.create().toJson(register);
//        System.out.println(jsonString);

//        List<Position> positions = client.getPositions();
//
//        positions.forEach(position ->{
//            System.out.println(new Gson().toJson(position));
//        });
//        
//        Position pos2 = client.getposition(positions.get(2).getGuid());
//        System.out.println(new Gson().toJson(pos2));

//        List<Mission> missions = client.getMissions();
//        missions.forEach(mission ->{
//            System.out.println(new Gson().toJson(mission));
//        });

//        List<MissionQueue> missionQueues = client.getMissionQueues();
//        missionQueues.forEach(missionQueue ->{
//            System.out.println(new Gson().toJson(missionQueue));
//        });
//        
//        MissionQueue mission = missionQueues.get(181);
//        System.out.println(new Gson().toJson(client.getMissionQueue(mission.getId())));
          
        MissionQueue mission = new MissionQueue();
        mission.setMission_id("a9eaa825-c750-11e8-8623-94c6911cefc8"); //goTarget
        mission.setMessage("");
        MissionQueueParameter param = new MissionQueueParameter();
        param.setLabel("target");
        //param.setValue("e0257330-7fa4-11e8-a84f-94c6911cefc8"); //pos1
        param.setValue("015493a3-7fa5-11e8-a84f-94c6911cefc8"); //pos2
        mission.setParameters(new MissionQueueParameter[]{param});
        mission.setPriority(0);
        
        MissionQueue newMission = client.setMissionQueue(mission);
        System.out.println(new Gson().toJson(newMission));
    }
    
    public static void main(String args[]){
        new test();
    }
}
