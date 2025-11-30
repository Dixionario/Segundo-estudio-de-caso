import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVL arbol = new AVL();
        Scanner sc = new Scanner(System.in);
        int opcion;
        int valor;

        do {
            System.out.println("\n=== Menú Árbol AVL ===");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Buscar nodo");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Mostrar en orden");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    valor = sc.nextInt();
                    arbol.insertar(valor);
                    System.out.println("Insertado: " + valor);
                    break;

                case 2:
                    System.out.print("Valor a buscar: ");
                    valor = sc.nextInt();
                    System.out.println(arbol.buscar(valor) ?
                            "Encontrado: " + valor :
                            "No encontrado: " + valor);
                    break;

                case 3:
                    System.out.print("Valor a eliminar: ");
                    valor = sc.nextInt();
                    if (arbol.buscar(valor)) {
                        arbol.eliminar(valor);
                        System.out.println("Eliminado: " + valor);
                    } else {
                        System.out.println("No existe: " + valor);
                    }
                    break;

                case 4:
                    arbol.mostrarEnOrden();
                    break;

                case 0:
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}