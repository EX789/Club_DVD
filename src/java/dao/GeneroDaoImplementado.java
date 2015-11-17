/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.GeneroDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

/**
 *
 * @author cetecom
 */
public class GeneroDaoImplementado implements GeneroDao{

    @Override
    public List<String> listarGenero() {
        List<String> lista = null;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT nombre_genero FROM genero";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                lista.add(rs.getString("nombre_genero"));
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL AGREGAR: "+w.getMessage());
        } catch(Exception e){
            System.out.println("ERROR AL AGREGAR: "+e.getMessage());
            return null;
        }
        return lista;
    }

    @Override
    public Boolean agregar(GeneroDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
