import uy.edu.um.prog2.adt.binarytree.NodeAlreadyExists;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;
import uy.edu.um.classes.Consultas;
import uy.edu.um.exceptions.InformacionInvalida;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NodeAlreadyExists, DuplicateKey {
        try {
            Consultas consultas = new Consultas();
            ingresarOpcion(consultas);
        } catch (Exception e) {
            System.out.println("Hubo un error al ejecutar la consulta.");
            e.printStackTrace();
        }
    }

    public static void ingresarOpcion(Consultas consultas) throws DuplicateKey, InformacionInvalida {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("Elija una opcion: ");
                System.out.println("1) Consulta 1");
                System.out.println("2) Consulta 2");
                System.out.println("3) Consulta 3");
                System.out.println("4) Consulta 4");
                System.out.println("5) Consulta 5");
                System.out.println("0) Salir");
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion < 0 || opcion >= 6) {
                    throw new Exception("Opcion invalida.");
                }
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la fecha (yyyy-mm-dd): ");
                        String fechaConsulta1 = scanner.nextLine();
                        validarFecha(fechaConsulta1);
                        consultas.primeraConsulta("", fechaConsulta1);
                        break;
                    case 2:
                        System.out.println("Ingrese la fecha (yyyy-mm-dd): ");
                        String fechaConsulta2 = scanner.nextLine();
                        validarFecha(fechaConsulta2);
                        consultas.segundaConsulta(fechaConsulta2);
                        break;
                    case 3:
                        System.out.println("Ingrese la fecha de inicio (yyyy-mm-dd): ");
                        String fechaInicioConsulta3 = scanner.nextLine();
                        validarFecha(fechaInicioConsulta3);
                        System.out.println("Ingrese la fecha de fin (yyyy-mm-dd): ");
                        String fechaFinConsulta3 = scanner.nextLine();
                        validarFecha(fechaFinConsulta3);
                        consultas.terceraConsulta(fechaInicioConsulta3, fechaFinConsulta3);
                        break;
                    case 4:
                        System.out.println("Ingrese el nombre del artista: ");
                        String artista = scanner.nextLine();
                        System.out.println("Ingrese la fecha (yyyy-mm-dd): ");
                        String fechaConsulta4 = scanner.nextLine();
                        validarFecha(fechaConsulta4);
                        consultas.cuartaConsulta(artista, fechaConsulta4);
                        break;
                    case 5:
                        System.out.println("Ingrese el tiempo mínimo: ");
                        int tiempoMin = scanner.nextInt();
                        System.out.println("Ingrese el tiempo máximo: ");
                        int tiempoMax = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        if (tiempoMin <= 0 || tiempoMax <= 0) {
                            throw new Exception("El tiempo debe ser estrictamente positivo.");
                        }
                        System.out.println("Ingrese la fecha de inicio (yyyy-mm-dd): ");
                        String fechaInicioConsulta5 = scanner.nextLine();
                        validarFecha(fechaInicioConsulta5);
                        System.out.println("Ingrese la fecha de fin (yyyy-mm-dd): ");
                        String fechaFinConsulta5 = scanner.nextLine();
                        validarFecha(fechaFinConsulta5);
                        consultas.quintaConsulta(tiempoMin, tiempoMax, fechaInicioConsulta5, fechaFinConsulta5);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                }
            } catch (InformacionInvalida | DateTimeParseException e) {
                System.out.println("Fecha inválida, reintentelo.");
            } catch (Exception e) {
                System.out.println("Esa no es una opcion valida, reintentelo.");
            }
        }
    }

    public static void validarFecha(String fecha) throws InformacionInvalida, DateTimeParseException {
        LocalDate fechaIngresada = LocalDate.parse(fecha);
        LocalDate fechaMinima = LocalDate.of(2023, 10, 18);
        LocalDate fechaMaxima = LocalDate.of(2024, 5, 13);
        if (fechaIngresada.isBefore(fechaMinima) || fechaIngresada.isAfter(fechaMaxima)) {
            System.out.println("La fecha debe estar entre 2023-10-18 y 2024-05-13.");
            throw new InformacionInvalida();
        }
    }
}