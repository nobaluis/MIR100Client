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
public class Mission {
    
    //getMissions
    private String guid;
    private String name;
    private String url;
    
    //getMission/guid
    private String actions;
    private String created_by;
    private String created_by_id;
    private String created_by_name;
    private String definition;
    private String description;
    private String group_id;
    private boolean hidden;
    private String session_id;
    private boolean valid;
    
    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getActions() {
        return actions;
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

    public String getDefinition() {
        return definition;
    }

    public String getDescription() {
        return description;
    }

    public String getGroup_id() {
        return group_id;
    }

    public boolean isHidden() {
        return hidden;
    }

    public String getSession_id() {
        return session_id;
    }

    public boolean isValid() {
        return valid;
    }
 
}
