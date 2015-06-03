/*Entidad Abstracta Usuario */
package modelo;
import java.util.*;
/**
 *
 * @author carlos
 */
public class Usuario extends Solaris{
    private static int id=0;
    private String _idUsuario,_username,_password;

    public Usuario(){
        //cuando se crea desde una fábrica
        this._idUsuario="USER"+Usuario.generador();
    }

    public Usuario(String _username, String _password) {
        this._idUsuario="USER"+Usuario.generador();
        this._username = _username;
        this._password = _password;
    }
    
    
    private static int generador(){       
        id++;
        return id;
    }    

    //Setters

    public void setUsername(String _username) {
        this._username = _username;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    
    //funcion para usuario y contraseña ingresados
    public boolean checkAccount(String username,String password){       
        if(this._username.compareTo(username)==0 && this._password.compareTo(password)==0) 
            return true;
        else 
            return false;
        
    }

}



/*
    No es recomendable tener la función mágica toString en clases como esta
        public String toString(){
        return this._username;
    }*/