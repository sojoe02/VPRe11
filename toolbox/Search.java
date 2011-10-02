/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sojoe
 */
public class Search {

    String pattern[];
    int count = 0;
    ArrayList paths = new ArrayList<String>();

    public Search(String[] pattern) {
        this.pattern = pattern;
    }

    /**
     * Method searching the filetree recursively.
     * 
     * @param dir A file object defining the top directory     * 
     * 
     **/
    public void findFilTypeAntal(File dir) {

        File listFile[] = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    //rekursive call if a directory is hit
                    findFilTypeAntal(listFile[i]);
                } else {
                    //check for pattern if a file is hit
                    for (int j = 0; j < pattern.length; j++) {
                        if (listFile[i].getName().endsWith(pattern[j])) {
                            
                            //fix windows naughty idea og using \ instead of /
                            paths.add(listFile[i].getPath().replace('\\', '/'));
                            count++;
                        }
                    }
                }
            }
        }
    }
    
    /*
     * Get the result array:
     */
    public ArrayList<String> getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        return "A Total of: \r" + count + "\r file(s) where found";
    }
    
    /*If I want to print out the results of the search neatly 
     * (can be inserted in to toString)
     */
    private String getpathString() {
        String temp = "";
        for (int i = 0; i < paths.size(); i++) {
            temp += paths.get(i) + "\n";
        }
        return temp;
    }
}
