package models;

public class Cuenta {

    private String numeroCuenta, pin, titular;
    private double saldo;
    
    public Cuenta(String numeroCuenta, String pin, String titular, double saldoInicial){
    this.numeroCuenta = numeroCuenta; //Seteamos los valores por defecto de las variables
    this.pin = pin;
    this.saldo = saldoInicial;
    this.titular = titular;
    
    
    }
    
    public String getNumeroCuenta(){
    return numeroCuenta;
    }
    
    public String getPin(){
    return pin;
    }
    
    public double getSaldo(){
    return saldo;
    }
    
    public String getTitular(){
    return titular;
    }
    
//Reglas de negocio
    public boolean validarPin(String pinIngresado){
    return this.pin.equals(pinIngresado);
    }
    
    public boolean retirar(double cantidad){
    if (cantidad > 0 && cantidad <= this.saldo){
        saldo -= cantidad;
        return true;
    }
    return false;
    }
    
    public void depositar(double cantidad){
    if (cantidad > 0){
        saldo += cantidad;
    }
    }
    
    public void transferir(double cantidad){
    if (cantidad > 0){
        saldo += cantidad;
    }
    }
    
    public interface OperacionBancaria {
    boolean ejecutar(Cuenta cuenta, double cantidad, Cuenta cuentaDestino);
    }
    
    public static class DepositoStrategy implements OperacionBancaria {
    @Override
    public boolean ejecutar(Cuenta cuenta, double cantidad, Cuenta cuentaDestino) {
        if (cuenta != null && cantidad > 0) {
            cuenta.depositar(cantidad);
            return true;
        }
        return false;
    }
    }
    
    public static class TransferenciaStrategy implements OperacionBancaria {
    @Override
    public boolean ejecutar(Cuenta cuenta, double cantidad, Cuenta cuentaDestino) {
        if (cuenta != null && cuentaDestino != null && cantidad > 0 && cuenta.retirar(cantidad)) {
            cuentaDestino.depositar(cantidad);
            return true;
        }
        return false;
    }
    }
    //Tarea: diseñar los comportamientos restantes (Transferir, cambiar PIN, etc (Al menos uno)
}
