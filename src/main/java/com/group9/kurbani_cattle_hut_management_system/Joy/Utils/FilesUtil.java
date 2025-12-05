//package com.group9.kurbani_cattle_hut_management_system.Joy.Utils;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FilesUtil {
//
//    // .BIN
//    public static void saveObject(String filePath, Object obj) {
//        try {
//            File file = new File(filePath);
//            FileOutputStream fos = new FileOutputStream(file, true);
//
//            ObjectOutputStream oos;
//            if (file.length() == 0) {
//                oos = new ObjectOutputStream(fos);          // first time → write header
//            } else {
//                oos = new AppendableObjectOutputStream(fos); // no header
//            }
//
//            oos.writeObject(obj);
//            oos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // READ .BIN
//    public static List<Object> readObjects(String filePath) {
//        List<Object> list = new ArrayList<>();
//        File file = new File(filePath);
//
//        if (!file.exists() || file.length() == 0) return list;
//
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//
//            while (true) {
//                try {
//                    list.add(ois.readObject());
//                } catch (EOFException e) {
//                    break;
//                }
//            }
//
//            ois.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//
//    private static class AppendableObjectOutputStream extends ObjectOutputStream {
//        public AppendableObjectOutputStream(OutputStream out) throws IOException {
//            super(out);
//        }
//        @Override
//        protected void writeStreamHeader() throws IOException {
//            reset();
//        }
//    }
//
//
//    //   SAVE .TXT
//
//    public static void saveText(String filePath, String text, boolean append) {
//        try {
//            FileWriter writer = new FileWriter(filePath, append);
//            writer.write(text + "\n");
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // READ .TXT
//    public static List<String> readText(String filePath) {
//        List<String> lines = new ArrayList<>();
//
//        try {
//            File file = new File(filePath);
//            if (!file.exists()) return lines;
//
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                lines.add(line);
//            }
//
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return lines;
//    }
//}
//
////Save text
////FileUtil.saveText("data/log.txt", "User logged in", true);
//
////Read text
////List<String> logs = FileUtil.readText("data/log.txt");
////
////for (String line : logs) {
////        System.out.println(line);
////}
//
////SAVE BIN (object)
////FileUtil.saveObject("data/user.bin", user);
////
////
////LOAD BIN (object)
////List<Object> list = FileUtil.readObjects("data/user.bin");
//
