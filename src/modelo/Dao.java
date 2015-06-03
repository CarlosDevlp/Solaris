/*Entidad Data Access Object (Objeto de Acceso a Datos entre el programa y la base de datos)*/
package modelo;
import java.util.*;
import java.sql.*;
/**
 *
 * @author carlos
 */
abstract public class Dao {
    
    private interface DBConnection{
            public void init(String _database,String usr,String pass);
            public ResultSet query(String Qry,String command) throws Exception;
            public void setDB(String _database);
            public String getDB();
            
    }
                //Clase anonima para conectarse con la base de datos
    private static  DBConnection DB=new DBConnection(){
                                        private String _database;
                                        private Statement _query;                            
                                        //inicializar la conexion con la base de datos
                                        public void  init(String _database,String usr,String pass){                                
                                            
                                            try{
                                                //setear el nombre de la base de datos que voy a usar
                                               this._database=_database;                                   
                                               Connection con = DriverManager.getConnection("jdbc:mysql://localhost",usr, pass);
                                               this._query=con.createStatement();                              

                                            }catch(Exception err){};

                                        }
                                        
                                        //Ejecutar un código SQL en la base de datos
                                        public ResultSet query(String Qry,String command) throws Exception{                                                                                                    
                                            ResultSet result=null;                                             
                                            if(command==null)
                                                command="SELECT";
                                            switch(command){                                                                                                                                                
                                                case "INSERT":
                                                    this._query.executeUpdate(Qry);
                                                 break;
                                                default:
                                                    result=this._query.executeQuery(Qry);
                                            }
                                            
                                            return result;
                                        }
                                        
                                        //setear y obtener el nombre de la base de ddatos con la que estoy trabajando
                                        public void setDB(String _database){
                                            this._database=_database;
                                        }
                                        public String getDB(){
                                            return this._database;
                                        }
                                                                                
                                };  
    
    public static void init(String DB){
        Dao.DB.init(DB,"local","123456789123456789");
        try{
            Dao.DB.query("USE "+DB,"USE");
        }catch(Exception err){};//implementar con sistema de errores
        
    }
    

//recolector de resultados (arma un arreglo a partir de los resultados obtenidos de una query ejecutada)
    private static void result(ArrayList<ArrayList<String>> cols,ResultSet r,String col)
    throws Exception{        
        
        String []columnas=new String[0];      
        int tam;
            if(col.compareTo("*")==0)//todas las columnas                 
                tam= r.getMetaData().getColumnCount();                        
            else{//n columnas 
                columnas=col.split(",");
                tam=columnas.length;                
            }           
        int row=0;
            while(r.next()){                     
                    cols.add(new ArrayList<String>());
                            for(int i=1;i<=tam;i++){
                                if(columnas.length==0)
                                   cols.get(row).add( r.getString( i ) );
                                else{                                                                        
                                   cols.get(row).add( r.getString( columnas[i-1]) );
                                    
                                }
                            }
                    row++;
                    }
    }
    
    
    
    //Seleccionar datos de una base de datos
    //selección  básica
    public static ArrayList<ArrayList<String>> select(String col,String table,String where){
        ResultSet r;                
        ArrayList<ArrayList<String>> cols=new ArrayList();                
        try{ 
            //ejecución  del código sql
            r=Dao.DB.query("SELECT "+col+" FROM "+table+((where==null)?"":" WHERE "+where),"SELECT");
            //proceso de conversión de datos a array
            Dao.result(cols,r,col);                
        }catch(Exception err){
            System.out.println("error Select: "+err);
        }finally{ 
            return cols;}
        
    }
    //selección  con Joins
    public static ArrayList<ArrayList<String>> select(String col,String table,String Keys,String where){
        ResultSet r;                
        ArrayList<ArrayList<String>> cols=new ArrayList();                
        try{ 
            //ejecución  del código sql
            String []tbs=table.split(",");            
            String []k=Keys.split(",");
            
            if(Keys==null || tbs.length==1 || k.length==1)
                throw new Exception("Error en la query ingresada");  
            
            r=Dao.DB.query("SELECT "+col+" FROM "+tbs[0]+" INNER JOIN "+tbs[1]+" ON "+tbs[0]+"."+k[0]+"="+tbs[1]+"."+k[1]+((where==null)?"":" WHERE "+where),"SELECT");
            //proceso de conversión de datos a array
            Dao.result(cols,r,col);
        }catch(Exception err){
            System.out.println("error Join: "+err);
        }finally{ 
            return cols;}
        
        
    }

    //inserción
    public static void insert(String cols,String []values,String table){
        try{
            String vls="";            
            for(int i=0;i<values.length;i++){
                  vls+=" '"+values[i]+"' ";
                  if(i<values.length-1)
                      vls+=",";
            }
            
          Dao.DB.query("INSERT INTO "+table+" ("+vls+") VALUES ("+cols+")","INSERT");
        }catch(Exception err){
            System.out.println("error Insert: "+err);
        }
    }    
    
    //eliminación
    public static void delete(String table,String where){
        try{
            Dao.DB.query("DELETE  "+table+" WHERE "+where,"DELETE");
        }catch(Exception err){
            System.out.println("error Delete: "+err);
        }
        
    }
    
    //actualización
    public static void update(String cols,String []values,String table,String where){
        try{
            
            String vls="";
            String []cls= cols.split(",");            
            
            if(cls.length!=values.length)
                throw new Exception("Numero de columnas diferente al numero de filas");
            
            for(int i=0;i<values.length;i++){
                  vls+=cls[i]+" = '"+values[i]+"' ";
                  if(i<values.length-1)
                      vls+=" , ";
            }            
            
            Dao.DB.query("UPDATE  "+table+" SET "+vls+" WHERE "+where,"UPDATE");
        }catch(Exception err){
            System.out.println("error Update: "+err);
        }
                
    }
    
    
}