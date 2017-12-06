package com.example.facu.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private final int REQUEST_FINE_LOCATION = 1234;
    private final int REQUEST_COARSE_LOCATION = 2345;
    private final int REQUEST_LOCATION_HARDWARE = 3456;

    public Coordenadas coor;
    public List<PointF> listaCoordenadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION);
        else if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COARSE_LOCATION);
        else if (ContextCompat.checkSelfPermission(this, Manifest.permission.LOCATION_HARDWARE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.LOCATION_HARDWARE}, REQUEST_LOCATION_HARDWARE);

        setContentView(new CanvasView(this));
        coor = new Coordenadas();
        listaCoordenadas = new ArrayList<>();
    }

    @Override
    public void onLocationChanged(Location location) {
        try {
            coor.setLong((float) location.getLongitude());
            coor.setLat((float) location.getLatitude());
            PointF oldxy = new PointF(coor.getOldLong(),coor.getOldLat());
            PointF newxy = new PointF(coor.getLong(),coor.getLat());
            listaCoordenadas.add(oldxy);
            listaCoordenadas.add(newxy);
        } catch (NullPointerException e){
            Log.d("Null error", "NullPointerException caught");
        }
    }
    public List<PointF> getListaCoordenadas(){
        return listaCoordenadas;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LocationManager.GPS_PROVIDER, "Location permission granted");
                    try {
                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
                    } catch (SecurityException ex) {
                        Log.d(LocationManager.GPS_PROVIDER, "Location permission did not work!");
                    }
                }
                break;
            case REQUEST_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LocationManager.GPS_PROVIDER, "Location permission granted");
                    try {
                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
                    } catch (SecurityException ex) {
                        Log.d(LocationManager.GPS_PROVIDER, "Location permission did not work!");
                    }
                }
                break;
            case REQUEST_LOCATION_HARDWARE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LocationManager.GPS_PROVIDER, "Location permission granted");
                    try {
                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
                    } catch (SecurityException ex) {
                        Log.d(LocationManager.GPS_PROVIDER, "Location permission did not work!");
                    }
                }
                break;
        }
    }

    @Override
    protected void onResume(){
        super .onResume();
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
        } catch (SecurityException ex) {
            Log.d(LocationManager.GPS_PROVIDER, "Location permission did not work!");
        }
    }
}
