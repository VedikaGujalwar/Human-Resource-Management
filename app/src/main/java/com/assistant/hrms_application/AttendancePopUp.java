//package com.assistant.hrms_application;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.IntentSender;
//import android.content.pm.PackageManager;
//import android.location.LocationManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Looper;
//import android.os.PersistableBundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.common.api.ResolvableApiException;
//import com.google.android.gms.location.LocationCallback;
//import com.google.android.gms.location.LocationRequest;
//import com.google.android.gms.location.LocationResult;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.location.LocationSettingsRequest;
//import com.google.android.gms.location.LocationSettingsResponse;
//import com.google.android.gms.location.LocationSettingsStatusCodes;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//
//public class AttendancePopUp extends AppCompatActivity implements OnMapReadyCallback {
//
//    MapView map;
//    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
//    TextView lat, lon;
//    private GoogleMap gmap;
//    LocationRequest locationRequest;
//    double lat2, lon2;
//    private GoogleMap googleMap;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        lat = findViewById(R.id.lat);
//        lon = findViewById(R.id.lon);
//        map = (MapView) findViewById(R.id.map);
//
//        locationRequest = LocationRequest.create();
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        locationRequest.setInterval(5000);
//        locationRequest.setFastestInterval(2000);
//
//        Bundle mapViewBundle = null;
//        if (savedInstanceState != null) {
//            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
//        }
//        map.onCreate(mapViewBundle);
//        map.getMapAsync(this);
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ActivityCompat.checkSelfPermission(AttendancePopUp.this, Manifest.permission.ACCESS_FINE_LOCATION) ==
//                    PackageManager.PERMISSION_GRANTED) {
//                if (isGPSEnabled()) {
//                    LocationServices.getFusedLocationProviderClient(AttendancePopUp.this).requestLocationUpdates(locationRequest, new LocationCallback() {
//                        @Override
//                        public void onLocationResult(@NonNull LocationResult locationResult) {
//                            super.onLocationResult(locationResult);
//                            LocationServices.getFusedLocationProviderClient(AttendancePopUp.this).removeLocationUpdates(this);
//                            //Taking location coordinates of login device
//                            if (locationResult != null && locationResult.getLocations().size() > 0) {
//                                int index = locationResult.getLocations().size() - 1;
//                                lat2 = locationResult.getLocations().get(index).getLatitude();
//                                lon2 = locationResult.getLocations().get(index).getLongitude();
//                                lat.setText("Latitude: "+ lat2);
//                                lon.setText("Longitude: "+ lon);
//
//                            }
//                        }
//                    }, Looper.getMainLooper());
//                } else {
//                    turnOnGPS();
//                }
//
//            } else {
//                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//            }
//        }
//
//    }
//
//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//        this.googleMap = googleMap;
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//
//        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
//        if (mapViewBundle == null) {
//            mapViewBundle = new Bundle();
//            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
//        }
//        map.onSaveInstanceState(mapViewBundle);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        map.onResume();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        map.onStop();
//    }
//
//    public void onMapReady() {
//        onMapReady();
//    }
//
//
//    //turning on the GPS of Device
//    private void turnOnGPS() {
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
//        builder.setAlwaysShow(true);
//        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builder.build());
//        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
//            @Override
//            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
//                try {
//                    LocationSettingsResponse response = task.getResult(ApiException.class);
//                    Toast.makeText(AttendancePopUp.this, "GPS is already tured on", Toast.LENGTH_SHORT).show();
//                } catch (ApiException e) {
//
//                    switch (e.getStatusCode()) {
//                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//
//                            try {
//                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
//                                resolvableApiException.startResolutionForResult(AttendancePopUp.this, 2);
//                            } catch (IntentSender.SendIntentException ex) {
//                                ex.printStackTrace();
//                            }
//                            break;
//
//                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                            //Device does not have location
//                            break;
//                    }
//                }
//            }
//        });
//    }
//    //Checking for GPS
//    private boolean isGPSEnabled() {
//
//        LocationManager locationManager = null;
//        boolean isEnabled = false;
//
//        if (locationManager == null) {
//            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        }
//
//        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//        return isEnabled;
//    }
//
//    @Override
//    protected void onPause() {
//        map.onPause();
//        super.onPause();
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        map.onLowMemory();
//    }
//}
