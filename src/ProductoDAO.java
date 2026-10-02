
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements DAO<Producto, Integer> {

    String ruta = "Productos.txt";

        //método para la clase remota
    @Override
    public void create(Producto e) {
        File f = new File(ruta);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
            bw.write(e.getId() + ";" + e.getNombre() + ";" + e.getPrecio());
        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }
    }

        // método para la clase local
    public void saveAll(List<Producto> productos) {
        File f = new File(ruta);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
            for (Producto p : productos) {
                bw.write(p.getId() + ";" + p.getNombre() + ";" + p.getPrecio());
                bw.newLine();
            }

        } catch (Exception e) {
        }
    }

    @Override
    public List<Producto> readAll() {
        File f = new File(ruta);
        List<Producto> productosTodos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f));) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] producto = linea.split(";");
                String id = producto[0];
                String n = producto[1];
                String p = producto[2];

                Producto productoInsertar = new Producto(Integer.parseInt(id), n, Double.parseDouble(p));
                productosTodos.add(productoInsertar);
            }

        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }

        return productosTodos;
    }

    @Override
    public Producto readById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readById'");
    }

    @Override
    public void update(Producto e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
