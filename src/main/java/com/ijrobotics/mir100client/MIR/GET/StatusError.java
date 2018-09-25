/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client.MIR.GET;

/**
 *
 * @author Software
 */
public class StatusError{
    
    private int code;
    private String description;
    private String module;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getModule() {
        return module;
    }
  
}
