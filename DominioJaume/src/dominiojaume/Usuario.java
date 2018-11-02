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
public class Usuario {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String password;
    private String usuario;
    private int oid;

  
   
public Usuario (String usuario, String password, String nombre, String apellido,String telefono){
    this.nombre = nombre;
    this.apellido = apellido;
    this.password = password;
    this.usuario = usuario;
    this.telefono = telefono;
}
public Usuario(){}

  public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public boolean login(String usuario, String password) {
        boolean salida = false;
        if(this.usuario.equals(usuario) && this.password.equals(password))salida = true;
        return salida;
    }
    
}
