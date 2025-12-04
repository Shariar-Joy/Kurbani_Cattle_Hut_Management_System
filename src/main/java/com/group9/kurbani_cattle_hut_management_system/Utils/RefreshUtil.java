package com.group9.kurbani_cattle_hut_management_system.Utils;

import javafx.scene.control.*;

public class RefreshUtil {

    public static void clearFields(TextField... textFields) {
        for (TextField tf : textFields) {
            if (tf != null) tf.clear();
        }
    }

    public static void clearDatePickers(DatePicker... datePickers) {
        for (DatePicker dp : datePickers) {
            if (dp != null) dp.setValue(null);
        }
    }

    public static void clearComboBoxes(ComboBox<?>... comboBoxes) {
        for (ComboBox<?> cb : comboBoxes) {
            if (cb != null) cb.setValue(null);
        }
    }

    public static void clearCheckBoxes(CheckBox... checkBoxes) {
        for (CheckBox cb : checkBoxes) {
            if (cb != null) cb.setSelected(false);
        }
    }

    public static void clearRadioButtons(RadioButton... radioButtons) {
        for (RadioButton rb : radioButtons) {
            if (rb != null) rb.setSelected(false);
        }
    }

    public static void clearToggleGroups(ToggleGroup... toggleGroups) {
        for (ToggleGroup tg : toggleGroups) {
            if (tg != null) tg.selectToggle(null); // removes selection
        }
    }
}

