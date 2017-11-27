/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaorderprocessing;

import java.io.*;


/**
 *
 * @author agonzalez
 */
public class OrderProcessor {

    public OrderProcessor(File file1, File file2) {   
    try{
        InputStream in = new FileInputStream(file1);
        OutputStream out = new FileOutputStream(file2);
    }   catch (FileNotFoundException ex) {
            System.out.println("Couldn't open files.");
        }
    }
    
    
}