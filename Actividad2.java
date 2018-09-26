package com.JavaPOOEjercicios;


class Cuenta{

    private double saldo = 2000;


    public Cuenta(double saldo) { //constructor boton derecho en la clase
        this.saldo = saldo;
    }

    public double getBalance() {
        return saldo;
    }

    public double deposit(double deposit) {
       return this.saldo = this.saldo + deposit;
    }

    public double withdrad(double deposit){
        return this.saldo = this.saldo - deposit;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                '}';
    }

}

public class Actividad2{
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(10);
        System.out.println(cuenta.getBalance());
        System.out.println(cuenta.deposit(5));
        System.out.println(cuenta.withdrad(3));
    }

}
