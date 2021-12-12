package by.bsuir.yanushkevich.lab04.specification;

import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParameters();
}
