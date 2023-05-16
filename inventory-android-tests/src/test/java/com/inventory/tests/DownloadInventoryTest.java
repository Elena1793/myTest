package com.inventory.tests;

import org.testng.annotations.Test;

public class DownloadInventoryTest extends TestBase {
  String inventoryRef = "10949-8-6";
  
    @Test
    public void downloadInventoryFromMFC() throws InterruptedException {
      app.click_DownloadInventory_button();
      app.type_value_inDiscoveryField(inventoryRef);
      app.select_FoundedTransaction_inTheDownloadJobGrid();
      app.click_Download_button_onTheDownloadJobScreen();
      app.click_CubeSheet_button_onTheInventoriesScreen();
      app.select_Item_OnInventoryScreen();
      app.click_Item_OnPackageScreen_toOpenItemDetailsScreen();
      app.click_iConPhoto();
      app.download_AttachedPhoto();
      app.click_Return_button_FromViewPhoto();
      app.click_Return_button_FromLabelDetails();
      app.click_Return_button_FromPackageDetails();
      app.click_NavigateMenu_button();
      app.click_GeneralInfo_button_onNavigateMenu();
      app.swipe_Down_onTheGeneralInfoScreen();
      app.swipe_To_OriginDetailsScreen();
      app.swipe_Down_onTheOriginDetailsScreen();
      app.swipe_To_DestinationDetailsScreen();
      app.swipe_Down_onTheDestinationDetailsScreen();
      app.click_NavigateMenu_button();
      app.click_InventoryList_onNavigateMenu();
      app.swipe_To_RoomsScreen();
      app.select_Room_withItem_inRoomsGrid_onRoomsScreen();
      app.click_InspectionInfo_button();
      app.click_iConPhoto();
      app.download_AttachedPhoto();
      app.click_Return_button_FromViewPhoto();
      app.click_AfterPacking_tab_RoomCondition();
      app.click_iConPhoto();
      app.download_AttachedPhoto();
      app.click_Return_button_FromViewPhoto();
      app.click_Return_button_FromInspectionCondition();
      app.click_Return_button_FromRoomDetails();
      app.click_NavigateMenu_button();
      app.click_Summaries_button_onNavigateMenu();
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
      app.click_AdditionalServices_button_onNavigateMenu();
      app.click_AdditionalMaterials_button_onNavigateMenu();
      app.clickToTheReturnUpButton();
      app.click_NavigateMenu_button();
      app.click_Services_button_onNavigateMenu();
      app.clickToTheReturnUpButton();
      app.click_NavigateMenu_button();
      app.click_AdditionalInfo__button_onNavigateMenu();
      app.clickToTheReturnUpButton();
      app.click_NavigateMenu_button();
      app.click_Documents_button_onNavigateMenu();
      app.clickToTheReturnUpButton();
      app.click_NavigateMenu_button();
      app.click_BackToJobList_button_onNavigateMenu();

    }
}
