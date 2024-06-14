import uy.edu.um.prog2.adt.binarytree.NodeAlreadyExists;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;
import uy.edu.um.classes.Consultas;
import uy.edu.um.exceptions.InformacionInvalida;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NodeAlreadyExists, DuplicateKey {
        try {

            System.out.println("Se subio el archivo correctamente.");
            try {
                Consultas consultas = new Consultas();
                ingresarOpcion(consultas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hubo un error al subir el archivo.");
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
                switch (opcion) { //falta verificar que las fechas esten en el rango de fechas valido  (2023-10-18-2024-05-13)
                    case 1:
                        consultas.primeraConsulta("", "2024-03-18"); //preguntar si podriamos poner lista de paises vlaidos para chequear
                        break;
                    case 2:
                        consultas.segundaConsulta("2023-12-01");
                        break;
                    case 3:
                        consultas.terceraConsulta("2023-12-01", "2024-01-20");
                        break;
                    case 4:
                        consultas.cuartaConsulta("Taylor Swift", "2024-05-11"); //si no existe artista tiramos lista vacia
                        break;
                    case 5:
                        consultas.quintaConsulta(100, 140, "2023-12-01", "2024-01-20"); //verificar tempo estrictamente positivo
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                }
            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("Esa no es una opcion valida, reintentelo.");
            }
        }
    }
}
