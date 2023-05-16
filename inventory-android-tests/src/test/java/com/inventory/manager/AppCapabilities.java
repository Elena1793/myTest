package com.inventory.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppCapabilities {
    private static String platformName;
    private static String deviceName;
    private static String platformVersion;
    private static String appPackage;
    private static String appActivity;
    private static String noReset;

    public AppCapabilities(String fileName) {
        readCSV(fileName);
    }

    public static String getPlatformName() {
        return platformName;
    }

    public static String getDeviceName() {
        return deviceName;
    }

    public static String getPlatformVersion() {
        return platformVersion;
    }

    public static String getAppPackage() {
        return appPackage;
    }

    public static String getAppActivity() {
        return appActivity;
    }

    public static String getNoReset() {
        return noReset;
    }

    public void readCSV(String fileName) {

    ArrayList<String[]> list = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();
    String line = "";
    String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        while ((line = br.readLine()) != null) {
            String[] data = line.split(cvsSplitBy);
            list.add(data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
        for (String[] data : list) {
        for (String s : data) {
            String[] dta1 = s.split(":");
            map.put(dta1[0], dta1[1]);
        }
        for (Map.Entry m : map.entrySet()) {
            String test = m.getKey().toString().replaceAll("[^\\p{ASCII}]", "");
            if ("platformName".equals(test)) {
                platformName = m.getValue().toString();
            }
            if ("platformVersion".equals(test)) {
                platformVersion = m.getValue().toString();
            }
            if ("deviceName".equals(test)) {
                deviceName = m.getValue().toString();
            }
            if ("appPackage".equals(test)) {
                appPackage = m.getValue().toString();
            }
            if ("appActivity".equals(test)) {
                appActivity = m.getValue().toString();
            }
            if ("noReset".equals(test)) {
                noReset = m.getValue().toString();
            }
        }
    }




}
public void print(){
    System.out.println("===========++++++++++++++++++");
    System.out.println("===========platformName============" + getPlatformName());
    System.out.println("==========version=============" + getPlatformVersion());
    System.out.println("===========deviceName============" + getDeviceName());
    System.out.println("==========appPackage=============" + getAppPackage());
    System.out.println("===========appActivity============" + getAppActivity());
    System.out.println("==========noReset=============" + getNoReset());

}

}
