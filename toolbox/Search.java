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
     * @param dir A file object defining the top directory
     **/
    public void findFilTypeAntal(File dir) {

        File listFile[] = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    findFilTypeAntal(listFile[i]);
                } else {
                    for (int j = 0; j < pattern.length; j++) {
                        if (listFile[i].getName().endsWith(pattern[j])) {
                            paths.add(listFile[i].getPath().replace('\\', '/'));
                            count++;
                        }
                    }
                }
            }
        }
    }

    public ArrayList<String> getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        return "A Total of: \r" + count + "\r file(s) where found";
    }

    private String getpathString() {
        String temp = "";
        for (int i = 0; i < paths.size(); i++) {
            temp += paths.get(i) + "\n";
        }
        return temp;
    }
}
