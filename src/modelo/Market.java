/*Entidad central MARKET*/
/*Entidad centrar sirve para administrar toda la data de los modelos partipantes en el contexto
mercado*/
package modelo;
import java.util.*;

/**
 *
 * @author carlos
 */
abstract public class Market {
    
    private static ArrayList<Usuario> _usuarios=new ArrayList(); //lista de usuarios en el sistema   
    private static ArrayList<Producto> _productos=new ArrayList();//inventario de productos
    private static ArrayList<Distribuidor> _distribuidores=new ArrayList();//inventario de distribuidores
    private static ArrayList<Cliente> _clientes=new ArrayList();
    
    public static void init(){
    
    }    
    //setters
    public static void setProducto(Producto _producto){
        Market._productos.add(_producto);
    }
    public static void setProductos(ArrayList<Producto> _productos){
        Market._productos=_productos;
    }    
    
    public static void setDistribuidores(ArrayList<Distribuidor> _distribuidores) {
        Market._distribuidores = _distribuidores;
    }

    public static void setCliente(ArrayList<Cliente> _clientes){
        Market._clientes= _clientes;
    }
    
    //getters
  
    public static ArrayList<Producto> getProductos() {
        return _productos;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return _usuarios;
    }
    
    public static ArrayList<Distribuidor> getDistribuidores() {
        return _distribuidores;
    }
    
    public static ArrayList<Cliente> getClientes(){
        return _clientes;
    }
    
    //others
    //adds
    public static void addProducto(Producto _producto){
        Market._productos.add(_producto);
    }
    
    //create
    public static void createUsuarios(ArrayList<ArrayList<String>> _str){
         for(ArrayList<String> row: _str)          
             Market._usuarios.add(new Usuario(row.get(0),row.get(1)));
    }
    
    public static void createProductos(ArrayList<ArrayList<String>> _str){        
        for(ArrayList<String> row: _str)            
            Market._productos.add(new Producto(row.get(1),0,Double.parseDouble(row.get(2)),Double.parseDouble(row.get(3)) ) );
        
    }
    public static void createDistribuidores(ArrayList<ArrayList<String>> _str){
         for(ArrayList<String> row: _str)    
             Market._distribuidores.add(new Distribuidor(row.get(0),row.get(1)));
    }
    public static void createClientes(ArrayList<ArrayList<String>> _str){
         for(ArrayList<String> row: _str)
             //Market._clientes.add(new Cliente());new Cliente(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),Integer.parseInt(row.get(6))));
             Market._clientes.add(new Cliente(row.get(0),row.get(1)));             
         
    }
    
}
