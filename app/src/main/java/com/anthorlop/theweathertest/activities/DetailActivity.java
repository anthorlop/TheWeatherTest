package com.anthorlop.theweathertest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;

import com.anthorlop.theweathertest.R;
import com.anthorlop.theweathertest.dataview.CityView;

public class DetailActivity extends AppCompatActivity {

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

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
