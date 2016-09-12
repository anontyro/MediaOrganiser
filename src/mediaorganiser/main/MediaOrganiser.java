/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaorganiser.main;

import java.io.File;
import java.util.ArrayList;
import mediaorganiser.logic.*;
import mediaorganiser.logic.simplesort.SimpleSort;

/**
 * Main program file for the media manager
 * @author Alex
 */
public class MediaOrganiser {
    private static ArrayList<File>fileList;
    private static String directory = "D:\\test";
    private static String extension = "txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        FileSelector fSelect = new FileSelector(directory, extension);
        System.out.println("First part done");
        
        fileList = fSelect.getFileList();
                System.out.println("copied to array");
                fileList.toString();
                
//        SimpleSort.sortAZ(directory, fileList);
//                System.out.println("Output from sort??");

    }
    
}
