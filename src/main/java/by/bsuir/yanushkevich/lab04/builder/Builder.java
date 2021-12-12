package by.bsuir.yanushkevich.lab04.builder;

import by.bsuir.yanushkevich.lab04.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
