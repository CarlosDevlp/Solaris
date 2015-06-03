/*Entidad alternativa que tiene muchas funciones útiles para diferentes formularios */
package modelo;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author carlos
 */
abstract public class Util {
    public interface GeneralTable{
        public void setPointer(DefaultTableModel _tbModel);
        public  DefaultTableModel getPointer();
    }
    //punteros globales de objeto más recurrentes en el formulario
    public static GeneralTable pointerGTable=new GeneralTable(){
                                                    private DefaultTableModel _tbModel;
                                                    //apuntar a otra tabla modelo
                                                    public void setPointer(DefaultTableModel _tbModel){
                                                        this._tbModel=_tbModel;
                                                    }
                                                    //devolver una referencia a la tabla que se está apuntando
                                                    public DefaultTableModel getPointer(){
                                                        return this._tbModel;
                                                    }
                                                    //agregar nueva fila a la tabla
                                                    public void addRow(Vector<String> args){
                                                        this._tbModel.addRow(args);
                                                    }
                                                   //editar el contenido de una fila de la tabla  
                                                    public void editRow(int row,String []args){       
                                                           for(int col=0;col<this._tbModel.getColumnCount();col++)
                                                            this._tbModel.setValueAt(args[col], row, col);
                                                    }
                                            };
    
    //Evaluar el contenido del formulario
    public static void chequear(String []arr,int [][]res) throws Exception{        
        boolean err;//variable que identifica el error        
        //algoritmo para evaluar contenido no válido del formulario
        //white space o campos vacíos -restricción 1-
        for(String palabra: arr){
            err=true;
            for(char caracter: palabra.toCharArray())
                if(caracter!=' '){
                    err=false;
                    break;                    
                }
            
            if(err)
               throw new Exception("Partes del formulario están vacías");
        }
        //campos numéricos no válidos -restricción 2-       
        try{
            
            for(int i=res[0][0];i<res[0][1];i++)
                Double.parseDouble(arr[i]);
            
        }catch(Exception e){
            throw new Exception("En algunas partes del formulario, se esperaba el ingreso de números.");
        }
    }
    
    
}
