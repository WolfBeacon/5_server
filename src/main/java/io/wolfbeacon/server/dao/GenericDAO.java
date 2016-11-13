package io.wolfbeacon.server.dao;

import javax.validation.constraints.NotNull;

public interface GenericDAO<T, I> {

    I create(T item);

    T retrieve(I id);

    void createOrUpdate(@NotNull T item);

    boolean update(T item);

    boolean delete(T item);
}
