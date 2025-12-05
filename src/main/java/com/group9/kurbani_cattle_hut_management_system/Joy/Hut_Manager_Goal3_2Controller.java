package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Owner;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.FilesUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class Hut_Manager_Goal3_2Controller
{
    @javafx.fxml.FXML
    private TextField ownerPhone;
    @javafx.fxml.FXML
    private TextField ownerNameTF;
    @javafx.fxml.FXML
    private TextField ownerIdTF;
    @javafx.fxml.FXML
    private TextField ownerNidTF;
    @javafx.fxml.FXML
    private TextField ownerAddressTF;

    private final ArrayList<Owner> ownerEditList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBackToGoal3OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3.fxml");
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        String ownerID = ownerIdTF.getText();
        String ownerName = ownerNameTF.getText();
        String ownerNID = ownerNidTF.getText();
        String ownerPhoneNumber = ownerPhone.getText();
        String ownerAddress = ownerAddressTF.getText();

        if(ownerID.isEmpty() || ownerName.isEmpty() || ownerNID.isEmpty() || ownerPhoneNumber.isEmpty() || ownerAddress.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        Owner owner = new Owner(ownerID, ownerName, ownerNID, ownerAddress, ownerPhoneNumber);
        ownerEditList.add(owner);
        AlertUtil.showInfo("Success", "Owner information saved successfully!");

        FilesUtil.saveObject("owners_edit.bin", owner);

    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }
}