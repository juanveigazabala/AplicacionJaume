/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import dominiojaume.Cadete;
import dominiojaume.Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Mapeador;

/**
 *
 * @author Juan Zabala
 */
public class MapeadorCadete implements Mapeador{
   
    private Cadete c;

    
    public MapeadorCadete() {
    }

    public MapeadorCadete(Cadete c) {
        this.c = c;
    }

    public void setUsuario(Cadete c) {
        this.c = c;
    }
    
    @Override
    public int getOid() {
        return c.getOid();
    }

    @Override
    public void setOid(int oid) {
        c.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO cadete1 values (" + getOid() + ",'" +
                    c.getUsuario() + "','" + c.getPassword()+ "','" +
                    c.getNombre() + "','" + c.getApellido()  + "','" +
                    c.getTelefono() );
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlModificar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE cadete1 set usuario='" + c.getUsuario() +
                    "',password='" + c.getPassword() +
                    "',primerNombre='" + c.getNombre() +
                    "',primerApellido='" + c.getApellido() +
                    "',segundoApellido='" + c.getTelefono() +
                    "' where oid=" + getOid());
        return sqls;
        
        
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        ArrayList<String> sqls = new ArrayList();
        
        sqls.add("DELETE FROM cadete1 WHERE oid =" + c.getOid());
        return sqls;
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM cadete1";
    }

    @Override
    public void crearNuevo() {
        c= new Cadete();
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
         c.setUsuario(rs.getString("usuario"));
         c.setPassword(rs.getString("password"));
         c.setNombre(rs.getString("nombre"));
         
         c.setApellido(rs.getString("apellido"));
         c.setTelefono(rs.getString("telefono"));
    }

    @Override
    public Object getObjeto() {
        return c;
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
}


