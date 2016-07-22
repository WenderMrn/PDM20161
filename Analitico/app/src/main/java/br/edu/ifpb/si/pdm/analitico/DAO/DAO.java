package br.edu.ifpb.si.pdm.analitico.DAO;

import java.util.List;

/**
 * Created by thor on 17/07/16.
 */
public interface DAO <T> {
    public void create(T obj);
    public void update(T obj);
    public void delete(int id);
    public void delete(T obj);
    public T read(int id);
    public List<T> readAll();
}
