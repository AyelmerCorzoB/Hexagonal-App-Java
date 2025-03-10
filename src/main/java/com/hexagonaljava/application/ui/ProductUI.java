package com.hexagonaljava.application.ui;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.product.ProductUseCase;

public class ProductUI {
    public static void manejarMenuProductos(Scanner sc, ProductUseCase productCasoUso) {
        int opcionProducts;
        do {
            String menuProducts = """
                    ********PRODUCTOS********
                    1. Registrar Producto
                    2. Obtener Producto por ID
                    3. Listar todos los productos
                    4. Actualizar un producto
                    5. Eliminar un producto
                    6. Salir...
                    Seleccione una opción:""";
            System.out.print(menuProducts);
            opcionProducts = sc.nextInt();
            sc.nextLine();

            switch (opcionProducts) {
                case 1:
                    System.out.print("Ingrese ID del Producto: ");
                    int idRegistroP = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    productCasoUso.registrarproducto(idRegistroP, nombre, stock);
                    System.out.println("✅ Producto registrado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingresa el ID del producto a buscar: ");
                    int idBusqueda = sc.nextInt();
                    sc.nextLine();
                    productCasoUso.obtenerproducto(idBusqueda);
                    break;
                case 3:
                    productCasoUso.listarproductos();
                    break;
                case 4:
                    System.out.print("Ingresa el ID del producto que quieres actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Ingresa el nuevo precio: ");
                    int nuevoStock = sc.nextInt();
                    sc.nextLine();
                    productCasoUso.actualizarproducto(idActualizar, nuevoNombre, nuevoStock);
                    break;
                case 5:
                    System.out.print("Ingresa el ID del producto que quieres eliminar: ");
                    int idEliminar = sc.nextInt();
                    productCasoUso.eliminarproducto(idEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                    break;
            }
        } while (opcionProducts != 6);
    }

}
