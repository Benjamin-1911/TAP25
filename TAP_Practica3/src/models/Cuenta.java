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
    //Tarea: diseñar los comportamientos restantes (Transferir, cambiar PIN, etc (Al menos uno)
}
