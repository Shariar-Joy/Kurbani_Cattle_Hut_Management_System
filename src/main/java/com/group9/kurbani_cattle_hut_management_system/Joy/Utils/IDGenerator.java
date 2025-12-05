package com.group9.kurbani_cattle_hut_management_system.Joy.Utils;

import java.io.*;
import java.util.Properties;

public class IDGenerator {

    private static final String FILE_NAME = "id_counters.properties";
    private static final Properties props = new Properties();

    private static int animalCounter;
    private static int ownerCounter;
    private static int tentCounter;
    private static int doctorCounter;
    private static int bookingCounter;
    private static int certificateCounter;


    static {
        loadCounters();
    }


    private static void loadCounters() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            props.load(fis);

            animalCounter = Integer.parseInt(props.getProperty("animalCounter", "1"));
            ownerCounter = Integer.parseInt(props.getProperty("ownerCounter", "1"));
            tentCounter = Integer.parseInt(props.getProperty("tentCounter", "1"));
            doctorCounter = Integer.parseInt(props.getProperty("doctorCounter", "1"));
            bookingCounter = Integer.parseInt(props.getProperty("bookingCounter", "1"));
            certificateCounter = Integer.parseInt(props.getProperty("certificateCounter", "1"));

        } catch (Exception e) {

            animalCounter = 1;
            ownerCounter = 1;
            tentCounter = 1;
            doctorCounter = 1;
            bookingCounter = 1;
            certificateCounter = 1;
        }
    }

    private static void saveCounters() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {

            props.setProperty("animalCounter", String.valueOf(animalCounter));
            props.setProperty("ownerCounter", String.valueOf(ownerCounter));
            props.setProperty("tentCounter", String.valueOf(tentCounter));
            props.setProperty("doctorCounter", String.valueOf(doctorCounter));
            props.setProperty("bookingCounter", String.valueOf(bookingCounter));
            props.setProperty("certificateCounter", String.valueOf(certificateCounter));


            props.store(fos, "ID Counters Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String generateAnimalID() {
        String id = "A" + String.format("%03d", animalCounter++);
        saveCounters();
        return id;
    }

    public static String generateOwnerID() {
        String id = "O" + String.format("%03d", ownerCounter++);
        saveCounters();
        return id;
    }

    public static String generateTentID() {
        String id = "T" + String.format("%03d", tentCounter++);
        saveCounters();
        return id;
    }
    public static String generateDoctorID() {
        String id = "D" + String.format("%03d", doctorCounter++);
        saveCounters();
        return id;
    }

    public static String generateBookingID() {
        String id = "B" + String.format("%03d", bookingCounter++);
        saveCounters();
        return id;
    }

    public static String generateCertificateID() {
        String id = "C" + String.format("%03d", certificateCounter++);
        saveCounters();
        return id;
    }
}


