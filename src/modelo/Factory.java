/*Entidad Patrón de Diseño FACTORY*/
package modelo;
import java.util.*;
/**
 *
 * @author carlos
 */
abstract public class Factory {
    //investigar más sobre la clase padre object, usar una clase padre que cumpla polimorfismo
    //alternativo
    public static Solaris createInstance(String Name){        
        switch(Name){
            case "Usuario":
                return new Usuario();
            case "Cliente":
                return new Cliente();
        }        
        return null;        
    }    
    
}

//nueva version del Factory

/*abstract  class superFactory<T>{
       
    public  T createInstance(String Name,ArrayList<String> Args){
        
        switch(Name){
            case "Usuario":
                //Args  username password
                return new Usuario();
            case "Producto":
                return  new Producto();
            
        }        
        return null;
    }
}*/

/*
class<?> C = Class.forName(Name);
        Constructor ctor = C.getConstructor(String.class);
        Object object = ctor.newInstance(new Object[] { ctorArgument=; });
*/