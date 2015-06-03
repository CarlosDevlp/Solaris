/*Entidad Boleta */
package modelo;

/**
 *
 * @author carlos
 */
import java.util.*;

class Compra{
    private String _idproducto;
    private double _cantidad;

    Compra(String _idproducto, double _cantidad) {
        this._idproducto = _idproducto;
        this._cantidad = _cantidad;
    }
    
    public double calcularMonto(){
        return this._cantidad;
    }
    
}

public class Boleta {
    private static final String []estado= {"PENDIENTE","CANCELADO"};
    private static int id=0;
    private String _idBoleta,_idCliente,_estado;    
    private ArrayList<Compra> _compras= new ArrayList();
    
    Boleta(String _idCliente,ArrayList<Compra> _compras,String _estado){       
        this._idBoleta="BLTA"+Boleta.generador();
        this._idCliente=_idCliente;
        this._compras=_compras;
        this._estado=_estado;
    }
 
    //setear el estado de boleta si esta  pendiente(0) o cancelado(1)
    public void setEstado(int est) {
        this._estado = Boleta.estado[est];
    }        
    
    //calcular el monto total a ser publicado 
    public double calcularMontoTotal(){
        double total=0.0;
        for (Compra c: _compras)
            total+=c.calcularMonto();
        return total;
    }
    
    
    private static int generador(){       
        id++;
        return id;
    }       
}
