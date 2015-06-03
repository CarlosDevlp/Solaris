/*Entidad Empresa*/
package modelo;

/**
 *
 * @author carlos
 */
public class Empresa {

    private String _nombre, _ruc;

    public Empresa(String _nombre, String _ruc) {
        this._nombre = _nombre;
        this._ruc = _ruc;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getRuc() {
        return _ruc;
    }

    public void setRuc(String _ruc) {
        this._ruc = _ruc;
    }
    
    
}
