package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnimalRepository {
    private static AnimalRepository instance;
    private final ObservableList<Animalinfo> list;

    private AnimalRepository() {
        list = FXCollections.observableArrayList();
    }

    public static synchronized AnimalRepository getInstance() {
        if (instance == null) instance = new AnimalRepository();
        return instance;
    }

    public ObservableList<Animalinfo> getList() {
        return list;
    }

    public void add(Animalinfo info) { list.add(info); }

    public void clear() { list.clear(); }
}

