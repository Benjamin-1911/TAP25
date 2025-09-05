package models;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class CajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;
    
    /**
     *
     */
    public CajeroModel(){
    cuentas = new HashMap<>();
    inicializarCuentas();
    }
    
    private void inicializarCuentas(){ //Hay que agregar mas cuentas
    cuentas.put("12345", new Cuenta ("12345", "1111", "Juan Perez", 5000));
    cuentas.put("54321", new Cuenta ("54321", "0000", "Maria Guadalupe", 4522));
    }
    
    /**
     *
     * @param numeroCuenta
     * @param pin
     * @return
     */
    public boolean autenticar(String numeroCuenta, String pin){
    Cuenta cuenta = cuentas.get(numeroCuenta);
    
    if (cuenta != null && cuenta.validarPin(pin)){
        this.cuentaActual = cuenta;
        return true;
    }
    return false;
    }
    
    /**
     *
     * @return
     */
    public Cuenta getCuentaActual(){
    return this.cuentaActual;
    }
    
    /**
     *
     * @return
     */
    public double consultarSaldo(){
    return this.cuentaActual != null ? cuentaActual.getSaldo():0;
    }
    
    /**
     *
     * @param cantidad
     * @return
     */
    public boolean realizarRetiro(double cantidad){
    return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    
    /**
     *
     * @param cantidad
     * @return
     */
    public boolean realizarDeposito(double cantidad){
    if(cuentaActual != null && cantidad > 0){
    cuentaActual.depositar(cantidad);
    return true;
    }
    return false;
    }
    
    /**
     *
     * @param numeroCuenta
     * @return
     */
    public boolean cuentaExistente(String numeroCuenta){
    return cuentas.containsKey(numeroCuenta);
    }
    
    /**
     *
     * @param cantidad
     * @return
     */
    public boolean realizarTransferencia(double cantidad){
    return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    
    /**
     *
     * @param <T>
     * @param elemento
     */
    public <T> void terminar(T elemento){
    System.out.println(elemento);
    System.exit(0);
    }
    //Tarea: Definir el metodo para transferir 
}
