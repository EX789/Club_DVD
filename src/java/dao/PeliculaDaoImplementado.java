/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PeliculaDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

/**
 *
 * @author cetecom
 */
public class PeliculaDaoImplementado implements PeliculaDao {

    @Override
    public List<PeliculaDto> buscarPelicula() {
        List<PeliculaDto> lista = null;
        PeliculaDto dto = new PeliculaDto();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM `pelicula`";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                dto.setId(rs.getInt("id_pelicula"));
                dto.setNombre(rs.getString("nombre_pelicula"));
                dto.setFechaRegistro(rs.getDate("fecha_registro"));
                dto.setAño(rs.getInt("anno_pelicula"));
                dto.setId_genero(rs.getInt("id_genero"));
                lista.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL AGREGAR: " + w.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR: " + e.getMessage());
            return null;
        }
        return lista;
    }

    @Override
    public List<PeliculaDto> buscarPorGenero(String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean agregar(PeliculaDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO `pelicula`(nombre_pelicula,anno_pelicula,fecha_registro,id_genero) VALUES (?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(query);
            insertar.setString(1, dto.getNombre());
            insertar.setInt(2, dto.getAño());
            insertar.setDate(3, new java.sql.Date(dto.getFechaRegistro().getTime()));
            insertar.setInt(4, dto.getId_genero());
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL AGREGAR: " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM `pelicula` WHERE id_pelicula=?";
            PreparedStatement insertar = conexion.prepareStatement(query);
            insertar.setInt(1, id);
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL AGREGAR: " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR: " + e.getMessage());
            return false;
        }
    }

}
