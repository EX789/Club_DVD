/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.*;

public interface BaseDao <T>{
    public Boolean agregar(T dto);
    public Boolean eliminar(Integer id);
}
