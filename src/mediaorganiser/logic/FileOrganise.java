/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaorganiser.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import mediaorganiser.logic.simplesort.SimpleSort;

/**
 *
 * @author Alex
 */
public class FileOrganise{
    ArrayList<File>fileList;
    String dir = "";
    
    public FileOrganise(String dir,ArrayList<File> fileList){
        this.fileList = fileList;
        this.dir = dir;
        
        
    }
    
    public void organiseMenu(){
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        while(loop ==true){
            System.out.println("Currently you have: " +fileList.size() + 
                    " files selected, what would you like to do?");
            System.out.println("[V]iew files \n"
                    + "[S]ort \n"
                    + "e[X]it");
            String cmd = input.nextLine();
            
            cmd = cmd.toLowerCase().trim();
            
            if(cmd.equals("v")){
                for( File x: fileList){
                    System.out.println(x);
                }
                System.out.println("Total number of files: " +fileList.size());
            }
            else if(cmd.equals("s")){
                SimpleSort.sortAZ(dir, fileList);
            }
            else if(cmd.equals("x")){
                System.out.println("Goodbye");
                loop = false;
                System.exit(0);
            }
            
            
        }
    }
    

    
}
