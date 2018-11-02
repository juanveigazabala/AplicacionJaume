/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominiojaume;

import java.util.ArrayList;
import mapeadores.MapeadorCadete;
import persistencia.Persistencia;

/**
 *
 * @author Juan Zabala
 */
public class SistemaUsuario {
    private MapeadorCadete mc = new MapeadorCadete();
    private ArrayList<Usuario> usuarios = new ArrayList();


   public Usuario loginUsuario(String usuario, String password) throws ExceptionClass {
      Usuario u = null;
        if (usuarios.size() == 0) {
            throw new ExceptionClass("No hay Usuarios Ingresados");
        } else {
            for (Usuario us : usuarios) {

                if (us.login(usuario, password)) {
                    u = us;
                }
            }
            if (u == null) {
                throw new ExceptionClass("Datos Incorrectos");
            }
        }
        return u;
    }
   
    public void cargarCadetes(){
        usuarios.addAll(Persistencia.getInstancia().todos(mc));
    }

    }
    

