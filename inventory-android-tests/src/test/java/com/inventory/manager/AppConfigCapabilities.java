package com.inventory.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppConfigCapabilities {
    private String platformName;
    private String deviceName;
    private String platformVersion;
    private String appPackage;
    private String appActivity;
    private String noReset;
    private String pathFileConfig;
    private String app;

    public AppConfigCapabilities(String pathFileConfig) {
        this.pathFileConfig = pathFileConfig;
    }

    public void readCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFileConfig))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("platformName:")) {
                    this.platformName = line.split(":")[1];
                } else if (line.contains("deviceName:")) {
                    this.deviceName = line.split(":")[1];
                } else if (line.contains("platformVersion:")) {
                    this.platformVersion = line.split(":")[1];
                } else if (line.contains("appPackage:")) {
                    this.appPackage = line.split(":")[1];
                }else if (line.contains("appActivity:")) {
                    this.appActivity = line.split(":")[1];
                }else if (line.contains("noReset:")) {
                    this.noReset = line.split(":")[1];
                }else if (line.contains("app:")) {
                    this.app = line.split(":")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }
    public String getAppPackage() {
        return appPackage;
    }
    public String getAppActivity() {
        return appActivity;
    }
    public String getNoReset() {return noReset; }
    public String getApp() {
        return app;
    }

public void print(){
    System.out.println("===========platformName============" + platformName);
    System.out.println("==========version=============" + platformVersion);
    System.out.println("===========deviceName============" + deviceName);
    System.out.println("==========appPackage=============" + appPackage);
    System.out.println("===========appActivity============" + appActivity);
    System.out.println("==========noReset=============" + noReset);
}

}
