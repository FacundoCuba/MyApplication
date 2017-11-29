package com.example.facu.myapplication;

import java.io.Serializable;

//Created by facu on 26/11/17.

public class Coordenadas implements Serializable{
    //x = Latitude | y = Longitud
    private float x = 0;
    private float y = 0;
    private float oldx = 0;
    private float oldy = 0;

    public void setLat(float latitud){
        oldx = x;
        x = latitud;
    }
    public void setLong(float longitud){
        oldy = y;
        y = longitud;
    }
    public float getLat(){
        return x;
    }
    public float getOldLat(){
        return oldx;
    }
    public float getLong(){
        return y;
    }
    public float getOldLong(){
        return oldy;
    }
}
