import com.company.model.InventoryManager;
import com.company.model.OrderProcessor;

void main() {


    OrderProcessor orderProcessor = new OrderProcessor();

    IO.println("Bienvenido al sistema de gestión de inventario y procesamiento de pedidos.");

    String name = IO.readln("Introduce el nombre del nuevo producto:");
    double price = Double.parseDouble(
        IO.readln("Introduce el precio del nuevo producto:"));

    IO.println("Procesando el nuevo producto...");

    orderProcessor.processNewProduct(name, price);

    IO.println("Producto añadido con éxito. Inventario actual:");

}
