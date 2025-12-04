package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Utils.AlertUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Doctor_Goal8Controller
{
    @javafx.fxml.FXML
    private CheckBox tuesdayCB;
    @javafx.fxml.FXML
    private CheckBox wednesdayCB;
    @javafx.fxml.FXML
    private CheckBox afternoonCB;
    @javafx.fxml.FXML
    private CheckBox eveningCB;
    @javafx.fxml.FXML
    private CheckBox mondayCB;
    @javafx.fxml.FXML
    private CheckBox thursdayCB;
    @javafx.fxml.FXML
    private CheckBox sundayCB;
    @javafx.fxml.FXML
    private CheckBox morningCB;
    @javafx.fxml.FXML
    private TextArea textfield1;
    @javafx.fxml.FXML
    private TextArea textfield2;
    @javafx.fxml.FXML
    private TextArea textfield3;
    @javafx.fxml.FXML
    private TextArea textfield4;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        String sunday = sundayCB.isSelected() ? "Yes" : "No";
        String monday = mondayCB.isSelected() ? "Yes" : "No";
        String tuesday = tuesdayCB.isSelected() ? "Yes" : "No";
        String wednesday = wednesdayCB.isSelected() ? "Yes" : "No";
        String thursday = thursdayCB.isSelected() ? "Yes" : "No";
        String morning = morningCB.isSelected() ? "Yes" : "No";
        String afternoon = afternoonCB.isSelected() ? "Yes" : "No";
        String evening = eveningCB.isSelected() ? "Yes" : "No";

        if(!sunday.equals("No") || !monday.equals("No") || !tuesday.equals("No") || !wednesday.equals("No") || !thursday.equals("No")) {
            if(!morning.equals("No") || !afternoon.equals("No") || !evening.equals("No")) {
                AlertUtil.showInfo("Success", "Availability saved successfully.");
                AlertUtil.showInfo("Day","Days - Sunday: " + sunday + ", Monday: " + monday + ", Tuesday: " + tuesday + ", Wednesday: " + wednesday + ", Thursday: " + thursday);
                AlertUtil.showInfo("Time","Time Slots - Morning: " + morning + ", Afternoon: " + afternoon + ", Evening: " + evening);
            } else {
                AlertUtil.showError("Error","Please select at least one time slot.");
            }
        } else {
            AlertUtil.showError("Error","Please select at least one day.");
        }
    }

    @javafx.fxml.FXML
    public void acceptOnActionButton(ActionEvent actionEvent) {
        textfield1.clear();
        textfield1.setText("Appointment Accepted");
    }

    @javafx.fxml.FXML
    public void acceptOnActionButton1(ActionEvent actionEvent) {
        textfield2.clear();
        textfield2.setText("Appointment Accepted");
    }

    @javafx.fxml.FXML
    public void rescheduleOnActionButton(ActionEvent actionEvent) {
        textfield1.clear();
        textfield1.setText("Appointment Rescheduled");
    }

    @javafx.fxml.FXML
    public void markOnActionButton(ActionEvent actionEvent) {
        textfield3.clear();
        textfield3.setText("Appointment Completed");
    }

    @javafx.fxml.FXML
    public void markOnActionButton1(ActionEvent actionEvent) {
        textfield4.clear();
        textfield4.setText("Appointment Completed");
    }

    @javafx.fxml.FXML
    public void rescheduleOnActionButton1(ActionEvent actionEvent) {
        textfield2.clear();
        textfield2.setText("Appointment Rescheduled");
    }
}