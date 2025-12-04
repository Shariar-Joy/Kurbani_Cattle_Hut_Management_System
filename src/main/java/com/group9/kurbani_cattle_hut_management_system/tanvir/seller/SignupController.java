package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import com.group9.kurbani_cattle_hut_management_system.AppendableObjectOutputStream;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.BinFilePath;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private TextField nidTextField;

    private final Alert alert = new Alert(Alert.AlertType.WARNING);
    private final FileChooser fileChooser = new FileChooser();

    private File kycFile = null;
    private Seller signupSeller = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setInitialSignupSeller(Seller signupSeller) {
        this.signupSeller = signupSeller;
    }

    @FXML
    public void handleKYCDocumentUpload(ActionEvent actionEvent) {
        File kycFile = fileChooser.showOpenDialog(((Node) actionEvent.getSource()).getScene().getWindow());
        if (kycFile == null) {
            return;
        }
        this.kycFile = kycFile;
    }

    @FXML
    public void handleSignup(ActionEvent actionEvent) {
        String nid = nidTextField.getText();
        if (nid == null || nid.isEmpty()) {
            alert.setContentText("NID cannot be empty");
            alert.showAndWait();
            return;
        }

        signupSeller.setNID(nid);
        signupSeller.setKycURL(kycFile != null ? kycFile.getAbsolutePath() : null);

        if (kycFile != null) {
            try {
                Files.copy(
                        kycFile.toPath(),
                        new File("bin/seller/KYC_" + signupSeller.getSellerEmail() + "_" + kycFile.getName()).toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (Exception e) {
                System.out.printf("[Error] [Seller SignupController] [KYC File Copy] %s\n", e.getMessage());
            }
        }

        File binFile = new File(BinFilePath.SELLER.getFilePath());
        boolean append = binFile.exists();
        try (
                FileOutputStream fos = new FileOutputStream(binFile, append);
                ObjectOutputStream oos = append ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);
        ) {
            oos.writeObject(signupSeller);
        } catch (Exception e) {
            System.out.printf("[Error] [Seller Signup] %s\n", e.getMessage());
            alert.setContentText("Seller Signup Failed");
            alert.showAndWait();
            return;
        }

        try {
            BaseController.switchTo(actionEvent, "login.fxml");
        } catch (Exception e) {
            System.out.printf("[Error] [Seller Signup] [Switch to Login] %s\n", e.getMessage());
        }
    }
}
