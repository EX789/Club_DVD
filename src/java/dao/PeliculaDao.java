/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PeliculaDto;
import java.util.List;

/**
 *
 * @author cetecom
 */
public interface PeliculaDao extends BaseDao<PeliculaDto>{
    public List<PeliculaDto> buscarPelicula();
    public List<PeliculaDto> buscarPorGenero(int genero);
}
