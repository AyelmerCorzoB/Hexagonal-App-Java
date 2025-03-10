package com.hexagonaljava.application.ui;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.client.ClientUseCase;

public class ClientUI {
    public static void manejarMenuClientes(Scanner sc, ClientUseCase clienteCasoUso) {
        int opcionClient;
        do {
            String menuCliente = """
                    ********CLIENTES********
                    1. Registrar Cliente
                    2. Obtener cliente por ID
                    3. Listar todos los clientes
                    4. Actualizar un cliente
                    5. Eliminar un cliente
                    6. Salir...
                    Seleccione una opción:""";
            System.out.print(menuCliente);
            opcionClient = sc.nextInt();
            sc.nextLine();

            switch (opcionClient) {
                case 1:
                    System.out.print("Ingrese ID del Cliente: ");
                    int idRegistro = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese Email: ");
                    String email = sc.nextLine();
                    clienteCasoUso.registrarCliente(idRegistro, nombre, email);
                    System.out.println("✅ Cliente registrado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingresa el ID del cliente a buscar: ");
                    int idBusqueda = sc.nextInt();
                    sc.nextLine();
                    clienteCasoUso.obtenerCliente(idBusqueda);
                    break;
                case 3:
                    clienteCasoUso.listarClientes();
                    break;
                case 4:
                    System.out.print("Ingresa el ID del cliente que quieres actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Ingresa el nuevo email: ");
                    String nuevoEmail = sc.nextLine();
                    clienteCasoUso.actualizarCliente(idActualizar, nuevoNombre, nuevoEmail);
                    break;
                case 5:
                    System.out.print("Ingresa el ID del cliente que quieres eliminar: ");
                    int idEliminar = sc.nextInt();
                    clienteCasoUso.eliminarCliente(idEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                    break;
            }
        } while (opcionClient != 6);
    }
}
