import java.util.List;

public interface ProductoDAOLocal {
    
    void guardarTodos(List<Producto> productos);
    List<Producto> listarTodos();

}
