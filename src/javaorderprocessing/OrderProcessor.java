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


    public OrderProcessor(File input, File output) throws IOException {   
        inputfile = input;
        outputfile = output;
        
    }
    
    public void MakeOrder() {
        System.out.println("Processing order");        
        
        try(BufferedReader br = new BufferedReader(new FileReader(inputfile)))
        {
            br.readLine();
            for (int i=0; i < br.read(); i++)
            {
                OrderList=br.readLine().split("\\|");
                System.out.println("Order ID: " + OrderList[0]);
                System.out.println("Part Number: " + OrderList[1]);
                System.out.println("Price: " + OrderList[2]);
                System.out.println("Quantity: " + OrderList[3]);
                System.out.println("Tax: " + GenerateTax(OrderList[2],OrderList[3]));
                System.out.println("Shipping: " + GenerateShipping(OrderList[2], OrderList[3]));
                System.out.println("Total: " + Total());
                System.out.println("------------");
                
                
            }
        }
        catch (IOException ex) {
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