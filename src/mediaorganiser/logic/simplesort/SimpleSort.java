/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaorganiser.logic.simplesort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *Class for a basic sorting method that will take all elements and sort them into 
 * folders alphabetically, will not sort any number files (currently)
 * @author Alex
 */
public class SimpleSort {

    public SimpleSort() {

    }
    /**
     * Sorting method that will pull from an enum to sort files, only sorts files 
     * no folders, no 0-9 or any strange character first letter.
     * @param dir location of the files you want sorted
     * @param fileList array list of files to sort
     */
    public static void sortAZ(String dir, ArrayList<File> fileList) {

        int count = 0;
        for (File f : fileList) {

            //runs through the enum values to check the first letters
            for (SimpleSortAZ alpha : SimpleSortAZ.values()) {

                //checks the first character of the title and if it equals the enum will contiune
                if ((f.getName().substring(0, 1).toUpperCase()).equals(alpha.toString()) ) {
                    count++; //add to the count for files processed
                    String path = f.getAbsolutePath(); //gets the complete path
                    
                    //creates the new path for the file to be placed and folder from the enum
                    String fileName = path.substring(path.lastIndexOf(File.separatorChar));
                    path = path.substring(0, path.lastIndexOf(File.separatorChar));
                    path = path + File.separatorChar + alpha;

                    try {
                        //check that the path doesn't exist if it doesn't it will create it
                        if (!Files.exists(Paths.get(path))) {
                            Path dirPath = Paths.get(path);
                            Files.createDirectories(dirPath);
                        }
                        //if the path already exists it will move the file into the folder
                        Files.move(Paths.get(f.getAbsolutePath()), Paths.get(path + fileName));
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                        ex.getStackTrace();
                    }
                    System.out.println(alpha.toString() + " Selected for: \n"
                            + "        " + f.getName());

                }
            }
        }

        System.out.println("Total number of files successfully selected: " + (count) + "\n"
                + "Out of:" + fileList.size());
    }


}
