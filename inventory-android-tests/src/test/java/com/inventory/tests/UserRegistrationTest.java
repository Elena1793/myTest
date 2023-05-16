package com.inventory.tests;

import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {

   public String companyId = "mfctestinv";
   public String companyName = "voxme";
   public String companyWebsite = "www.voxme.com";
   public String companyTel = "01432272274";
   public String userName = "alisa";
   public String companyEmail = "support@voxme.com";

    @Test
        public void newUserRegistration() throws InterruptedException {
           app.clickOnRegisterButton();
           app.clickOnDontHaveASettinsCode();
           app.typeCompanyID(companyId);
           app.typeCompanyName(companyName);
           app.typeCompanyWebsite(companyWebsite);
           app.typeCompanyTel(companyTel);
           app.typeRegistrationUserName(userName);
           app.typeInventoryReturnEmail(companyEmail);
           app.hideKeyboard();
           app.clickOnTheLanguageDropdown();
           app.selectLanguage();
           app.selectUnits();
           app.swipeScreenDown();
           app.clickOnTheActivateServiceButton();
           app.clickOnTheOKButtonOnThePopUp();
           app.clickOnCheckregistrationButton();
           app.clickOnTheOKButtonOnThePopUp();
           app.clickOnTheDeviceReturnButton();
           app.clickGrantAccessLocationOKbutton();
           app.ChoosePermitionLocation();

       app.clickOnSettingsStupPic();
       app.clickOnSettingsPopup();
       if(app.isPhone==false){
          app.click_Ok_button_onTheAllert();
       }
       app.clickOnConfigurations();
       app.downloadSettings();
       app.clickOnTheOKButtonOnThePopUp();
       if(app.isPhone) {
          app.clickToTheReturnUpButton();
       }
       app.clickOnTheVoxmeCloud();
       if(app.isPhone) {
          app.clickToTheReturnUpButton();
       }
       app.clickOnConfigurations();
       app.downloadConfigurations();
       app.closeTheWarningPopup();
       app.clickOnTheOKButtonOnThePopUp();
       if(app.isPhone){
          app.clickToTheReturnUpButton();
       }
       app.clickOnTheVoxmeCloud();
       app.clickToTheReturnUpButton();
       Thread.sleep(1000);
       if(app.isPhone){
          app.checkingVoxmeCloudForDev();
       }

    }

}
