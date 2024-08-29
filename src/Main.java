import com.cenavia.appfacturas.model.ItemFactura;
import com.cenavia.appfacturas.model.Cliente;
import com.cenavia.appfacturas.model.Factura;
import com.cenavia.appfacturas.model.Producto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese el NIF del cliente: ");
        String nif = s.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = s.nextLine();
        Cliente cliente = new Cliente(nif, nombre);

        System.out.print("Ingrese una descripción de la factura: ");
        String desc = s.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;

        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese nombre del producto nº " + (i + 1) + ": ");
            String nombreProducto = s.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            float precio = s.nextFloat();

            producto = new Producto(nombreProducto, precio);

            System.out.print("Ingrese la cantidad: ");
            int cantidad = s.nextInt();
            factura.addItemFactura(new ItemFactura(producto, cantidad));

            System.out.println();
            s.nextLine(); // limpiar el buffer de entrada
        }

        System.out.println(factura);
    }
}
