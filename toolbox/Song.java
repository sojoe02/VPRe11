/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox;

/**
 *
 * @author sojoe
 */
public class Song {
    
    String path;
    String extension;
    String title;
    
    Song(String path, String extension, String title){
        
        this.path = path;
        this.extension = extension;
        this.title = title;
        
    }
    
    public String getExtension(){
        return extension;
    }
    
    public String getPath(){
        return path;        
    }
    
    public String getTitle(){
        return title;
    }
    
}
