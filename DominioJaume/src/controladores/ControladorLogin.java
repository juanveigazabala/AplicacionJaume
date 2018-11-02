/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import dominiojaume.Modelo;
import dominiojaume.Usuario;
import dominiojaume.ExceptionClass;

/**
 *
 * @author Juan Zabala
 */
public class ControladorLogin {
   
    
    private Modelo modelo = Modelo.getInstancia();
   //private IVistaLogin vistaLogin;
    public ControladorLogin(){}
    /*public ContLogin(VistaLogin v )
    {
        this.vistaLogin = v;
    }*/
    
    public void login(String usu,String pass) throws ExceptionClass
    {
         try{
                Usuario u = modelo.loginUsuario(usu,pass);
               // vistaLogin.mostrarVista(modelo.traerLuz());
        }
        catch(ExceptionClass msg)
        {
             //  vistaLogin.mostrarError(msg.getMessage());
        }
    }
            
    }
    

