/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Juan Zabala
 */
public class Persistencia {
    

    
    private static Persistencia instancia = new Persistencia();
    private BaseDatos base;

    public static Persistencia getInstancia() {
        return instancia;
    }
   
    private Persistencia() {
        base = BaseDatos.getInstancia();
        base.conectar("jaumebd", "root", "Leon18022013");
    }
    private int proximoOid(){
        int oid = -1;
        ResultSet rs = base.consultar("SELECT valor from OID");
        try {
            if(rs.next()){ //hay un registro
                oid = rs.getInt("valor");
                base.modificar("UPDATE oid set valor = " + (oid+1));
            }
            else{
                System.out.println("DEBE INICIALIZAR EL OID");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener oid:"+ ex.getMessage());
        }
        return oid;
    }
    public void guardar(Mapeador map){
        if(map.getOid()==0){
            insertar(map);
        }else modificar(map);
    }

    private void insertar(Mapeador map) {
        int oid = proximoOid();
        map.setOid(oid);
        ArrayList<String> sqls = map.getSqlInsertar();
        if(!base.transaccion(sqls)){
            System.out.println("NO SE PUDO INSERTAR EL OBJETO");
            map.setOid(0);
        }
    }

    private void modificar(Mapeador map) {
        
        ArrayList<String> sqls = map.getSqlModificar();
        if(!base.transaccion(sqls)){
            System.out.println("ERROR AL ACTUALIZAR EL OBJETO");
        }

    }
    public void borrar(Mapeador map){
        if(map.getOid()==0) return;
        ArrayList<String> sqls = map.getSqlBorrar();
        if(!base.transaccion(sqls)){
            System.out.println("ERROR AL BORRAR EL OBJETO");
        }else{
            map.setOid(0);
        }
    }
    public ArrayList todos(Mapeador map){
        return buscar(map,null);
    }
    public ArrayList buscar(Mapeador map,String filtro){
        ArrayList lista = new ArrayList();
        String sql = map.getSqlSelect();//
        if(filtro!=null) sql+= " WHERE " + filtro;
        ResultSet rs = base.consultar(sql);
        try {
            //ASUMO ORDEN POR OID
            int oidAnt=-1;
            int oidActual;
            while(rs.next()){
               oidActual = rs.getInt("oid"); //EL CAMPO DEBE LLAMARSE ASI
               if(oidActual!=oidAnt){
                    map.crearNuevo();
                    map.setOid(oidActual); 
                    oidAnt = oidActual;
                    lista.add(map.getObjeto());
                    map.leerCompuesto(rs); //cabezal
               }
               map.leerComponente(rs);//linea
               
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar:" + ex);
            return null;
        }
        return lista;
    }
    
    
}




