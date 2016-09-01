/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaorganiser.logic;

import java.io.*;
import java.text.Collator;
import java.util.*;

/**
 *
 * @author Alex
 */
public class FileSelector {

    private int numberOfFiles = 0;
    private FileExtensionLogic fExtension;
    private ArrayList<String>fileList;

    public FileSelector(String dir, String extension) {

        fExtension = new FileExtensionLogic(extension);

        boolean allFiles = filesToSelect();
        System.out.println(allFiles);

        if (allFiles == true) {
            if ((fExtension.extensionCheck()).equals("film")) {
                selectAllFiles(dir, "film");
            } else if ((fExtension.extensionCheck()).equals("music")) {
                selectAllFiles(dir, "music");
            } else {
                System.err.println("Error extension type is not a valid music or video format");
                System.exit(1);
            }
        } else {
            selectType(dir, extension);
        }
    }

    public FileSelector(){
        
    }

    /*
     * Ask the user what they would like to do, select all of the files or
     * to only select one specific type with the filter
     */
    public boolean filesToSelect() {
        boolean allFiles = false;
        boolean loop = true;
        String userVal = "";

        while (loop == true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Select all files of Audio or Video? [Y]es or {N]o ");
            userVal = input.nextLine();

            userVal = userVal.trim().toLowerCase();

            if (userVal.equals("yes") || userVal.equals("y")) {
                allFiles = true;
                loop = false;

            } else if (userVal.equals("no") || userVal.equals("n")) {
                allFiles = false;
                loop = false;

            } else {
                System.out.println("Sorry you didn't select a value y or n");
            }
        }

        System.out.println(userVal);
        return allFiles;
    }

    //extension will equal film OR music only
    public ArrayList<String> selectAllFiles(String dir, String extension) {
        fileList = new ArrayList<>();
        int count = 0;

        File directory = new File(dir);

        for (File f : directory.listFiles()) {
            count++;
            String selExtension = f.getName();
            int stopIndex = selExtension.lastIndexOf(".");
            if (stopIndex != -1) {
                selExtension = selExtension.substring(stopIndex);
                selExtension = selExtension.replaceAll("[^\\d | \\w ]", "");
            }

            /*
             * control structure used to check which catagory the file fits into
             */
            if (extension.equals("film")) {
                for (FilmExtension film : FilmExtension.values()) {
                    if (film.name().equals(selExtension)) {
                        System.out.println(f.getName());
                        fileList.add(f.getName());
                    }
                }
            } else if (extension.equals("music")) {

                for (MusicExtension music : MusicExtension.values()) {
                    if (music.name().equals(selExtension)) {
                        System.out.println(f.getName());
                        fileList.add(f.getName());
                    }
                }

            } else {
                System.err.println("Error no extension selected");
                System.exit(1);
            }

//            if (stopIndex == -1) {
//                System.out.println("<<<<" + selExtension + ": Not a valid file type>>>>>");
//            } else {
//                System.out.println(f.getName() + "\n" + "Extension: " + selExtension);
//            }
        }
        System.out.println(count);

        return fileList;
    }

    public ArrayList<String> selectType(String dir, String extension) {

        System.out.println(extension);

        fileList = new ArrayList<>();
        int count = 0;

        File directory = new File(dir);

        for (File f : directory.listFiles()) {
            count++;
            String selExtension = f.getName();
            int stopIndex = selExtension.lastIndexOf(".");
            if (stopIndex != -1) {
                selExtension = selExtension.substring(stopIndex);
                selExtension = selExtension.replaceAll("[^\\d | \\w ]", "");
            }

            /*
             * control structure used to check which catagory the file fits into
             */
            if ((fExtension.extensionCheck()).equals("film")) {
                for (FilmExtension film : FilmExtension.values()) {
                    if (selExtension.equals(extension)) {
                        System.out.println(f.getName());
                        if (!fileList.contains(f.getName())) {
                            fileList.add(f.getName());
                        }
                        break;
                    }
                }
            } else if ((fExtension.extensionCheck()).equals("music")) {
                for (MusicExtension music : MusicExtension.values()) {
                    if (selExtension.equals(extension)) {
                        System.out.println(f.getName());
                        if (!fileList.contains(f.getName())) {
                            fileList.add(f.getName());
                        }
                        break;
                    }
                }

            } else {
                System.err.println("Error no extension selected");
                System.exit(1);
            }

//            if (stopIndex == -1) {
//                System.out.println("<<<<" + selExtension + ": Not a valid file type>>>>>");
//            } else {
//                System.out.println(f.getName() + "\n" + "Extension: " + selExtension);
//            }
        }
        System.out.println(count);
        System.out.println(fileList.toString());
        fileList.sort(Collator.getInstance());
        System.out.println(fileList.toString());

        return fileList;
    }
    
    public ArrayList<String> getFileList(){
        return fileList;
    }

//    public static void main(String[] args) {
//
//       FileSelector fSelect = new FileSelector("D:\\Video\\porn", "mp4");
//        FileSelector fSelect = new FileSelector("C:\\Users\\Alex\\Desktop\\videos\\The Flash - Season 1 Complete-ChameE", "mkv");
//    }

}
