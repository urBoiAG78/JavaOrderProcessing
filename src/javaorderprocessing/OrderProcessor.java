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
private String OrderList[];

    public OrderProcessor() {
        inputfile = new File("Orders.txt");
        outputfile = new File("ProcessedOrder.txt");
    }


    public OrderProcessor(File input, File output) {   
        inputfile = input;
        outputfile = output;
        
    }
    
    public void MakeOrder() {
        System.out.println("Processing order");        
        
        try(BufferedReader br = new BufferedReader(new FileReader(inputfile)))
        {
            BufferedWriter filewriter = new BufferedWriter(new FileWriter(outputfile));
            br.readLine();
            for (int i=0; true; i++)
            {
                if(br.ready()){
                OrderList=br.readLine().split("\\|"); 
                System.out.println("Order ID: " + OrderList[0]);
                System.out.println("Part Number: " + OrderList[1]);
                System.out.println("Price: " + OrderList[2]);
                System.out.println("Quantity: " + OrderList[3]);
                System.out.println("Tax: " + GenerateTax(OrderList[2],OrderList[3]));
                System.out.println("Shipping: " + GenerateShipping(OrderList[2], OrderList[3]));
                System.out.println("Total: " + Total());
                System.out.println("------------");
                //this part writes the file
                filewriter.write("Order ID: " + OrderList[0]);
                filewriter.write("\n");
                filewriter.write("Part Number: " + OrderList[1]);       
                filewriter.write("\n");      
                filewriter.write("Price: " + OrderList[2]);        
                filewriter.write("\n");        
                filewriter.write("Quantity: " + OrderList[3]);        
                filewriter.write("\n");     
                filewriter.write("Tax: " + GenerateTax(OrderList[2],OrderList[3]));        
                filewriter.write("\n");       
                filewriter.write("Shipping: " + GenerateShipping(OrderList[2], OrderList[3]));        
                filewriter.write("\n");        
                filewriter.write("Total: " + Total());
                filewriter.write("\n");
                filewriter.write("---------------");
                filewriter.write("\n");
                }
                else
                {
                break; 
                }
            }
            filewriter.close();
        }
        catch (IOException ex) 
        {
            System.out.println("There was a problem reading the file.");     
    }
    System.out.println("Finish Order");
    
}
    public double GenerateTax(String s1, String s2){
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        double taxNum = (d1*d2) * 0.02;
        return taxNum;
    }
    public double GenerateShipping(String s1, String s2){
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        double shipping = (d1*d2) * 0.07; 
        return shipping;
    }
    public double Total(){
        double subtotal = Double.parseDouble(OrderList[2]) * Double.parseDouble(OrderList[3]);
        double total = subtotal + GenerateTax(OrderList[2],OrderList[3]) + GenerateShipping(OrderList[2],OrderList[3]);
        return total;
    }
}

    