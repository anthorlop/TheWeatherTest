package com.anthorlop.theweathertest.interfaces;

/**
 * TheWeatherTest
 *
 * @author antonio.hormigo
 *
 */
public interface IDetailView {

    void loadTemperature(float temp);

    void loadMessageError(int messageResource);

    // TODO void loadTime(String timeHHmm);

}
