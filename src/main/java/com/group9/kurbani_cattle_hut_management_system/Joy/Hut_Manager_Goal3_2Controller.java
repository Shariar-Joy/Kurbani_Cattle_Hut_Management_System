package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Owner;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

        File file = new File("data/owners_edit.bin");
        try {
            FileOutputStream fos = new FileOutputStream(file); // NO appending
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ownerEditList);  // Save entire list
            oos.close();
            AlertUtil.showInfo("Success", "Saved to file");
        } catch (IOException e) {
            AlertUtil.showError("Error", "File error: " + e.getMessage());
        }

    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }
}