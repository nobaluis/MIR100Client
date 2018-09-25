/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client.MIR.GET;

/**
 *
 * @author Software-01
 */
public class MissionQueue {
    
    //getMissonQueue
    private int id;
    private String state;
    private String irl;
        
    //getMissionQueue/id
    private String control_posid;
    private int control_state;
    private String created_by;
    private String created_by_id;
    private String created_by_name;
    private String finished;
    
    private String message;
    private String mission;
    private String mission_id;
    private String ordered;
    private MissionQueueParameter[] parameters;
    private int priority;
    private String started;    

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getIrl() {
        return irl;
    }

    public String getControl_posid() {
        return control_posid;
    }

    public int getControl_state() {
        return control_state;
    }

    public String getCreated_by() {
        return created_by;
    }

    public String getCreated_by_id() {
        return created_by_id;
    }

    public String getCreated_by_name() {
        return created_by_name;
    }

    public String getFinished() {
        return finished;
    }

    public String getMessage() {
        return message;
    }

    public String getMission() {
        return mission;
    }

    public String getMission_id() {
        return mission_id;
    }

    public String getOrdered() {
        return ordered;
    }

    public MissionQueueParameter[] getParameters() {
        return parameters;
    }

    public int getPriority() {
        return priority;
    }

    public String getStarted() {
        return started;
    }
        
}
