/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaorganiser.logic;

/**
 * A simple class that is used to check the type of file extension the current
 * file has.
 * @author Alex
 */
public class FileExtensionLogic {
    private String userExtension = "";
    
    /**
     * Constructor that takes a String as its argument and pulls the extension
     * type out of the String.
     * @param extension a String object that you want to get the extension for
     */
    public FileExtensionLogic(String extension){
        
        extension = extension.replaceAll("[^\\d | \\w ]", "");        
        extension = extension.toLowerCase();
        userExtension = extension;

    }
    
    /**
     * This method checks the type of extension used and returns the extension
     * type name to be used to determine which files the program is processing.
     * @return String exType which returns a String value to be read by the program.
     */
    public String extensionCheck(){
        String exType = "";
        
        //check for blank statement
        if(userExtension.equals("")){
            System.err.println("Extension not set");
            System.exit(1);
        }
        
        //checks all of the music extensions to be equal to the extension string
        for(MusicExtension m: MusicExtension.values()){
            if(m.name().equals(userExtension)){
                exType ="music";
            }
        }
        
        //checks all of the film extensions to be equal to the extension string
        for(FilmExtension f: FilmExtension.values()){
            if(f.name().equals(userExtension)){
                exType = "film";
            }
        }
        //checks all of the document extensions to be equal to the extension string
        for(DocExtension d: DocExtension.values()){
            if(d.name().equals(userExtension)){
                exType = "doc";
            }
        }
        //returns the extension type
        return exType;
    }
    
    /**
     * Getter method to pull the type of extension assigned by the program for
     * the file
     * @return String of extension type
     */
    public String getExtension(){
        return userExtension;
    }
    
//    public static void main(String[]args){
//        FileExtensionLogic fsel = new FileExtensionLogic(".mp4%&&");
//        
//        System.out.println(fsel.extensionCheck());
//    }
}
