package com.example.facu.myapplication;

import java.io.Serializable;

//Created by facu on 26/11/17.

public class Coordenadas implements Serializable{
    //x = Latitude | y = Longitud
    float x = 0;
    float y = 0;
    float oldx = 0;
    float oldy = 0;

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

    public void setLat(float latitud){
        oldx = x;
        x = latitud;
    }
    public void setLong(float longitud){
        oldy = y;
        y = longitud;
    }
}
