package com.inventory.tests;
import com.inventory.manager.AppCapabilities;
import com.inventory.manager.AppConfigCapabilities;
import com.inventory.manager.ApplicationManager;
import com.inventory.manager.DeviceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase {
    String appBuild="C:\\Tools\\VoxmeInventory-v18.0_Build_730.apk";
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static ApplicationManager app = new ApplicationManager();
    public AppCapabilities appCapabilities=new AppCapabilities(DeviceModel.capabilitiesTabletLenovo);


   @BeforeSuite
   public void setUp() throws MalformedURLException {
       appCapabilities.print();
       app.start(appCapabilities.getPlatformName(), appCapabilities.getDeviceName(),
               appCapabilities.getPlatformVersion(), appCapabilities.getAppPackage(),
               appCapabilities.getAppActivity(),  appCapabilities.getNoReset(),appBuild);

   }
    @BeforeMethod
    public void logTestStart(Method m) {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
    }

    @AfterSuite
   public void tearDown() {
       app.stop();
    }
}
