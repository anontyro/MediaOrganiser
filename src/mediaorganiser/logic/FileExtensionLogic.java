/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaorganiser.logic;

/**
 *
 * @author Alex
 */
public class FileExtensionLogic {
    private String userExtension = "";
    
    public FileExtensionLogic(String extension){
        
        extension = extension.replaceAll("[^\\d | \\w ]", "");        
        extension = extension.toLowerCase();
        userExtension = extension;

    }
    
    public String extensionCheck(){
        String exType = "";
        
        if(userExtension.equals("")){
            System.err.println("Extension not set");
            System.exit(1);
        }
        
        
        for(MusicExtension m: MusicExtension.values()){
            if(m.name().equals(userExtension)){
                exType ="music";
            }
        }
        
        for(FilmExtension f: FilmExtension.values()){
            if(f.name().equals(userExtension)){
                exType = "film";
            }
        }
        
        for(DocExtension d: DocExtension.values()){
            if(d.name().equals(userExtension)){
                exType = "doc";
            }
        }
        
        return exType;
    }
    
    public String getExtension(){
        return userExtension;
    }
    
//    public static void main(String[]args){
//        FileExtensionLogic fsel = new FileExtensionLogic(".mp4%&&");
//        
//        System.out.println(fsel.extensionCheck());
//    }
}
