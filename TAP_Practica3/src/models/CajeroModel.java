package models;
import java.util.HashMap;
import java.util.Map;

public class CajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;
    
    public CajeroModel(){
    cuentas = new HashMap<>();
    inicializarCuentas();
    }
    
    private void inicializarCuentas(){ //Hay que agregar mas cuentas
    cuentas.put("12345", new Cuenta ("12345", "1111", "Juan Perez", 5000));
    cuentas.put("54321", new Cuenta ("54321", "0000", "Maria Guadalupe", 4522));
    }
    
    public boolean autenticar(String numeroCuenta, String pin){
    Cuenta cuenta = cuentas.get(numeroCuenta);
    
    if (cuenta != null && cuenta.validarPin(pin)){
        this.cuentaActual = cuenta;
        return true;
    }
    return false;
    }
    
    public Cuenta getCuentaActual(){
    return this.cuentaActual;
    }
    
    public double consultarSaldo(){
    return this.cuentaActual != null ? cuentaActual.getSaldo():0;
    }
    
    public boolean realizarRetiro(double cantidad){
    return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    
    public boolean realizarDeposito(double cantidad){
    if(cuentaActual != null && cantidad > 0){
    cuentaActual.depositar(cantidad);
    return true;
    }
    return false;
    }
    
    public boolean cuentaExistente(String numeroCuenta){
    return cuentas.containsKey(numeroCuenta);
    }
    
    public boolean realizarTransferencia(double cantidad){
    return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    
    public void terminar(){
    System.exit(0);
    }
    //Tarea: Definir el metodo para transferir 
}
