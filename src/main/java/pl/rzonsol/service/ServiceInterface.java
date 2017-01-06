package pl.rzonsol.service;

import java.util.List;

/**
 * Created by rzonsol on 04.01.2017.
 */
public interface ServiceInterface<T> {

    List<T> getObj();

    T create(T obj);

    T findById(String id);

    T update(T obj);
}
