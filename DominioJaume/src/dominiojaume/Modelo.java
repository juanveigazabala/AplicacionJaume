/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominiojaume;

import java.util.Observable;

/**
 *
 * @author Juan Zabala
 */
public class Modelo extends Observable {

    private SistemaGestion sg = new SistemaGestion();
    private SistemaUsuario su = new SistemaUsuario();

    //Singleton
    private static Modelo instancia = new Modelo();

    public static Modelo getInstancia() {

        return instancia;
    }

    private Modelo() {
    }

   

    public enum Eventos {
        
    }

    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Usuario loginUsuario(String usuario, String password) throws ExceptionClass {
        return su.loginUsuario(usuario, password);
    }
   
    
    
    
    
}
