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
private final File inputfile;
private final File outputfile;

    public OrderProcessor() {
        inputfile = new File("Orders.txt");
        outputfile = new File("ProcessedOrder.txt");
    }


    public OrderProcessor(File input, File output) throws IOException {   
        inputfile = input;
        outputfile = output;
        
    }
    
    public void MakeOrder() throws IOException {
        System.out.println("Processing order");
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
        
        try(BufferedReader br = new BufferedReader(new FileReader(inputfile)))
        {
            for (int i=0; i < br.toString().length(); i++)
            {
                writer.write(br.readLine());
            }
        }
        catch (IOException ex) {
            System.out.println("There was a problem reading the file.");
    }
        
    }
    
    
}