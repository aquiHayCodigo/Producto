import java.util.List;

public interface DAO<E, ID> {
    // Create
    public void create(E e);
    // Read
    public List<E> readAll();
    public E readById(ID id);
    // Update
    public void update(E e);
    // Delete
    public void delete(ID id);
}
