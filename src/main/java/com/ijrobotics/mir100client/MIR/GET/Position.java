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
public class Position {
    private String created_by;
    private String created_by_id;
    private String created_by_name;
    private String docking_offsets;
    private String guid;
    private String help_positions;
    private String map;
    private String map_id;
    private String name;
    private float orientation;
    private String parent;
    private String parent_id;
    private float pos_x;
    private float pos_y;
    private String type;
    private int type_id;
    private String url;

    public String getGuid() {
        return guid;
    }

    public String getMap() {
        return map;
    }

    public String getName() {
        return name;
    }

    public int getType_id() {
        return type_id;
    }

    public String getUrl() {
        return url;
    }
    
}
