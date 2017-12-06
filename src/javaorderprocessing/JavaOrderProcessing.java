/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaorderprocessing;

import java.io.File;



/**
 *
 * @author agonzalez
 */
public class JavaOrderProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        File input = new File("Orders.txt");
        File output = new File("OrdersProcessed.txt");
        OrderProcessor op = new OrderProcessor(input, output);
        op.MakeOrder();
    }
    
}
