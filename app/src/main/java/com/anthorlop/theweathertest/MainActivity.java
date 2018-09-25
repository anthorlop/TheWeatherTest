package com.anthorlop.theweathertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.anthorlop.theweathertest.adapter.CitiesRecyclerViewAdapter;
import com.anthorlop.theweathertest.dataview.CityView;
import com.anthorlop.theweathertest.interfaces.IMainPresenter;
import com.anthorlop.theweathertest.interfaces.IMainView;
import com.anthorlop.theweathertest.interfaces.OnCityListener;
import com.anthorlop.theweathertest.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView, OnCityListener {

    private EditText mEditText;
    private RecyclerView mRecyclerView;

    private CitiesRecyclerViewAdapter mAdapter;

    private IMainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        mRecyclerView = findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mEditText = findViewById(R.id.editText);

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mPresenter.searchCities(mEditText.getText().toString());
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void loadData(List<CityView> cities) {
        if (mAdapter == null) {
            mAdapter = new CitiesRecyclerViewAdapter(cities, this);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setValues(cities);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showLoading(boolean show) {
        findViewById(R.id.progress_view).setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onCityClicked(CityView cityView) {
        // go to Detail City
    }
}
