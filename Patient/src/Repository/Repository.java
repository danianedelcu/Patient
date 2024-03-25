package Repository;
import Domain.Identifiable;

public interface Repository<T extends Identifiable<ID>, ID> {
    void add(T object) throws Exception;
    void delete(ID id) throws Exception;
    void update(ID id, T object) throws Exception;
    T findById(ID id) throws Exception;

    Iterable<T> getAll();

}
