/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Dao;
import java.util.*;
import modelo.Factory;
/**
 *
 * @author carlos
 */
public class Test {
    
    public static void main(String []args){
        ArrayList<ArrayList<String>> A;
           Dao.init("Solaris");           
          // A=Dao.select("User,Password", "Usuario", null);
           
           /*for(ArrayList<String> B : A)
            System.out.println(Factory.createInstance("Usuario", B));*/
           /*for(ArrayList<String> B : A)
               for(String C: B)
                   System.out.println(C);*/
           
   
                   
    }
}
