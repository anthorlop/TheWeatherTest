package com.anthorlop.theweathertest.animations;

import android.support.v4.content.ContextCompat;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anthorlop.theweathertest.R;

public class ProgressBarAnimation extends Animation {
    private ProgressBar progressBar;
    private TextView textView;
    private float from;
    private float  to;

    public ProgressBarAnimation(ProgressBar progressBar, TextView textView, float from, float to) {
        super();
        this.progressBar = progressBar;
        this.textView = textView;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);

        int color = R.color.temp_8;

        if (value < 5) {
            color = R.color.temp_1;
        } else if (value < 10) {
            color = R.color.temp_2;
        } else if (value < 15) {
            color = R.color.temp_3;
        } else if (value < 20) {
            color = R.color.temp_4;
        } else if (value < 25) {
            color = R.color.temp_5;
        } else if (value < 30) {
            color = R.color.temp_6;
        } else if (value < 35) {
            color = R.color.temp_7;
        }

        progressBar.getProgressDrawable().setColorFilter(
                ContextCompat.getColor(progressBar.getContext(), color), android.graphics.PorterDuff.Mode.SRC_IN);

        String temperature = String.valueOf(value);

        if (temperature.length() > 4) {
            temperature = temperature.substring(0, 4);
        }
        textView.setText(temperature);

        textView.setTextColor(ContextCompat.getColor(textView.getContext(), color));
    }

}