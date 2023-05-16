package com.inventory.manager;

import com.google.common.io.Files;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.lang.Thread.sleep;
import static java.time.Duration.ofSeconds;

public class ApplicationManager {

    public boolean isPhone =false;
    public AndroidDriver driver;
    //String app="C:\\Tools\\VoxmeInventory-v18.0_Build_730.apk";


   /* public void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "HGAJQ60E");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.voxme.inventory.tablet");
        capabilities.setCapability("appActivity", "com.voxme.inventory.ui.StartupActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("app", "C:\\Tools\\VoxmeInventory-v18.0_Build_730.apk");
        // capabilities.setCapability("sauceLabsImageInjectionEnabled", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getSize().getHeight());
        System.out.println(driver.manage().window().getSize().getWidth());
        if(driver.manage().window().getSize().getWidth()<600){
            System.out.println("phone") ;
            System.out.println(driver.manage().window().getSize().getWidth()>600) ;
            isPhone =true;
        }else {
            System.out.println("tablet") ;
        }


    }*/


    public void start(String platformName, String deviceName,
                      String platformVersion, String appPackage,
                      String appActivity, String noReset,String app) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, noReset);
        capabilities.setCapability(MobileCapabilityType.APP, app);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        if(driver.manage().window().getSize().getWidth()>900){
            System.out.println("phone") ;
            System.out.println(driver.manage().window().getSize().getWidth()) ;
            isPhone =true;
        }else {
            System.out.println("tablet") ;
        }

    }
    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }
    public void click_iConCamera(){
        WebElement lement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.id("com.voxme.inventory.tablet:id/article_photo_btn")));
        lement.click();
    }
    public void attachPhotoFromCamera() throws InterruptedException {
        //click(By.id("com.voxme.inventory.tablet:id/article_photo_btn"));
        click_iConCamera();
        if (isElementPresent(By.id("android:id/message"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
            dynamicElement.click();
            if (isElementPresent(By.id("com.android.permissioncontroller:id/permission_icon"))) {
                By myNEW=By.xpath("//*[contains(@resource-id,'permission_allow')]");
                By myOLD=By.id("com.android.permissioncontroller:id/permission_allow_button");
                WebElement dynamicElement1 = (new WebDriverWait(driver, 100))
                        .until(ExpectedConditions.elementToBeClickable(myNEW));
                dynamicElement1.click();
                click_iConCamera();

            }

        }
        click_takePhoto_onCamera();
        savePhoto_afterTakePhoto_byCamera();


    }
    private void click_iConCamera1(By id) {
        WebElement lement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(id));
        lement.click();
    }
    public void attachPhotoFromCamera_RoomCondition() throws InterruptedException {
        //click(By.id("com.voxme.inventory.tablet:id/article_photo_btn"));
        click_iConCamera1(By.id("com.voxme.inventory.tablet:id/add_photo"));
        if (isElementPresent(By.id("android:id/message"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
            dynamicElement.click();
            if (isElementPresent(By.id("com.android.permissioncontroller:id/permission_icon"))) {
                WebElement dynamicElement1 = (new WebDriverWait(driver, 100))
                        .until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
                dynamicElement1.click();
                click_iConCamera1(By.id("com.voxme.inventory.tablet:id/add_photo"));

            }

        }
        click_takePhoto_onCamera();
        savePhoto_afterTakePhoto_byCamera();


    }



    public void click_takePhoto_onCamera(){
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@resource-id,'shutter_button')]")));
        dynamicElement.click();
       // click(By.id("org.codeaurora.snapcam:id/shutter_button"));
    }
    public void savePhoto_afterTakePhoto_byCamera(){
      //  By.xpath("")
        /*WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.id("org.codeaurora.snapcam:id/done_button")));
        dynamicElement.click();*/
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.id("//*[contains(@resource-id,'done_button')]")));
        dynamicElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //


       // click(By.id("org.codeaurora.snapcam:id/done_button"));
    }


    public void clickOnGalleryButton()
    {
        click(By.id("article_img_gallery_btn"));
    }

     public void attachPhotoFromGallery() throws InterruptedException {

         click(By.id("article_img_gallery_btn"));
         if (isElementPresent(By.id("android:id/message"))){
             WebElement dynamicElement = (new WebDriverWait(driver, 100))
                     .until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
             dynamicElement.click();
             if (isElementPresent(By.id("com.android.permissioncontroller:id/permission_icon"))){
                 WebElement dynamicElement1 = (new WebDriverWait(driver, 100))
                         .until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
                 dynamicElement1.click();
                 click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));
             }

         }else
             click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));
       /* if(isElementPresent(By.xpath("//*[contains(@resource-id, 'message') and @text='You need to grant access to android.permission.READ_MEDIA_IMAGES to be able to access images from the gallery.']")))
        {
           click(By.xpath("//*[contains(@resource-id, 'button1') and @text = 'OK']"));

           click(By.id("permission_allow_button"));
           click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));
        }
        else
            click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));*/

    }
    public void clickOnSavePhotoFromCamera()
    {
        click(By.xpath("//*[contains(@resource-id, 'v9_capture_picker_layout') and @index = 2]"));
    }
    public void selectPhotoFronGallery()
    {
        //click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));
        click(By.xpath("//*[contains(@content-desc,'IMG_20230501_113549.jpg, 2.10 MB, 1 May') and @index=1]"));
    }

    public void waitForElement(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void screenshot() {
        File tmp = driver.getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test/resources/Screenshots/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
            System.out.println(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void stop() {
        driver.quit();
    }

    public void returnButton(){
        WebElement element = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//*[@resource-id=\"com.voxme.inventory.tablet:id/action_bar\"]/*[@class=\"android.widget.ImageButton\"]")));

        element.click();
    }

    public void clickToTheReturnUpButton() throws InterruptedException {
        /*WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@content-desc='Navigate up']")));
        dynamicElement.click();

*/returnButton();
    }


    public void click_Return_button_FromViewPhoto(){
       returnButton();
      /*  if (isElementPresent(By.xpath("//*[@content-desc='Navigate up']"))) {
            click(By.xpath("//*[@content-desc='Navigate up']"));
            // Thread.sleep(6000);

        } else
            driver.findElement(By.xpath("//*[@content-desc='aaa']")).click();*/
    }

    public void click_Return_button_FromLabelDetails(){

        returnButton();
    }
    public void click_Return_button_FromPackageDetails(){

        returnButton();
    }
    public void click_Return_button_FromInspectionCondition(){

        returnButton();
    }
    public void click_Return_button_FromRoomDetails(){

       returnButton();
    }


    public void selectClientFromTheDiscovery() {
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'android.widget.RelativeLayout') and @index=0]")));
        dynamicElement.click();
      //  click(By.xpath("//*[contains(@class,'android.widget.RelativeLayout') and @index=0]"));
    }

    public void clickOnTheUploadButton() throws InterruptedException {
        click(By.xpath("//*[contains(@resource-id,'upload_button')]"));
        sleep(35000);
    }

    public void clickOnTheCreateNewInventoryButton() {
        if (isElementPresent(By.id("newInventory"))) {
            click(By.id("newInventory"));
        } else
            click(By.xpath("//*[contains@resource-id,'newInventory']"));
    }

    public void typeClientLastNameInTheNameField(String clientLastName) {
        type(By.id("inventory_name"), clientLastName);
    }

    public void clickOnTheCreateButton() {
        click(By.id("create_btn"));
    }

    public void click_DownloadInventory_button() {
        waitForElement(10, By.id("downloadJobs"));
        click(By.id("downloadJobs"));
    }

    public void type_value_inDiscoveryField(String inventoryRef) throws InterruptedException {
        hideKeyboard();
        type(By.id("search_string"), inventoryRef);
        click(By.id("search_mfs"));
        sleep(1000);
    }

    public void select_FoundedTransaction_inTheDownloadJobGrid() {
        click(By.id("mf_name"));
        //click(By.xpath("//*[contains(@resource-id,'mf_name') and @text='Anton Nakonechnyi']"));

    }

    public void click_Download_button_onTheDownloadJobScreen() {
        click(By.id("download_mf"));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void touchOnTheCreatedInventoryOnDiscovery() {
        waitForElement(2000, By.xpath("//*[contains(@resource-id,'name') and @text='Anton Nakonechnyi']"));
        TouchAction touch = new TouchAction(driver);
        WebElement el = driver.findElement(By.xpath("//*[contains(@resource-id,'name') and @text='Anton Nakonechnyi']"));
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(el)).withDuration(Duration.ofMillis(2000)))
                .release()
                .perform();
    }

    public void clickOnTheAddLabelsField() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Add Labels']"));
    }

    public void typeQuantityOnTheAddField() {
        type(By.id("add_label_no"), "2");
    }

    public void clickOnTheCheckButtonOnTheDiscovery() {
        click(By.id("checkInventory"));
    }

    public void click_CubeSheet_button_onTheInventoriesScreen() {
        waitForElement(80, By.id("editInventory"));
        click(By.id("editInventory"));
    }

    public void clickOnTheAddPieceButton() {
        waitForElement(60,By.id("fab_add"));
        click(By.id("fab_add"));
    }

    public void selectLocationForTheNewPiece() throws InterruptedException {
        waitForElement(60, By.id("roomSpinner"));
        click(By.id("roomSpinner"));
        sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/simpleItemsList\")).scrollIntoView("
                + "new UiSelector().text(\"Bathroom 1\"));").click();

    }

    public void selectPackageForNewPiece() throws InterruptedException {
        click(By.id("pkgSpinner"));
        sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(" + "new UiSelector().text(\"4 Cubes\"));").click();
    }

    public void selectPBOForNewPiece() {
        click(By.id("piece_pbo"));
    }

    public void addItemIntoNewPiece(String text) throws InterruptedException {
        click(By.id("add_item"));
       // click(By.id("search_text"));
        driver.findElement(By.id("search_text")).sendKeys(text);
        //type(By.id("search_text"), "Cabinet");
        sleep(1000);
        click(By.xpath("//*[contains(@resource-id,'item_name')]"));
    }


    public void click_Item_OnPackageScreen_toOpenItemDetailsScreen() {
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.id("item_name")));
        dynamicElement.click();
       // click(By.id("item_name"));
    }

    public void changeConditionOfNewItem() {
        click(By.id("piece_item_condition"));
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet\")).scrollIntoView("
                + "new UiSelector().text(\"Good\"));").click();
    }

    public void changeTypeOfNewItem() {
        click(By.id("item_details_type"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Others']"));
    }


    public void addConditionToTheNewItem() {
        click(By.id("piece_item_condition"));
        if(isPhone){
            click(By.xpath("//*[contains(@resource-id,'text1') and @text='Chipped']"));
        }else
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Paper']"));
    }

    public void addCommentToTheNewItem() {
        click(By.id("detail_comment"));
        type(By.id("detail_comment"), "CommentTEST");
    }

    public void addLocation() {
        click(By.id("add_location_btn"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Center']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void addCondition() {
        click(By.id("add_condition_btn"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Chipped']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void select_Room_withItem_inRoomsGrid_onRoomsScreen() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/roomSummaryList\")).scrollIntoView("
                + "new UiSelector().text(\"1\"));").click();
    }

    public void fillDescriptionField() {
        click(By.id("room_description"));
        type(By.id("room_description"), "DescriptionTEST");
    }

    public void fillConditionField() {
        click(By.id("room_condition"));
        type(By.id("room_condition"), "ConditionTEST");
    }

    public void selectPropertyBeforePacking() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/prop_name\")).scrollIntoView("
                + "new UiSelector().text(\"Floors\"));").click();
    }

    public void clickOnTheSelectConditionButtonOfPropertyBeforePacking() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Fair']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void clickOnPropertyConditionsButtonBeforePacking() {
        click(By.xpath("//*[contains(@resource-id,'show_property') and @text='...']"));
    }

    public void clickOnPropertyConditionsFieldAfterPacking() {
        click(By.xpath("//android.widget.LinearLayout[@content-desc=\"After Packing\"]"));
    }
public void click_AfterPacking_tab_RoomCondition(){
    WebElement element = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"After Packing\"]")));
    click(By.xpath("//android.widget.LinearLayout[@content-desc=\"After Packing\"]"));
}
    public void selectPropertyAfterPacking() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/prop_name\")).scrollIntoView("
                + "new UiSelector().text(\"Floors\"));").click();
    }

    public void clickOnTheSelectConditionButtonOfPropertyAfterPacking() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Loose']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void clickOnPropertyConditionsButtonAfterPacking() {
        click(By.xpath("//*[contains(@resource-id,'show_property') and @text='...']"));
    }

    public void clickOnTheAdditionalListButton() {
        if (isElementPresent(By.xpath("//*[@content-desc='More options']"))) {
            click(By.xpath("//*[@content-desc='More options']"));
        } else
            click(By.xpath("//*[@content-desc='???']"));
    }

    //TODO
    public void click_InventoryList_onNavigateMenu() throws InterruptedException {
      /*  if (isElementPresent(By.id("inventory_summary"))) {
            click(By.id("inventory_summary"));
            sleep(3000);
        } else*/
            //click(By.xpath("//*[@content-desc='???']"));
            click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Inventory List']")); // for Polina's device
    }

    //TODO
    public void click_Appliances_onNavigateMenu() {
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@resource-id,'submenu') and @text='Appliances']")));
        dynamicElement.click();
      //  click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Appliances']")); // for Polina's device
    }

    public void click_Packers_button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Packers']"));
    }

    public void clickOnTheAddSkidButton() {
        click(By.xpath("//*[contains(@resource-id, 'add_skid') and @text='+']"));
    }

    public void clickOnTheSelectSkidDropDown() {
        click(By.id("skidType"));
    }

    public void selectContainer() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Container 40 ft']"));
    }

    public void selectLiftvan() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Liftvan']"));
    }

    public void clickOnTheLoadSkidButton() {
        waitForElement(10, By.xpath("//*[contains(@resource-id,'load_skid') and @text='Load']"));
        click(By.xpath("//*[contains(@resource-id,'load_skid') and @text='Load']"));
    }

    public void click_CartonsSummary_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Cartons Summary']"));
    }

    public void click_AdditionalMaterials_button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Additional Materials']"));
    }

    public void click_Services_button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Services']"));
    }

    public void click_AdditionalInfo__button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Additional Info']"));
    }

    public void click_Documents_button_onNavigateMenu() throws InterruptedException {
        swipeScreenDownMenu();
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Documents']"));
    }

    public void clickOnTheAddDocumentButton() {
        click(By.id("add_doc"));
    }

    public void fillDocumentNameField() {
        click(By.id("document_name"));
        type(By.id("document_name"), "testFile");
    }

    public void returnToTheDiscoveryPage() throws InterruptedException {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        sleep(1000);
    }

    public void clickOnTheReportInventoryButton() throws InterruptedException {
        if (isElementPresent(By.id("reportInventory"))) {
            click(By.id("reportInventory"));
        } else
            click(By.id("fab_share"));
        sleep(5000);
    }


    public void createSignature() throws InterruptedException {
        click(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        sleep(3000);
        new TouchAction(driver)
                .press(PointOption.point(795, 910))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(277, 912))
                .release().perform();
    }

    public void clickOnTheForemanDriverButton() throws InterruptedException {


        if (isElementPresent(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Sign']"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions
                            .elementToBeClickable(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Sign']")));
            dynamicElement.click();
        } else
            click(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Re-Sign']"));
        // sleep(1000);
    }
    public void clickOnTheClientShipperButton() throws InterruptedException {

        if (isElementPresent(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions
                            .elementToBeClickable(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']")));
            dynamicElement.click();
           // click(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Re-Sign']"));
       // sleep(1000);
    }


    public void clickOnTheOKButtonOnThePopUp() {
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@resource-id,'button3') and @text='OK']")));
        dynamicElement.click();

    }

    public void clickOnTheDeviceReturnButton() throws InterruptedException {
        sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    //TODO
    public void attachPhotoConditions() throws InterruptedException {
        click(By.id("add_photo"));

        if (isElementPresent(By.xpath("//*[contains(@resource-id, 'message') and @text='You need to grant access to Camera in order to be able to use the camera., Camera']")))
        {

            click(By.xpath("//*[contains(@resource-id, 'button1') and @text = 'OK']"));
            waitForElement(10,By.xpath("//*[contains(@resource-id, 'permission_allow_one_time_button') and @text='ONLY THIS TIME']"));
            click(By.xpath("//*[contains(@resource-id, 'permission_allow_one_time_button') and @text='ONLY THIS TIME']"));
            sleep(2000);
            click(By.id("add_photo"));
            sleep(2000);
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
            sleep(2000);
        } else
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
        sleep(2000);
    }

    //TODO
    public void attachPhotoToTheNewSkid() throws InterruptedException {
        click(By.id("skid_photo_btn"));

        if (isElementPresent(By.xpath("//*[contains(@resource-id, 'message') and @text='You need to grant access to Camera in order to be able to use the camera., Camera']")))
        {

            click(By.xpath("//*[contains(@resource-id, 'button1') and @text = 'OK']"));
            waitForElement(10,By.xpath("//*[contains(@resource-id, 'permission_allow_one_time_button') and @text='ONLY THIS TIME']"));
            click(By.xpath("//*[contains(@resource-id, 'permission_allow_one_time_button') and @text='ONLY THIS TIME']"));
            sleep(2000);
            click(By.id("skid_photo_btn"));
            sleep(2000);
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
            sleep(2000);
        } else
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
        sleep(2000);

    }

    //TODO
    public void attachPhotoToTheDocumentSection() throws InterruptedException {
        sleep(3000);
        click(By.id("add_photo_btn"));

        if (isElementPresent(By.xpath("//*[contains(@resource-id, 'message') and @text='You need to grant access to Camera in order to be able to use the camera., Camera']")))
        {

            click(By.xpath("//*[contains(@resource-id, 'button1') and @text = 'OK']"));
            waitForElement(10,By.xpath("//*[contains(@resource-id, 'permission_allow_one_time_button') and @text='ONLY THIS TIME']"));
            click(By.xpath("//*[contains(@resource-id, 'permission_allow_one_time_button') and @text='ONLY THIS TIME']"));
            sleep(2000);
            click(By.id("add_photo_btn"));
            sleep(2000);
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
            sleep(2000);
        } else
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
        sleep(2000);
    }

    public void attachPhotoToTheDocumentSectionFromGallery() throws InterruptedException {
        click(By.id("doc_img_gallery_btn"));
        sleep(2000);
        click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));
    }

    public void selectAnItemFromInventory1() {
        if (isElementPresent(By.xpath("//*[contains(@class, 'android.widget.LinearLayout')]"))) {
            click(By.xpath("//*[contains(@class, 'android.widget.LinearLayout')]"));
        } else
            System.out.println("The transaction isn't contain Items");
    }
    public void select_Item_OnInventoryScreen() throws InterruptedException {
        By locator=By.xpath("//*[@resource-id=\"com.voxme.inventory.tablet:id/inventorySummaryList\"]/android.widget.LinearLayout[1]");
        WebElement dynamicElement = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(locator));
        Thread.sleep(2000);
        dynamicElement.click();
        Thread.sleep(3000);

    }

    public void showAttachedPhoto() {
        click(By.xpath("//*[contains(@class,'android.widget.ImageView')]"));
    }

    public void downloadAttachedPhoto() {
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'button1') and @text='YES']"))) {
            click(By.xpath("//*[contains(@resource-id,'button1') and @text='YES']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'cancel')]"));
    }

    public void clickOnTheInfoButton() {
        click(By.xpath("//*[contains(@resource-id,'info')]"));
    }

    public void clickOnTheSchedulesButton() {
        click(By.xpath("//*[contains(@resource-id,'general_schedules') and @text='Schedules']"));
    }

    public void typeNewBarcodeNumber(String text) {
        if (text != null) {
            driver.findElement(By.id("checker_filter_field_id")).click();
            driver.findElement(By.id("checker_filter_field_id")).clear();
            driver.findElement(By.id("checker_filter_field_id")).sendKeys(text);
        }
    }

    public void clickOnTheCheckButton() {
        click(By.id("check_btn"));
    }

    public void goToTheTruckIconToCreateLU() throws InterruptedException {
        swipeScreenToTheLeft();
        swipeScreenToTheLeft();
        sleep(2000);

    }

    public void selectLUFromDropDown() {
        //click(By.xpath("//*[@text='Not Loaded']"));
        if (isElementPresent(By.xpath("//*[@text='Not Loaded']"))) {
            click(By.xpath("//*[@text='Not Loaded']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'skidSpinner') and @text='1 - Container 40 ft']"));

    }

    public void clickOnTheSelectedSkidInTheDropDown() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='1 - Pallet']"));
    }

    public void clickOnTheSelectedSkidInTheDropDownContainer() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='1 - Container 40 ft']"));
    }

    public void clickOnTheSelectedSkidInTheDropDownLiftvan() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='2 - Liftvan']"));
    }

    public void clickOnTheOKLabelButton() {
        click(By.id("ok_label_btn"));
    }

    public void clickOnTheOKLabelButtonSkid() {
        click(By.id("ok_label_btn1"));
    }

    public void swipeScreenDownMenu() throws InterruptedException {
        sleep(3000);
        WebElement panel = driver.findElement(By.id("hamburger_view"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.7;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public void swipeScreenDown() throws InterruptedException {
        sleep(3000);
        WebElement panel = driver.findElement(By.id("decor_content_parent"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.7;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public void swipeSkidScreenUp() throws InterruptedException {
        sleep(3000);
        WebElement panel = driver.findElement(By.id("simpleItemsList"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.2;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.7;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public void swipeScreenUp() throws InterruptedException {
        sleep(3000);
        WebElement panel = driver.findElement(By.id("decor_content_parent"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.2;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.7;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public void swipeScreenToTheLeft() throws InterruptedException {
        WebElement panel = driver.findElement(By.id("pager"));
        Dimension dimension = panel.getSize();

        int anchor = panel.getSize().getHeight() / 2;

        Double ScreenWidthStart = dimension.getWidth() * 0.9;
        int scrollStart = ScreenWidthStart.intValue();

        Double ScreenWidthEnd = dimension.getWidth() * 0.1;
        int scrollEnd = ScreenWidthEnd.intValue();

        new TouchAction(driver)
                .press(point(scrollStart, anchor))
                .waitAction(waitOptions(ofSeconds(1)))
                .moveTo(point(scrollEnd, anchor))
                .release().perform();

        sleep(3000);
    }

    public void swipeScreenToTheRight() throws InterruptedException {
        WebElement panel = driver.findElement(By.id("pager"));
        Dimension dimension = panel.getSize();

        int anchor = panel.getSize().getHeight() / 2;

        Double ScreenWidthStart = dimension.getWidth() * 0.1;
        int scrollStart = ScreenWidthStart.intValue();

        Double ScreenWidthEnd = dimension.getWidth() * 0.9;
        int scrollEnd = ScreenWidthEnd.intValue();

        new TouchAction(driver)
                .press(point(scrollStart, anchor))
                .waitAction(waitOptions(ofSeconds(1)))
                .moveTo(point(scrollEnd, anchor))
                .release().perform();

        sleep(3000);
    }

    public void clickToAddSkidButton() {
        click(By.id("fab_skid_add"));
    }

    public void clickToTheSkidContentButton() {
        click(By.id("skid_contents_button"));
    }

    public void clickToTheLoadSkidButton() {
        click(By.id("load_skid"));
    }

    public void clickToTheSkidOKButton() {
        click(By.id("skid_ok_button"));
    }

    public void click_InspectionInfo_button() {
        click(By.xpath("//*[contains(@resource-id,'inspection_info') and @text='Inspection Info']"));
    }

    public void click_NavigateMenu_button() {
        /*WebElement element = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));*/
        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")));
        element.click();

        /*waitForElement(1, (By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));

        click(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));*/

    }

    public void click_GeneralInfo_button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='General Info']"));;
    }

    public void clickOnTheSummaries() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Summaries']"));
    }


    public void click_AdditionalServices_button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Additional Services']"));
    }

    public void click_BackToJobList_button_onNavigateMenu() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Back to Job List']"));
    }

    public void clickToTheSignAndSendButton() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Sign And Send']"));
    }

    public void addDictionaryFile() throws IOException {
        driver.pushFile(
                "//This PC/Xperia Z3 Tablet Compact/Internal storage/Android/data/com.voxme.inventory.tablet/files/Dictionary.xml",
                new File("C:/Tools/Dictionary.xml"));
    }

    public void addConfigurationFile() throws IOException {
        driver.pushFile(
                "//This PC/Xperia Z3 Tablet Compact/Internal storage/Android/data/com.voxme.inventory.tablet/files/Configuration.xml",
                new File("C:/Tools/Configuration.xml"));
    }

    public void openServiceList() {
        click(By.xpath("//*[contains(@resource-id,'group_name') and @text='Group3']"));
    }

    public void addServiceText() {
        click(By.xpath("//*[contains(@resource-id,'item_value') and @text='Tap to edit']"));
        type(By.id("value_edit"), "ContextTEST");
    }

    public void addValueFromList() {
        click(By.xpath("//*[contains(@resource-id,'item_value') and @text='Tap to select value']"));
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'text1') and @text='service1']"))) {
            click(By.xpath("//*[contains(@resource-id,'text1') and @text='service1']"));

        } else
            click(By.xpath("//*[contains(@resource-id,'text1') and @text='service1']"));
    }
   public void addValueFromList2() {
       click(By.xpath("//*[contains(@resource-id,'item_value') and @text='Tap to select value']"));
       if (isElementPresent(By.xpath("//*[contains(@resource-id,'text1') and @text='val_1']"))) {
           click(By.xpath("//*[contains(@resource-id,'text1') and @text='val_1']"));

       } else
            click(By.xpath("//*[contains(@resource-id,'text1') and @text = 'val_1']"));
    }

    public void attachSignature() throws InterruptedException {
        click(By.id("signature_view"));
        sleep(3000);
        new TouchAction(driver)
                .press(PointOption.point(795, 901))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(277, 912))
                .release().perform();
    }

    public void attachPhotoFromCameraToService() throws InterruptedException {
        click(By.id("photo_thumbnail"));
        if (isElementPresent(By.xpath("//*[contains(@resource-id, 'alertTitle') and @text='Select an action']"))) {
            click(By.xpath("//*[contains(@resource-id, 'text1') and @text='Take Photo']"));
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
            sleep(2000);
        } else
            click(By.xpath("//*[contains(@resource-id,'shutter_button') and @index=0]"));
        sleep(3000);

    }

    public void openFirstPropertiesList() {
        click(By.xpath("//*[contains(@resource-id,'group_name') and @text='Group1']"));

    }

    public void addQuestionText() {
        click(By.xpath("//*[contains(@resource-id,'item_value') and @text='Tap to edit']"));
        type(By.id("value_edit"), "QuestionTEST");

    }

    public void clickOnTheOKButton() {
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void openSecondPropertiesList() {
        click(By.xpath("//*[contains(@resource-id,'group_name') and @text='name_1']"));
    }

    public void selectAnAction() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='New Inventory']"));
    }

    public void clickOnTheSettingsButton() {
        if (isElementPresent(By.id("settings"))) {
            click(By.id("settings"));
        } else
            click(By.xpath("//*[contains@resource-id,'settings']"));
    }

    public void clickOnTheSettings() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Settings']"));
    }

    public void clickOnTheVoxmeCloud() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Voxme Cloud']"));
    }

    public void clickOnTheServerURL() {
        click(By.id("settings_server_url"));
    }

    public void typeCoreURL() {
        type(By.id("settings_url_address"), "mfc-core-staging.voxme.com");
    }

    public void typeProdURL() {
        type(By.id("settings_url_address"), "mfc.voxme.com");
    }

    public void typeDevURL() {
        type(By.id("settings_url_address"), "mfcdev.voxme.com");
    }

    public void selectProtocol() {
        click(By.id("settings_https"));
    }

    public void typeApplication() {
        type(By.id("settings_url_application"), "MobileExchange");
    }

    public void typeUserName(String testUser) {
        type(By.id("cloud_username"), testUser);
    }

    public void typePassword(String testPassword) {
        type(By.id("cloud_password"), testPassword);
    }

    public void clickOnConfigurations() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Configuration']"));
    }

    public void clickOnTheDownloadConfigurationButton() throws InterruptedException {
        click(By.xpath("//*[contains(@resource-id,'get_configuration') and @text='Download Configuration']"));
        sleep(5000);
    }

    public void clickOnTheYesButton() throws InterruptedException {
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='Yes']"));
        sleep(45000);
    }

    public void clickOnTheUserRegistration() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='User Registration']"));
    }

    public void typeCompanyID(String companyId) {
        type(By.id("company_id"), companyId);
    }

    public void typeCompanyName(String companyName) {
        type(By.id("company_name"), companyName);
    }

    public void typeCompanyWebsite(String webSite) {
        type(By.id("company_website"), webSite);
    }

    public void typeCompanyTel(String tel) {
        type(By.id("company_phone"), tel);
    }

    public void typeInventoryReturnEmail(String email) {
        type(By.id("settings_server_address"), email);
    }

    public void clickOnTheLanguageDropdown() {
        if (isElementPresent(By.id("language"))) {
            click(By.id("language"));
        } else
            click(By.xpath("//*[contains@resource-id,'language']"));
    }

    public void selectLanguage() throws InterruptedException {
        sleep(3000);
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='English']"));
    }

    public void selectUnits() {
        click(By.xpath("//*[contains(@resource-id,'metric') and @text='Meters']"));
    }

    public void clickOnTheActivateServiceButton() {
        click(By.xpath("//*[contains(@resource-id,'request_license') and @text='Register']"));
    }

    public void typeRegistrationUserName(String userName) {
        type(By.id("settings_user_name"), userName);
    }

    public void clickOnRegisterButton() {
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
        dynamicElement.click();
       // click(By.xpath("//*[@resource-id='android:id/button1']"));
    }

    public void clickOnDontHaveASettinsCode() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @index=2]"));

    }

    public void clickOnCheckregistrationButton() {
        click(By.xpath("//*[contains(@resource-id, 'get_license') and @text='Check Registration']"));
    }

    public void clickGrantAccessLocationOKbutton() {
        click(By.xpath("//*[contains(@resource-id, 'button1') and @text='OK']"));
    }

    public void ChoosePermitionLocation() {
        click(By.xpath("//*[contains(@resource-id, 'permission_allow_foreground_only_button') and @index=0]"));
    }

    public void clickOnSettingsStupPic() {
        click(By.xpath("//*[@resource-id='com.voxme.inventory.tablet:id/settings']"));
    }

    public void clickOnSettingsPopup() {
        click(By.xpath("//*[contains(@resource-id, 'text1') and @text='Settings']"));
    }

    public void downloadSettings() {
        click(By.xpath("//*[contains(@resource-id, 'get_settings') and @index=3]"));
    }

    public void downloadConfigurations() {
        click(By.xpath("//*[contains(@resource-id, 'get_configuration') and @index=0]"));
    }

    public void closeTheWarningPopup() {
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@resource-id, 'button1') and @text='YES']")));
        dynamicElement.click();

        //click(By.xpath("//*[contains(@resource-id, 'button1') and @text='YES']"));
    }

    public void click_SelectPacker_Button() {
        click(By.xpath("//*[contains(@resource-id,'configPackerList') and @index=1]"));
    }

    public void select_Packer_FromPackerGrid() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='John R']"));
    }

    public void click_IsForeman_checkBox() {
        click(By.xpath("//*[contains(@class,'android.widget.CheckBox') and @checked='false']"));
    }

    public void clickOnSummaryButton() {
        click(By.xpath("//*[contains(@resource-id, 'review_summary') and @index=0]"));
    }

    public void clickToAttachSignatureButton() {
        click(By.xpath("//*[contains(@resource-id,'takePhotoBtn') and @class='android.widget.ImageButton']"));
    }

    public void takeAPhotoForSignature() {
        click(By.xpath("//*[contains(@resource-id,'shutter_button') and @class='android.view.View']"));
    }

    public void clickOkCamera() {
        click(By.xpath("//*[contains(@class,'android.widget.FrameLayout') and @index=2]"));
    }

    public void addItemIntoNewPiece2(String text) throws InterruptedException {
        click(By.id("add_item"));
        // click(By.id("search_text"));
        driver.findElement(By.id("search_text")).sendKeys(text);
        //type(By.id("search_text"), "Cabinet");
        click(By.xpath("//*[contains(@resource-id,'item_name')]"));
        sleep(1000);
        click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
    }

    public void clickOnBackButton()
    {
        click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
    }
   public void checkingVoxmeCloudForDev() throws InterruptedException {
       click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
       click(By.xpath("//*[@resource-id='com.voxme.inventory.tablet:id/settings']"));
       click(By.xpath("//*[contains(@resource-id,'text1') and @text='Configuration']"));
       click(By.xpath("//*[contains(@resource-id, 'config_buttons_selector') and @index=1]"));
       click(By.xpath("//*[contains(@resource-id, 'text1') and @index=1]"));
       hideKeyboard();
       sleep(1000);
       click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
       sleep(1000);
       click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));

   }

   public void isPhtotDownload() throws InterruptedException {
       click(By.xpath("//*[contains(@class,'android.widget.ImageView')]"));
       if (isElementPresent(By.id("alertTitle"))) {
           click(By.xpath("//*[contains(@resource-id, 'button1') and @text='YES']"));
           sleep(3000);
           click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
           sleep(2000);
           click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
           sleep(2000);
           click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
       } else
           //click(By.xpath("//*[@content-desc='???']"));
           click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
       sleep(1000);
           click(By.xpath("//*[contains(@class, 'ImageButton') and @index=0]"));
       // for Polina's device

   }
   public void createSingnature2() throws InterruptedException {
       WebElement element = driver.findElement(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
       Point location = element.getLocation();
       int X  = location.getX();
       int Y= location.getY();
       System.out.println("X :"+X);
       System.out.println("Y :"+Y);

       //click(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
       //sleep(3000);
       new TouchAction(driver)
               .press(PointOption.point(X+Y, Y+X))
               .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
               .moveTo(PointOption.point(X*3, Y*3))
               .release().perform();
   }

    public void drawVInFrame() {
        /*WebElement frame = driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout']"));
        driver.switchTo().frame(frame);*/
        WebElement frame = driver.findElement(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        int anchor2 = frame.getSize().getHeight() / 2;
        int anchor1 = frame.getSize().getWidth() / 2;

        WebElement canvas = driver.findElement(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        Point location = canvas.getLocation();
        int X  = location.getX();
        int Y= location.getY();
        System.out.println("X :"+X);
        System.out.println("Y :"+Y);
        System.out.println("anchor1 :"+anchor1);
        System.out.println("anchor2 :"+anchor2);
        Actions builder = new Actions(driver);
        builder.moveToElement(canvas, anchor1, anchor2).clickAndHold().moveByOffset(anchor2*-2, anchor2*-3).release().perform();
    }

    public void drawSign(){
        WebElement element=driver.findElement(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        Point p = element.getLocation();
        Dimension d = element.getSize();
        int fx = p.x + d.width/2;
        int fy=p.y+d.height/2;
       // new TouchActions(driver).down(fx, fy).perform();
      //  new Actions(driver).moveToElement(element,d.height,d.width).clickAndHold().moveByOffset(fx,fy).release().perform();
        new TouchAction(driver)
                .press(PointOption.point(fx, fy))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(d.height, d.width))
                .release().perform();

    }
   /* public void drawCirleInFrame(){
        SurfaceView surfaceView = findViewById(R.id.signature_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        drawCircle(canvas);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }*/
  /* public void drawCircle(Canvas canvas) {
       Paint paint = new Paint();
       paint.setColor(Color.BLACK);
       paint.setStyle(Paint.Style.STROKE);
       paint.setStrokeWidth(5);
       int x = canvas.getWidth() / 2;
       int y = canvas.getHeight() / 2;
       int radius = Math.min(x, y) - 10;
       canvas.drawCircle(x, y, radius, paint);
   }*/

    public void createSingnatureforAditionalService() throws InterruptedException {
        click(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        Point location = element.getLocation();
        int X  = location.getX();
        int Y= location.getY();
        int newX=X+100;
        int newY=Y-100;

        click(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
        sleep(3000);
        new TouchAction(driver)
                .press(PointOption.point(X, Y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(newX, newY))
                .release().perform();
    }
   public void closeTheScanLoosePiecesPopup()
   {
       if (isElementPresent(By.xpath("//*[contains(@resource-id, 'message') and @text='Scan loose pieces?']")))
       {
           click(By.xpath("//*[contains(@resource-id, 'button2') and @text='NO']"));
           click(By.xpath("//*[contains(@resource-id, 'stop_checking_btn') and @text='Stop']"));
       }
       else
           click(By.xpath("//*[contains(@resource-id, 'stop_checking_btn') and @text='Stop']"));

    }
    public void clickOnOKCheckrButton()
    {
        click(By.id("ok_label_btn"));
    }
    public void clickOnStopButtonInChecker()
    { if(isElementPresent(By.xpath("//*[contains(@resource-id, 'stop_checking_btn') and @text='Stop']")))
        {click(By.xpath("//*[contains(@resource-id, 'stop_checking_btn') and @text='Stop']"));}
        else
        click(By.xpath("//*[contains(@class, 'android.widget.ImageButton') and @index=0]"));

    }
    public void closePopupIfPresent()
    {
        if (isElementPresent(By.xpath("//*[contains(@resource-id, 'alertTitle') and @text= 'Checker']")))
        {
            click(By.xpath("//*[contains(@resource-id, 'button3') and @text='OK']"));
            click(By.xpath("//*[contains(@class, 'android.widget.ImageButton') and @index=0]"));

        }
        else
            click(By.xpath("//*[contains(@resource-id, 'stop_checking_btn') and @text='Stop']"));
            click(By.xpath("//*[contains(@class, 'android.widget.ImageButton') and @index=0]"));
    }
    public void clickOnSingandSendbutton()
    {
        click(By.xpath("//*[contains(@class, 'LinearLayout') and @index = 5]"));
    }
    public void addItemIntoNewPiece3(String text) throws InterruptedException {
        click(By.id("add_item"));
        // click(By.id("search_text"));
        driver.findElement(By.id("search_text")).sendKeys(text);
        //type(By.id("search_text"), "Cabinet");
        click(By.xpath("//*[contains(@resource-id,'item_name')]"));
        sleep(1000);

    }

    public void swipe_Down_onTheGeneralInfoScreen() throws InterruptedException {
        swipeScreenDown();
        swipeScreenDown();
    }

    public void swipe_To_OriginDetailsScreen() throws InterruptedException {
        swipeScreenToTheLeft();
    }

    public void swipe_Down_onTheOriginDetailsScreen() throws InterruptedException {
        swipeScreenDown();
        swipeScreenDown();
    }

    public void swipe_To_DestinationDetailsScreen() throws InterruptedException {
        swipeScreenToTheLeft();
    }

    public void swipe_Down_onTheDestinationDetailsScreen() throws InterruptedException {
        swipeScreenDown();
        swipeScreenDown();
    }

    public void swipe_To_RoomsScreen() throws InterruptedException {
        swipeScreenToTheLeft();
    }

    public void click_Summaries_button_onNavigateMenu() throws InterruptedException {
        swipeScreenDownMenu();
        clickOnTheSummaries();
    }

    public void click_iConPhoto() {
        WebElement element = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions
                        .elementToBeClickable(By
                                        .id("com.voxme.inventory.tablet:id/imageGallery")));
        element.click();

        }
public void downloadPhoto(){
        if(isElementPresent(By.xpath("//*[@resource-id=\"com.voxme.inventory.tablet:id/parentPanel\"]"))){
            WebElement element = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions
                            .elementToBeClickable(By
                                    .xpath("//*[@resource-id=\"com.voxme.inventory.tablet:id/buttonPanel\"]//*[@resource-id=\"android:id/button1\"]")));

            element.click();
            click_iConPhoto();
        }

}


    public void download_AttachedPhoto() {
        downloadPhoto();

        }

    public void click_Ok_button_onTheAllert() {
        click(By.id("android:id/button3"));
    }

    public void attachPhotoFromCamera_SkidDetails() {
        click_iConCamera1(By.id("com.voxme.inventory.tablet:id/skid_photo_btn"));
        if (isElementPresent(By.id("android:id/message"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
            dynamicElement.click();
            if (isElementPresent(By.id("com.android.permissioncontroller:id/permission_icon"))) {
                WebElement dynamicElement1 = (new WebDriverWait(driver, 100))
                        .until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
                dynamicElement1.click();
                click_iConCamera1(By.id("com.voxme.inventory.tablet:id/skid_photo_btn"));

            }

        }
        click_takePhoto_onCamera();
        savePhoto_afterTakePhoto_byCamera();


    }

    public void attachPhotoFromCamers_DocumentSection() {
        click_iConCamera1(By.id("com.voxme.inventory.tablet:id/add_photo_btn"));
        if (isElementPresent(By.id("android:id/message"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
            dynamicElement.click();
            if (isElementPresent(By.id("com.android.permissioncontroller:id/permission_icon"))) {
                WebElement dynamicElement1 = (new WebDriverWait(driver, 100))
                        .until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
                dynamicElement1.click();
                click_iConCamera1(By.id("com.voxme.inventory.tablet:id/add_photo_btn"));

            }

        }
        click_takePhoto_onCamera();
        savePhoto_afterTakePhoto_byCamera();
    }

    public void type_materialsQuantity_onAdditionalMaterialsScreen(String s) {
        By locator=By.xpath("//*[@class=\"android.widget.LinearLayout\"]/*[@resource-id=\"com.voxme.inventory.tablet:id/item_name\" and @text=\"Small carton\"]//following-sibling::android.widget.EditText");
        WebElement dynamicElement = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.elementToBeClickable(locator));
        type(locator,"20");


    }

    public void click_GroupName_Service(String s) {
        By locator=By.xpath("//*[@class=\"android.widget.TableLayout\"]//*[@resource-id=\"com.voxme.inventory.tablet:id/group_name\" and @text=\"Group3\"]");
        WebElement dynamicElement = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.elementToBeClickable(locator));
        dynamicElement.click();

    }

    public void attachPhotoFromCamera_Service() {
        click_iConCamera1(By.id("com.voxme.inventory.tablet:id/photo_thumbnail_btn"));
        WebElement el = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@resource-id=\"android:id/text1\" and @text=\"Take Photo\"]")));
        el.click();
        if (isElementPresent(By.id("android:id/message"))) {
            WebElement dynamicElement = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
            dynamicElement.click();
            if (isElementPresent(By.id("com.android.permissioncontroller:id/permission_icon"))) {
                WebElement dynamicElement1 = (new WebDriverWait(driver, 100))
                        .until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
                dynamicElement1.click();
                click_iConCamera1(By.id("com.voxme.inventory.tablet:id/photo_thumbnail_btn"));

            }

        }
        click_takePhoto_onCamera();
        savePhoto_afterTakePhoto_byCamera();

    }
}

