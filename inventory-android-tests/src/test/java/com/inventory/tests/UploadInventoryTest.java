package com.inventory.tests;

import org.testng.annotations.Test;

public class UploadInventoryTest extends TestBase {
 String nameOfPiece = "Cabinet";
 String inventory = "10949-8-4";
    @Test
    public void uploadInventoryFromMFC() throws InterruptedException {
        app.click_DownloadInventory_button();
        app.type_value_inDiscoveryField(inventory);
        app.select_FoundedTransaction_inTheDownloadJobGrid();
        app.click_Download_button_onTheDownloadJobScreen();
        app.click_CubeSheet_button_onTheInventoriesScreen();
        Thread.sleep(4000);
        app.clickOnTheAddPieceButton();
        app.selectLocationForTheNewPiece();
        app.selectPackageForNewPiece();
        app.selectPBOForNewPiece();
        app.swipeScreenDown();
        app.addItemIntoNewPiece(nameOfPiece);
        app.click_Item_OnPackageScreen_toOpenItemDetailsScreen();
        app.changeTypeOfNewItem();
        app.addConditionToTheNewItem();
        app.hideKeyboard();
        app.addCommentToTheNewItem();
        app.hideKeyboard();
        app.attachPhotoFromGallery();
        app.attachPhotoFromCamera();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.swipeScreenToTheLeft();
        app.select_Room_withItem_inRoomsGrid_onRoomsScreen();
        app.click_InspectionInfo_button();
        app.fillDescriptionField();
        app.hideKeyboard();
        app.fillConditionField();
        app.hideKeyboard();
        app.attachPhotoFromGallery();
        app.attachPhotoFromCamera_RoomCondition();
        app.clickOnPropertyConditionsFieldAfterPacking();
        app.attachPhotoFromGallery();
        app.attachPhotoFromCamera_RoomCondition();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.swipeScreenToTheLeft();
        app.clickToAddSkidButton();
        app.attachPhotoFromGallery();
        app.attachPhotoFromCamera_SkidDetails();
        app.clickToTheSkidContentButton();
        app.clickToTheLoadSkidButton();
        app.clickToTheReturnUpButton();
        app.clickToTheSkidOKButton();
        app.click_NavigateMenu_button();
        app.swipeScreenDownMenu();
        app.clickOnTheSummaries();
        app.click_Packers_button_onNavigateMenu();
        app.click_SelectPacker_Button();
        app.select_Packer_FromPackerGrid();
        app.click_IsForeman_checkBox();
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.click_CartonsSummary_onNavigateMenu();
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.click_Appliances_onNavigateMenu();
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.swipeScreenDownMenu();
        app.click_AdditionalServices_button_onNavigateMenu();
        app.click_AdditionalMaterials_button_onNavigateMenu();
        app.type_materialsQuantity_onAdditionalMaterialsScreen("Small carton");
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.click_Services_button_onNavigateMenu();
        app.click_GroupName_Service("Group3");
        app.attachPhotoFromCamera_Service();
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.click_AdditionalInfo__button_onNavigateMenu();
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.swipeScreenDownMenu();
        app.click_Documents_button_onNavigateMenu();
        app.clickOnTheAddDocumentButton();
        app.fillDocumentNameField();
        app.hideKeyboard();
        app.attachPhotoToTheDocumentSectionFromGallery();
        app.clickOnTheAddDocumentButton();
        app.fillDocumentNameField();
        app.hideKeyboard();
        app.attachPhotoFromCamers_DocumentSection();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.click_NavigateMenu_button();
        app.clickToTheSignAndSendButton();
        app.clickOnTheClientShipperButton();
        app.drawSign();
        app.clickToTheReturnUpButton();
        app.clickOnTheForemanDriverButton();
        app.drawSign();
        app.clickToTheReturnUpButton();
        app.swipeScreenUp();
        app.clickOnSummaryButton();
        app.swipeScreenDown();
        app.clickToTheReturnUpButton();
        app.clickOnTheUploadButton();
        app.clickOnTheOKButtonOnThePopUp();
        app.screenshot();
        app.clickToTheReturnUpButton();




    }
}
