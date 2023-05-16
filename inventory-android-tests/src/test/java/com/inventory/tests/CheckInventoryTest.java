package com.inventory.tests;

import org.testng.annotations.Test;

public class CheckInventoryTest extends TestBase {

public String inventoryRef = "10941-1-1";
public String nameOfPiece = "Cabinet";
public String nameOfPiece2 = "Artificial";


    @Test
        public void checkingAndScanningInProcess() throws InterruptedException {
            app.click_DownloadInventory_button();
            app.type_value_inDiscoveryField(inventoryRef);
            app.select_FoundedTransaction_inTheDownloadJobGrid();
            app.click_Download_button_onTheDownloadJobScreen();
            app.click_CubeSheet_button_onTheInventoriesScreen();
            Thread.sleep(2000);
            app.clickOnTheAddPieceButton();
            app.selectLocationForTheNewPiece();
            app.swipeScreenDown();
            app.addItemIntoNewPiece(nameOfPiece);
            app.clickToTheReturnUpButton();
            app.clickOnTheAddPieceButton();
            app.selectLocationForTheNewPiece();
            app.swipeScreenDown();
            app.addItemIntoNewPiece2(nameOfPiece2);
            app.swipeScreenToTheRight();
            app.click_NavigateMenu_button();
            app.click_BackToJobList_button_onNavigateMenu();
            app.clickOnTheCheckButtonOnTheDiscovery();
            app.closeTheScanLoosePiecesPopup();
            app.clickToTheReturnUpButton();
            Thread.sleep(2000);
            app.click_CubeSheet_button_onTheInventoriesScreen();
            app.goToTheTruckIconToCreateLU();
            app.clickToAddSkidButton();
            app.clickOnTheSelectSkidDropDown();
            app.swipeSkidScreenUp();
            app.selectContainer();
            app.clickToTheSkidOKButton();
            app.clickToAddSkidButton();
            app.clickOnTheSelectSkidDropDown();
            app.selectLiftvan();
            app.clickToTheSkidOKButton();
            app.clickOnTheDeviceReturnButton();
            app.clickOnTheCheckButtonOnTheDiscovery();
            app.typeNewBarcodeNumber("1");
            app.hideKeyboard();
            app.clickOnTheCheckButton();
            app.selectLUFromDropDown();
            app.clickOnTheSelectedSkidInTheDropDownContainer();
            app.clickOnTheOKLabelButtonSkid();
            app.typeNewBarcodeNumber("2");
            app.hideKeyboard();
            app.clickOnTheCheckButton();
            app.selectLUFromDropDown();
            app.clickOnTheSelectedSkidInTheDropDownLiftvan();
            app.clickOnTheOKLabelButtonSkid();
            app.closePopupIfPresent();
            app.clickOnTheReportInventoryButton();
            app.swipeScreenDown();
            app.clickOnTheClientShipperButton();
            app.createSingnature2();
            app.clickToTheReturnUpButton();
            app.clickOnTheForemanDriverButton();
            app.createSingnature2();
            app.clickToTheReturnUpButton();
            app.swipeScreenUp();
            app.clickOnTheUploadButton();
            app.clickOnTheOKButtonOnThePopUp();
            app.screenshot();
            app.clickToTheReturnUpButton();

    }
}
