/*Entidad Cliente*/
package modelo;

import java.util.Vector;

/**
 *
 * @author carlos
 */
public class Cliente extends Persona {
    private static int id=0;
    private static final String []estado= {"DEUDOR","NORMAL"};
    private String _idCliente,_estado,_tipo;
    private double _credito;
    
    public Cliente(){
        //función por defecto para su uso en factories
        super();
        this._idCliente="CLIENT"+Cliente.generador();
        this.setNombre("");        
        this._tipo="";
        this.setDni("");
        this.setTelefono(0);
        this.setDireccion("");
    }
    //cuando el cliente solo quiere ingresar datos básicos
    public Cliente(String _nombre,String _dni){
        super(_nombre,  _dni, "vacío","vacío","vacío", "vacío", 0);        
        this._idCliente="CLIENT"+Cliente.generador();
        this._tipo="vacío";
    
    }
    //cuando el cliente quiere dejar muchos datos
    Cliente(String _nombre,String _dni, String _direccion, String _idDistrito, String _idProvincia, String _idDepartamento, int _telefono){
      super(_nombre,  _dni, _direccion, _idDistrito, _idProvincia, _idDepartamento, _telefono);
      this._idCliente="CLIENT"+Cliente.generador();
      this._credito=0.0;
      this._estado=Cliente.estado[0];
              
    }
    
    //setear crédito al cliente
    public void setCredito(double _credito) {
        this._credito = _credito;
    }
    
    
    //typecast
    public Vector toVector(){
         Vector<String> vct=new Vector();
        
        vct.add(this._idCliente);
        vct.add(this.getNombre());
        vct.add(this._tipo);
        vct.add(this.getDni());
        vct.add((this.getTelefono()==0)?"vacío":this.getTelefono()+"");
        vct.add(this.getDireccion());
        return vct;
    }
    
    private static int generador(){       
        id++;
        return id;
    }    
}
