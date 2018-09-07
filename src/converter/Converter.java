/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author ibnahmad
 */
public class Converter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String filename = "newfile.txt";
        ArrayList<String> fileArray = new ArrayList<>();
        ArrayList<StringBuilder> newFileArray = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();
        
        Path filepath = Paths.get(filename);
        if(Files.notExists(filepath)){
            try {
                Files.createFile(filepath);
            } catch (IOException ex) {
                Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        File file = filepath.toFile();
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            // TODO code application logic here
            String line = reader.readLine();
            while(line != null){
                fileArray.add(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String linebyline : fileArray){
            String testline = linebyline;
            switch (testline.charAt(0)) {
                case 36:
                    lineBuilder.append(linebyline).append("; ");
                    newFileArray.add(lineBuilder);
                    break;
                case 43:
                    lineBuilder.append(linebyline);
                    lineBuilder.replace(0, 1, "@include");
                    newFileArray.add(lineBuilder);
                    break;
                case 61:
                    lineBuilder.append(linebyline);
                    lineBuilder.replace(0, 1, "@mixin");
                    newFileArray.add(lineBuilder);
                    break;
                default:
                    break;
            }
            lineBuilder.delete(0, 0);
        }
        
        System.out.println(newFileArray);
        
    }
    
    // Writing to a file
//    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.scss")));
//    for ()
}
