/*Entidad Distribuidor */
package modelo;
import java.util.*;
/**
 *
 * @author carlos
 */
public class Distribuidor extends Empresa{
    private static int id=0;
    private String _idDistribuidor;
    //private ArrayList<Producto> _productos=new ArrayList();//productos que ofrece el proveedor
    /*public Distribuidor(String _nombre, String _ruc,ArrayList<Producto> _productos) {
        super(_nombre,_ruc);
        this._idDistribuidor="DIST"+Distribuidor.generador();
        this._productos=_productos;
    }*/
    
    public Distribuidor(String _nombre, String _ruc) {
        super(_nombre,_ruc);
        this._idDistribuidor="DIST"+Distribuidor.generador();        
    }
    
    public Vector toVector(){
         Vector<String> vct=new Vector();
        
        vct.add(this._idDistribuidor);
        vct.add(this.getNombre());
        vct.add(this.getRuc());
        
        return vct;
    }
    private static int generador(){       
       id++;
       return id;
   } 
    
}
