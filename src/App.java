
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opc;
        boolean menu = true;

        ProductoDAO dao = new ProductoDAO();

        while (menu) {
            System.out.println("Menu: ");
            System.out.println("1. Guardar un producto:  ");
            System.out.println("2. Guardar todos los productos ");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("Dime una opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Dime el id del producto: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Dime el nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.println("Dime el precio del producto: ");
                    double precio = Double.parseDouble(sc.nextLine());

                    Producto productoNuevo = new Producto(id, nombre, precio);

                    dao.create(productoNuevo);
                    
                    break;

                case 2:
                    limpiarPantalla();
                    List<Producto> guardar = new ArrayList<>();
                    dao.saveAll(guardar);

                    break;

                case 3:
                    limpiarPantalla();
                    List<Producto> mostrar = dao.readAll();
                    for (Producto producto : mostrar) {
                        System.out.println(producto.toString());
                    }
                    
                    break;

                case 4:
                    System.out.println("Saliendo....");
                    menu = false;
                    limpiarPantalla();
                default:
                    break;
            }
        }

        sc.close();
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
