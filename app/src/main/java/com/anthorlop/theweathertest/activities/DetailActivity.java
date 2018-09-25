package com.anthorlop.theweathertest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;

import com.anthorlop.theweathertest.R;
import com.anthorlop.theweathertest.dataview.CityView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String CITY_ITEM = "CITY_ITEM";

    private CityView mCityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getActionBar() != null)
            getActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null) {
            mCityView = getIntent().getParcelableExtra(CITY_ITEM);
        }

        if (mCityView == null || TextUtils.isEmpty(mCityView.getName()))
            return;

        ((TextView) findViewById(R.id.nameTxt)).setText(mCityView.getNameWithCountry());

        SupportMapFragment mMapView = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);

        if (mMapView != null) {
            mMapView.getMapAsync(this);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap gmap) {
        gmap.setMinZoomPreference(12);

        LatLng latlng = new LatLng(Double.valueOf(mCityView.getLat()), Double.valueOf(mCityView.getLng()));
        gmap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
    }
}
