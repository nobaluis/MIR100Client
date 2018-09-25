/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.mir100client;

/**
 *
 * @author Software-01
 */
public class Test {
    
    MIR100Client mir;
    
    public Test(){
        mir = new MIR100Client();
        mir.setHost("192.168.1.79");
        mir.setAuthorization("YWRtaW46OGM2OTc2ZTViNTQxMDQxNWJkZTkwOGJkNGRlZTE1ZGZiMTY3YTljODczZmM0YmI4YTgxZjZmMmFiNDQ4YTkxOA==");
    }
    
    public static void main(String args[]){
        Test mirClient = new Test();
    }
}
