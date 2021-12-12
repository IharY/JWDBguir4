package by.bsuir.yanushkevich.lab04.repository.impl;

import by.bsuir.yanushkevich.lab04.builder.RoomBuilder;
import by.bsuir.yanushkevich.lab04.entity.Room;
import by.bsuir.yanushkevich.lab04.exception.RepositoryException;
import by.bsuir.yanushkevich.lab04.repository.AbstractRepository;
import by.bsuir.yanushkevich.lab04.specification.Specification;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomRepository extends AbstractRepository<Room> {
    private static final String TABLE_NAME = " `room` ";

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    private static final String SELECT_QUERY = "SELECT * FROM `room` ";

    public RoomRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(Room item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(ROOM_NUMBER, item.getRoomNumber());
        values.put(OCCUPIED, item.getOccupied());
        values.put(ID, item.getId());

        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<Room> query(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParameters();
        return executeQueryForSingleResult(query, new RoomBuilder(), params);
    }

    @Override
    public List<Room> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParameters();
        return executeQuery(query, new RoomBuilder(), params);
    }
}
