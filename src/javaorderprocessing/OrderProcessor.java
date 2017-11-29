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
private File inputfile;
private File outputfile;

    public OrderProcessor() {
        inputfile = new File("Orders.txt");
        outputfile = new File("ProcessedOrder.txt");
    }


    public OrderProcessor(File input, File output) throws IOException {   
        inputfile = input;
        outputfile = output;
        
    }
    
    public void MakeOrder(){
        System.out.println("Processing order");
        
    }
    
    
}