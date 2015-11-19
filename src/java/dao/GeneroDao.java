/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.GeneroDto;
import java.util.List;

/**
 *
 * @author cetecom
 */
public interface GeneroDao extends BaseDao<GeneroDto>{
    public List<GeneroDto> listarGenero();
}
