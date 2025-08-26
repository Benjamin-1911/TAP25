import java.util.Scanner;

public class Practica1Cajero {
    public static void main(String[] args) {
        Practica1Cajero v_objeCajero = new Practica1Cajero();
        v_objeCajero.m_inicializar();
        }

    private void m_inicializar(){
    Scanner scanner = new Scanner(System.in);
        String[] usuarios = {"1234", "5678"};
        String[] nombres = {"Juan", "Maria"};
        double[] saldos = {1000.0, 2500.0};
        int intentos = 0;
        boolean salir = false;
        int usuarioActual = -1;

        System.out.println("=== Bienvenido al Cajero ===");
        
        while (intentos < 3 && usuarioActual == -1) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].equals(pin)) {
                    usuarioActual = i;
                    break;
                }
            }
            if (usuarioActual == -1) {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        }

        if (usuarioActual == -1) {
            System.out.println("Demasiados intentos fallidos. Adios.");
            return;
        }

        System.out.println("Bienvenido, " + nombres[usuarioActual]);

        m_menuPrincipal(scanner, salir, usuarios, saldos, usuarioActual);
    }
    
    public void m_menuPrincipal(Scanner scanner, boolean salir, String[] usuarios, double[] saldos, int usuarioActual){
    while (!salir) {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcion == 1) {
                m_mostrarSaldo(saldos, usuarioActual);
            } else if (opcion == 2) {
                m_retiro(scanner, usuarios, usuarioActual, saldos);
            } else if (opcion == 3) {
                m_depositar(scanner, usuarioActual, saldos);
            } else if (opcion == 4) {
                salir = true;
                System.out.println("Gracias por usar el cajero.");
            } else {
                System.out.println("Opcion invalida.");
            }
    }
}
    
    public void m_mostrarSaldo(double[] saldos, int usuarioActual){
    System.out.println("Su saldo es: $" + saldos[usuarioActual]);
    }
    
    
    
    
    public void m_retiro(Scanner scanner, String[] usuarios, int usuarioActual, double[] saldos){
    System.out.print("Ingrese cantidad a retirar: ");
                double retiro = scanner.nextDouble();
                if (retiro <= saldos[usuarioActual]) {
                    saldos[usuarioActual] -= retiro;
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldos[usuarioActual]);
                } else {
                    System.out.println("Fondos insuficientes.");
                }
    }
    
    
    
    
    private void m_depositar(Scanner scanner, int usuarioActual, double[] saldos){
    System.out.print("Ingrese cantidad a depositar: ");
                double deposito = scanner.nextDouble();
                saldos[usuarioActual] += deposito;
                System.out.println("Deposito exitoso. Nuevo saldo: $" + saldos[usuarioActual]);
    }
    
}