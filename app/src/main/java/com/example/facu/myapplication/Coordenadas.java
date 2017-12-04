package com.example.facu.myapplication;

import java.io.Serializable;

//Created by facu on 26/11/17.

public class Coordenadas implements Serializable{
    //x = Longitud (de -180 a 180) | y = Latitud (de -90 a 90)
    private float oldx = 50;
    private float oldy = 50;
    private float x = 90;
    private float y = 90;

    public void setLong(float longitud) {
        oldx = x;
        x = longitud;
    }

    public void setLat(float latitud){
        oldy = y;
        y = latitud;
    }
    public float getOldLong(){
        return oldx;
    }
    public float getOldLat(){
        return oldy;
    }
    public float getLong(){
        return x;
    }
    public float getLat(){
        return y;
    }

}
