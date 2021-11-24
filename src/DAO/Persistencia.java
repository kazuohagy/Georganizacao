/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.List;

/**
 *
 * @author kazuo
 */
public interface Persistencia<T> {
    public int create(T obj); //grava
    public List<T> read();  //retorna todos
    public boolean update (T obj); //atualiza
    public boolean delete (T obj); //exclui
    public T findByCodigo (int id); //retorna somente 1
}
