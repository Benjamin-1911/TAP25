package views;
import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;
    
    public CajeroView(){
    scanner = new Scanner(System.in);
    }
    
    public void mostrarBienvenida(){
        System.out.println("=============");
        System.out.println("Bienvenido al cajero automatico del banco del bajio");
        System.out.println("=============");
    }    
    
    public String solicitarNumeroCuenta(){
        System.out.println("Ingresa tu numero de cuenta: ");
        return scanner.nextLine();
    }
    
    public String solicitarPin(){
        System.out.println("Ingresa tu numero PIN: ");
        return scanner.nextLine();
    }
    
    public void mostrarMenuPrincipal(String titular){
        System.out.println("==============");
        System.out.println("Bienvenid@ "+titular);
        System.out.println("==============");
        System.out.println("1.- Consultar saldo ");
        System.out.println("2.- Retirar ");
        System.out.println("3.- Depositar ");
        System.out.println("4.- Transferir ");
        System.out.println("5.- Cambiar PIN ");
        /*System.out.println("6.- Estado de cuenta ");
        System.out.println("7.- Retiro sin tarjeta ");*/
        //Definir las opciones faltantes (No necesariamente son 9)
        System.out.println("9.- Salir");
    }
    
    public int leerOpcion(){
    try {
    return Integer.parseInt(scanner.nextLine());
    }
    catch (NumberFormatException e) {
    return -1;
    }
    }
    
    public void mostrarSaldo(double saldo){
        System.out.println("====================");
        System.out.println("Tu saldo actual es: $"+saldo);
        System.out.println("====================");
    }
    
    public double solicitarCantidad(String operacion){
        System.out.println("Ingresar la cantidad a "+operacion+": ");
        try{
        return Double.parseDouble(scanner.nextLine());
        } 
        catch(NumberFormatException e){
        return -1;
        }
    }
    
    public String solicitarCuenta(){
    System.out.println("Ingresar la cuenta a depositar: ");
        try{
        return (scanner.nextLine());
        } 
        catch(NumberFormatException e){
        return "Falso";
        }
    }
    
    public String cambiarPIN(){
        System.out.println("Ingrese su nuevo PIN: ");
        String pin = scanner.nextLine();
    if(pin.length() < 5){
    return pin;
    }
    else {
        System.out.println("Error al ingresar el pin");
        return "Error";
    }
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println("===== "+mensaje);
    }
    
    //Tarea: Personalizar mensajes de error y de exito (Algo mas alla del mensaje generico, y que prevea varios casos)
    //Tarea: Metodo para salir y cerrar el Scanner
}
