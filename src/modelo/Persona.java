/*Entidad Abstracta Persona*/
package modelo;

import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public abstract class Persona extends Solaris{
    private static int id=0;
    private String _idPersona,_nombre,_dni,_direccion,_ruc,_idDistrito,_idProvincia,_idDepartamento;
    private int _telefono;
    public Persona(){
        //función por defecto para su uso en factories
    }
    public Persona(String _nombre, String _dni, String _direccion, String _idDistrito, String _idProvincia, String _idDepartamento, int _telefono) {
        this._idPersona="PER"+Persona.generador();
        this._nombre = _nombre;
        this._dni = _dni;
        this._direccion = _direccion;
        this._idDistrito = _idDistrito;
        this._idProvincia = _idProvincia;
        this._idDepartamento = _idDepartamento;
        this._telefono = _telefono;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Persona.id = id;
    }

    public String getIdPersona() {
        return _idPersona;
    }

    public void setIdPersona(String _idPersona) {
        this._idPersona = _idPersona;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDni() {
        return _dni;
    }

    public void setDni(String _dni) {
        this._dni = _dni;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getRuc() {
        return _ruc;
    }

    public void setRuc(String _ruc) {
        this._ruc = _ruc;
    }

    public String getIdDistrito() {
        return _idDistrito;
    }

    public void setIdDistrito(String _idDistrito) {
        this._idDistrito = _idDistrito;
    }

    public String getIdProvincia() {
        return _idProvincia;
    }

    public void setIdProvincia(String _idProvincia) {
        this._idProvincia = _idProvincia;
    }

    public String getIdDepartamento() {
        return _idDepartamento;
    }

    public void setIdDepartamento(String _idDepartamento) {
        this._idDepartamento = _idDepartamento;
    }

    public int getTelefono() {
        return _telefono;
    }

    public void setTelefono(int _telefono) {
        this._telefono = _telefono;
    }
    
    
    
    private static int generador(){        
        id++;
        return id;
    }
}
