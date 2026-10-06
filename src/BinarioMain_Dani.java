import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DaniMain {
    public static void main(String[] args) throws Exception {
        System.out.println("-------------");
        System.out.println("Guardar datos");
        System.out.println("Cargar datos");
        System.out.println("-------------");
        String opc = IO.readln();
        File f = new File("personas.bin");
        switch (opc) {
            case "1":
                guardarDatos(f);
            break;
            case "2":
                cargarDatos(f);
            break;
        }
    }

    public static void guardarDatos(File f){
        Persona p1 = new Persona("Claudia", "claudia@educa.madrid.org", "C14UD14");
        Persona p2 = new Persona("Tomas", "tomas@educa.madrid.org", "T0M4S");
        Persona p3 = new Persona("Dani", "dani@educa.madrid.org", "D4N1");
        Persona p4 = new Persona("Belen", "belen@educa.madrid.org", "B3L3N");
        Persona p5 = new Persona("David", "david@educa.madrid.org", "D4V1D");
        List<Persona> lista = List.of(p1, p2, p3, p4, p5);
        try (
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream writer = new ObjectOutputStream(fos);
        ) {
            for (Persona p : lista){
                writer.writeObject(p);
            }
            System.out.println("Datos guardados correctamente.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void cargarDatos(File f){
        try (
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream reader = new ObjectInputStream(fis);
        ) {
            while (true) {
                Object o = reader.readObject();
                Persona p = (Persona)o;
                System.out.println(p.getUser() + " - " + p.getMail() + " - " + p.getPassword());
            }
        }
        catch (EOFException e) {
            System.out.println("Datos leidos correctamente");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
