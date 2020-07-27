package com.assignment.qa.util;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.LocationDetails;

public class Utils extends TestBase {
    public static int PAGE_LOAD_TIMEOUT = 20;
    public static int IMPLICIT_WAIT = 30;
    public static int EXPLICIT_WAIT = 20;

    public static boolean temperatureComparator(LocationDetails uiLocationDetails, LocationDetails apiLocationDetails, TemperatureType temperatureType) {
        if (temperatureType.equals(TemperatureType.DEGREES))
            System.out.println("uiLocationDetails = " + uiLocationDetails.getTemperatureInDegrees());
            System.out.println("apiLocationDetails = " + apiLocationDetails.getTemperatureInDegrees());
            uiLocationDetails.getTemperatureInDegrees().equalsIgnoreCase(apiLocationDetails.getTemperatureInDegrees());
        return false;
    }

}

