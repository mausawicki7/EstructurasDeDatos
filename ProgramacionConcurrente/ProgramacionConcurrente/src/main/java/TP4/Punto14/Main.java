/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto14;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mausa
 */
public class Main {
       public static void main(String [] args){
        Confiteria unaConfiteria = new Confiteria("El Cafecito", 2);
        Mozo unMozo = new Mozo("Alfred Pennyworth", unaConfiteria);
        Cocinero unCocinero = new Cocinero("Paulina Cocina", unaConfiteria);
        
        Thread hiloMozo = new Thread(unMozo);
        Thread hiloCocinero = new Thread(unCocinero);
        hiloMozo.start();
        hiloCocinero.start();

        Thread [] hiloEmpleado = new Thread[6];
        
        for(int i = 0; i<hiloEmpleado.length; i++){
            //Utilizamos math random para que el empleado elija aleatoriamente si quiere: 0 = beber, 1 = comer, 2 = beber y comer
            Empleado unEmpleado = new Empleado("Empleado "+i, unaConfiteria, (int) (Math.random() * 3));
            hiloEmpleado[i] = new Thread(unEmpleado);
            hiloEmpleado[i].start();
        }
        
        try{
            Thread.sleep((int) (Math.random() * 500));
            
        }catch(InterruptedException ex){
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}