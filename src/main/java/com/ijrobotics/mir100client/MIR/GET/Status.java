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
public class Status {
    
    private String allowed_methods;
    private float battery_percentage;
    private int battery_time_remaining;
    private float distance_to_next_target;
    private StatusError errors[];
    private String footprint;
    private String map_id;
    private int mission_queue_id;
    private String mission_queue_url;
    private String mission_text;
    private int mode_id;
    private String mode_text;
    private float moved;
    private StatusPosition position;
    private String robot_model;
    private String robot_name;
    private String serial_number;
    private String session_id;
    private int state_id;
    private String state_text;
    private boolean unloaded_map_changes;
    private int uptime;
    private String user_prompt;
    private StatusVelocity velocity;

    public String getAllowed_methods() {
        return allowed_methods;
    }

    public float getBattery_percentage() {
        return battery_percentage;
    }

    public int getBattery_time_remaining() {
        return battery_time_remaining;
    }

    public float getDistance_to_next_target() {
        return distance_to_next_target;
    }

    public StatusError[] getErrors() {
        return errors;
    }

    public String getFootprint() {
        return footprint;
    }

    public String getMap_id() {
        return map_id;
    }

    public int getMission_queue_id() {
        return mission_queue_id;
    }

    public String getMission_queue_url() {
        return mission_queue_url;
    }

    public String getMission_text() {
        return mission_text;
    }

    public int getMode_id() {
        return mode_id;
    }

    public String getMode_text() {
        return mode_text;
    }

    public float getMoved() {
        return moved;
    }

    public StatusPosition getPosition() {
        return position;
    }

    public String getRobot_model() {
        return robot_model;
    }

    public String getRobot_name() {
        return robot_name;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public String getSession_id() {
        return session_id;
    }

    public int getState_id() {
        return state_id;
    }

    public String getState_text() {
        return state_text;
    }

    public boolean isUnloaded_map_changes() {
        return unloaded_map_changes;
    }

    public int getUptime() {
        return uptime;
    }

    public String getUser_prompt() {
        return user_prompt;
    }

    public StatusVelocity getVelocity() {
        return velocity;
    }
        
    
}
