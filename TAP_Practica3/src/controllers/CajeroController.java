package controllers;
import models.CajeroModel;
import views.CajeroView;
import models.Cuenta.DepositoStrategy;
import models.Cuenta.TransferenciaStrategy;

/**
 *
 * @author usuario
 */
public class CajeroController {
    private CajeroModel model;
    
    private CajeroView view;
    
    private boolean sistemaActivo;
    
    /**
     *
     * @param model
     * @param view
     */
    public CajeroController(CajeroModel model, CajeroView view){
    this.model = model;
    this.view = view;
    this.sistemaActivo = true;
    }
    
    /**
     *
     */
    public void iniciarSistema(){
    view.mostrarBienvenida();
    while (sistemaActivo){
    if (autenticarUsuario()){
    ejecutarMenuPrincipal();
    }
    else {
    view.mostrarMensaje("Credenciales Incorrectas");
    }
    }
    view.mostrarMensaje("Gracias por usar nuestro cajero");
    }
    
    private boolean autenticarUsuario(){
    String numeroCuenta = view.solicitarNumeroCuenta();
    String pin = view.solicitarPin();
    return model.autenticar(numeroCuenta, pin);
    }
    
    private void ejecutarMenuPrincipal(){
    boolean sessionActiva = true;
    
    while(sessionActiva){
    view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
    int opcion = view.leerOpcion();
    switch (opcion){
        case 1:
            consultarSaldo();
            break;
        case 2:
            this.retirarRetiro();
            break;
        case 3:
            realizarDeposito();
            break;
        case 4:
            transferir();
            break;
        case 5:
            cambiarPIN();
            break;
        case 9:
            salir("Gracias por usar nuestro sistema :)");
            break;
        default:
            break;
        
    }
    }
    }
    
    /**
     *
     */
    public void consultarSaldo(){
    double saldo = model.consultarSaldo();
    view.mostrarSaldo(saldo);
    }
    
    /**
     *
     */
    public void retirarRetiro(){
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <= 0){
        view.mostrarMensaje("Error en la cantidad");
        return;
        }
        if (model.realizarRetiro(cantidad)){
        view.mostrarMensaje("Retiro Exitoso de "+cantidad);
        
        }
        else {
        view.mostrarMensaje("Fondos Insuficientes");
        
        }
    }
    
    /**
     *
     */
    public void realizarDeposito(){
    double cantidad = view.solicitarCantidad("Depositar");
    if (model.realizarOperacion(new DepositoStrategy(), cantidad, null)) {
        view.mostrarMensaje("Depósito exitoso de " + cantidad);
    } else {
        view.mostrarMensaje("Error en el depósito");
    }
}
    
    /**
     *
     */
    public void cambiarPIN(){
    String pin = view.cambiarPIN();
    if (pin == "Error"){
        System.out.println("Error al cambiar el pin");
        cambiarPIN();
    }
    else
        System.out.println("Su nuevo PIN es: "+pin);
    }
    
    /**
     *
     */
    public void transferir(){
    double cantidad = view.solicitarCantidad("Transferencia");
    String cuentaDestino = view.solicitarCuenta();

    if (model.realizarOperacion(new TransferenciaStrategy(), cantidad, cuentaDestino)) {
        view.mostrarMensaje("Transferencia exitosa de " + cantidad + " a la cuenta " + cuentaDestino);
    } else {
        view.mostrarMensaje("Error en la transferencia (cuenta inválida o fondos insuficientes)");
    }
}

    
    /**
     *
     * @param <T>
     * @param elemento
     */
    public <T> void salir(T elemento){
    model.terminar(elemento);
    }
}


//Agregar los metodos para transferir dinero a otra cuenta, y para cambiar el PIN.
//Investigar el Java.doc, que es una documentacion que va orientada a los programadores (No al cliente)
//Tambien hay que implementarlo en el proyecto (Jueves)