import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoBinario implements ProductoDAOLocal {

    private File fichero;

    public ProductoDaoBinario(String ruta) {
        this.fichero = new File(ruta);
    }

    @Override
    public void guardarTodos(List<Producto> productos) {
        // Producto p1= new Producto(1, "Chocolate", 4.5);
        // Producto p2= new Producto(2, "Turron", 6.5);
        // Producto p3= new Producto(3, "Caramelos", 2.5);
        // Producto p4= new Producto(3, "Bombones", 3.5);
        // List<Producto> productos1 = List.of(p1, p2, p3, p4);
        // File file = new File("ProductosBinario.txt");

        try (FileOutputStream streamFichero = new FileOutputStream(fichero);
                ObjectOutputStream writerOos = new ObjectOutputStream(streamFichero);) {
            // Escribiendo los objectos en el fichero (Object ya pasa a binario el producto)
            for (Producto producto : productos) {
                writerOos.writeObject(producto);
            }

        } catch (Exception e) {
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fichero);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            
            // Se lee hasta que de fallo
            while (true) {
                //Object o = ois.readObject();
                //Producto producto = (Producto) o;
                Producto producto = (Producto) ois.readObject();
                productos.add(producto);
               // System.out.println("Producto: " + producto.getNombre()); 
            }

        } catch (EOFException e) { // A la que termina de leer el fichero de objetos salta esta excepcion, 
        // porque aunque un fichero de texto normal se sabe cuando acaba porque lee una linea nula (null) en objetos nunca da null.
            System.out.println("Datos leidos correctamente");
        }catch (Exception e) {
        }
        return productos;
    }

}
