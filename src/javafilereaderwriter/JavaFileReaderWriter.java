/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafilereaderwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.*;


public class JavaFileReaderWriter {

    public static void main(String[] args) {
        
        
        try(BufferedReader reader = new BufferedReader(new FileReader("BoyNames.txt"))) {
            
            ArrayList<String> uNames = new ArrayList<>();
            
            String line = reader.readLine();
            int counter = 0;
            
            while(line != null) {
                uNames.add(counter, line);
                line = reader.readLine();
                counter++;
            }
            System.out.println("Read file");
            
            Comparator<? super String> c = null;
            uNames.sort(c);
            
            System.out.println("Sorted list");
            
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("BoyNamesSorted.txt"))) {
            for(int i = 0; i < uNames.size(); i++) {
                writer.append(uNames.get(i));
                writer.newLine();
                }
                writer.close();
                System.out.println("Wrote list to file");
            }
            catch(IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
