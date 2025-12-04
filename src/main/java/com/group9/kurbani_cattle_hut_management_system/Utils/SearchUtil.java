package com.group9.kurbani_cattle_hut_management_system.Utils;

import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SearchUtil {

    /**
     * Fully automatic search:
     * - validates empty input
     * - searches list
     * - shows alerts automatically
     * - returns matching results (never null)
     */
    public static <T> List<T> searchAndValidate(TextField searchField,
                                                List<T> list,
                                                Function<T, String> idGetter) {

        String id = searchField.getText().trim();

        // Empty field check
        if (id.isEmpty()) {
            AlertUtil.showError("Input Error", "Please enter an ID to search.");
            return new ArrayList<>();
        }

        // Empty data list
        if (list == null || list.isEmpty()) {
            AlertUtil.showError("No Data", "No data available to search.");
            return new ArrayList<>();
        }

        // Search logic
        List<T> results = new ArrayList<>();
        for (T item : list) {
            String ITEM_ID = idGetter.apply(item);
            if (ITEM_ID != null && ITEM_ID.equalsIgnoreCase(id)) {
                results.add(item);
            }
        }

        // Nothing found
        if (results.isEmpty()) {
            AlertUtil.showError("Not Found", "No record found with ID: " + id);
        }

        return results;
    }
}
