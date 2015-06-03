/*Entidad Producto */
package modelo;
import java.util.*;
/**
 *
 * @author carlos
 */
public class Producto {
    private static int id=0;
    private String _idProducto,_nombre;//podemos agregar una categoria de productos
    private int _cantidad;//cantidad de productos disponibles en la tienda
    private double _precioCosto,_precioVenta;
    
    public Producto(){
        //cuando se crea desde una fábrica
        this._idProducto="PROD"+Producto.generador();
    }
    public Producto(String _nombre){
        this._idProducto="PROD"+Producto.generador();
        this._nombre = _nombre;
    }
    public Producto(String _nombre, int _cantidad, double _precioCosto, double _precioVenta) {
        this._idProducto="PROD"+Producto.generador();
        this._nombre = _nombre;
        this._cantidad = _cantidad;
        this._precioCosto = _precioCosto;
        this._precioVenta = _precioVenta;
    }
    //SETTERS
        //cambiar el valor de la cantidad
    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void setPrecioCosto(double _precioCosto) {
        this._precioCosto = _precioCosto;
    }

    public void setPrecioVenta(double _precioVenta) {
        this._precioVenta = _precioVenta;
    }
    
        //obtener el valor de la cantidad
    //GETTERS            

    public static int getId() {
        return id;
    }    
        
    public int getCantidad() {
        return _cantidad;
    }

    public String getIdProducto() {
        return _idProducto;
    }

    public String getNombre() {
        return _nombre;
    }

    public double getPrecioCosto() {
        return _precioCosto;
    }

    public double getPrecioVenta() {
        return _precioVenta;
    }
    
    
    //convertir
    public Vector toVector(){ //usado particularmente para devolver columnas a una tabla
        Vector<String> vct=new Vector();
        
        vct.add(this._idProducto);
        vct.add(this._nombre);
        vct.add(String.valueOf(this._precioCosto));
        vct.add(String.valueOf(this._precioVenta));        
        return vct;
        
    }
    public String toString(){
        return "-Producto- ID: "+this._idProducto+" Nombre: "+this._nombre+" Cantidad: "+this._cantidad+" PC: "+this._precioCosto+" PV: "+this._precioVenta;
    }
        
    private static int generador(){       
        id++;
        return id;
    }   
    
}
