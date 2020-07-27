package com.assignment.qa.util;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.LocationDetails;

public class Utils extends TestBase {
    public static int PAGE_LOAD_TIMEOUT = 20;
    public static int IMPLICIT_WAIT = 30;
    public static int EXPLICIT_WAIT = 20;

    public static boolean temperatureComparator(LocationDetails uiLocationDetails, LocationDetails apiLocationDetails, TemperatureType temperatureType) {
        if (temperatureType.equals(TemperatureType.DEGREES)){
            System.out.println("****** Before rounding the value******");
            System.out.println("uiTempDetails = " + uiLocationDetails.getTemperatureInDegrees());
            System.out.println("apiTempDetails = " + apiLocationDetails.getTemperatureInDegrees());
            uiLocationDetails.getTemperatureInDegrees().equalsIgnoreCase(apiLocationDetails.getTemperatureInDegrees());

            System.out.println("****** After rounding the value******");
            uiLocationDetails.getTemperatureInDegrees().equalsIgnoreCase(apiLocationDetails.getTemperatureInDegrees());

            int uiTemp = (int) Math.round(Double.parseDouble(uiLocationDetails.getTemperatureInDegrees()));
            int apiTemp = (int) Math.round(Double.parseDouble(apiLocationDetails.getTemperatureInDegrees()));
            System.out.println("UI temp rounded: " + uiTemp);
            System.out.println("Api rounded: " + apiTemp);
            if(uiTemp == apiTemp){
                return true;
            }
        }
        return false;
    }

}

