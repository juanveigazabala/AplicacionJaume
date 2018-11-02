/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominiojaume;

/**
 *
 * @author Juan Zabala
 */
public class Cadete extends Usuario{
    
     public Cadete(String usuario, String password, String nombre, String apellido,String telefono) {
        super(usuario, password, nombre, apellido,telefono);
    }

    public Cadete() {
        super();
    }
    
   
}
