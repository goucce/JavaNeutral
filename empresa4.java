package com.JavaPOOEjercicios;



import java.util.Scanner;
import java.util.ArrayList;

public class empresa4 {

    public static void main(String[] args) {

        //Creamos las diferentes arrays deonde almacenaremos las empresas y los empleados
        ArrayList<Empresa> empresas = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();

        //Declaramos el scanner para introducir valores desde el terminal
        Scanner sc = new Scanner(System.in);
        //Repeat para sacar el menú
        Boolean repeatMenu = true;

        while (repeatMenu) {
            //Menú de opciones a elegir
            System.out.println("");
            System.out.println("1. Crear nueva empresa");
            System.out.println("2. Añadir empleado a empresa");
            System.out.println("3. Listado de empresas");
            System.out.println("4. Información de la empresa");
            System.out.println("5. Crear empleado");
            System.out.println("6. Listado de empleados");
            System.out.println("7. Información de empleado");
            System.out.println("8. Salir");
            System.out.println();

            //Elección de la opciópn
            System.out.println("¿Qué quieres hacer? ");
            String option = sc.nextLine(); //Opcion guardada por el teclado
            System.out.println();

            switch (option) {
                case "1": {
                    //Crear empresa
                    System.out.println("-------------------------");

                    //Creamos nueva objeto Empresa llamado empresa acediendo a la clase Empresa
                    Empresa empresa = new Empresa();
                    System.out.println("Nombre de la empresa: ");
                    //Parametro guardado por consola enviado a empresa.nombre
                    empresa.nombre = sc.nextLine();
                    System.out.println("Año de fundación: ");
                    //Paramtro guardado por consola envaido a empresa.anyodefundacion
                    empresa.anyodefundacion = sc.nextLine();

                    //Accedemos a CreaEmpresa donde le damos los parametros de "empresas, empresa"
                    //empresas se corresponde al array donde queremos ir almacenando _todas las diferentes empresas
                    Empresa.NuevaEmpresa(empresas, empresa);
                    System.out.println();
                    System.out.println("Se ha creado " + empresa.nombre + ", fundada en " + empresa.anyodefundacion);

                    System.out.println("-------------------------");
                    break;
                }
                case "2": {
                    //Añadir empleado a empresa existente
                    String nombre, apellidos;



                    System.out.println("-------------------------");
                    System.out.print("Introduzca nombre de empresa: ");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    nombre = sc.nextLine();
                    System.out.println();

                    System.out.print("Apellidos del empleado: ");
                    apellidos = sc.nextLine();
                    System.out.println();

                    System.out.println("-------------------------");

                    //enviar dentro de la clase Empresa el empleado a la empresa que ya existe.
                    //le pasamos tanto los nombres y apellidos como el array donde se alacenan.
                    Empresa.AnyadirEmpleado(nombre, apellidos, empleados, empresas);

                    break;
                }

                case "3": {
                    //Listado de empresas easy

                    System.out.println("Actuamente tenemos guardadas estas empresas:");
                    Empresa.ListadoEmpresas(empresas);
                    break;
                }

                case "4": {

                    //Informacion de una empresa en particular.
                    String nombreEmpresa;

                    System.out.println();
                    System.out.println("-------------------------");

                    System.out.print("Nombre de la empresa: ");
                    nombreEmpresa = sc.nextLine();

                    //Pasamos al metodo los valores determinados
                    Empresa empresa = Empresa.seleccionarEmpresa(nombreEmpresa, empresas);
                    Empresa.informacionEmpresa(empresa);

                    System.out.println("-------------------------");
                    System.out.println();
                    break;
                }

                case "5": {

                    // Crear empleado.
                    System.out.println("--------------------------------");
                    System.out.println();
                    Empleado empleado = new Empleado();
                    System.out.print("Nombre: ");
                    empleado.nombre = sc.nextLine();

                    System.out.print("Apellidos: ");
                    empleado.apellidos = sc.nextLine();

                    System.out.print("Fecha de nacimiento: ");
                    empleado.fechanacimiento = sc.nextLine();

                    System.out.print("Fecha de contratación: ");
                    empleado.fechacontrato = sc.nextLine();

                    Empleado.CreaEmpleado(empleados, empleado);
                    System.out.println("Se ha añadido al empleado " + empleado.nombre + " " + empleado.apellidos);
                    Empleado.ListadoEmpleados(empleados);
                    System.out.println();
                    System.out.println("--------------------------------");
                    break;
                }

                case "6": {
                    // Listado de empleados

                    Empleado.ListadoEmpleados(empleados);
                    break;
                }

                case "7": {

                    // Información de un empleado en particular.

                    String apempleado;
                    System.out.print("Apellidos del empleado: ");
                    apempleado = sc.nextLine();
                    Empleado empleado = Empleado.seleccionarEmpleado(apempleado, empleados);
                    Empleado.InfoEmpleado(empleado);
                    break;
                }

                case "8": {
                    repeatMenu = false;
                    break;
                }

                default: {
                    System.out.println("Elija otra vez");
                }
            }
        }
    }
}

class Empresa {

    //Diferentes variables necesarias
    String nombre;
    String anyodefundacion;
    ArrayList<Empleado> arrayEmpleados;

    //Metodo geter and seter del nombre de la empresa
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo de geter and seter para el año de fundación.
    public String getAnyodefundacion() {
        return anyodefundacion;
    }

    public void setAnyodefundacion(String anyodefundacion) {
        this.anyodefundacion = anyodefundacion;
    }


    //Metodo de creacion de nueva empresa donde  la inroducimos en el ArrayList de Empresa, llamados empresas
    public static void NuevaEmpresa (ArrayList<Empresa> empresas, Empresa empresa) {
        //Tras recibir los parametros deseados, añadimos en el array la empresa.
        empresas.add(empresa);
    }

    //Metodo que recibe el array de la lista de todas las empresas, de lista de empresas
    public static void ListadoEmpresas (ArrayList<Empresa> empresas) {
        //Tras recibir el aray hay que recorrerlo para mostrarlo por la consola
        System.out.println("---------------------------");
        for (int i = 0; i < empresas.size(); i++ ){
            System.out.println(empresas.get(i).nombre);
        }
        System.out.println("---------------------------");
    }


    //Metodo que recibe el nombre de la empresa y el apellido del empleado (para buscar quien es) ademas del array donde se encuentran todos.
    public static void AnyadirEmpleado (String nameEmpresa, String surnameEmpleado, ArrayList<Empleado> empleados, ArrayList<Empresa> empresas) {


        //Accedemos a otro método dentro de la clase empresa para encontrar la empresa de la cual hemos dicho que queremos introducir a un empleado
        Empresa empresa = seleccionarEmpresa(nameEmpresa, empresas);
        //Accedemos igual a otro método llamado seleccionarEmpleado donde vamos a seleccionar el empleado nuevo.
        //Le pasamos el apellido y el array de empleados
        Empleado empleado = Empleado.seleccionarEmpleado(surnameEmpleado, empleados);

        System.out.println(empleado.apellidos);

        //Seleccionamos el numero donde pertenece la persona en el array
       int i = empleados.indexOf(empleado.apellidos);

       //Añadimos tras comparar que existe tal coincidencia
        if (empleados.contains(empleado.apellidos)) {
            int j = empresas.indexOf(empresa.nombre);
            empresas.get(j).arrayEmpleados.add(empleados.get(i));
            System.out.println("Se ha añadido el empleado " + empleado.apellidos + " a trabajar en " + empresa.nombre);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void informacionEmpresa (Empresa empresa) {
        System.out.println("Esta es la informacion que tenemos de la empresa:");
        System.out.println(empresa.nombre);
        System.out.println(empresa.anyodefundacion);
    }

    public static Empresa seleccionarEmpresa (String nombre, ArrayList<Empresa> empresas) {
        Empresa res = new Empresa();
        for (int i = 0 ; i< empresas.size(); i++) {
            if (empresas.get(i).nombre == nombre) {
                res = empresas.get(i);
            }
        }
        return res;
    }
}



class Empleado {
    String nombre;
    String apellidos;
    String fechanacimiento;
    String fechacontrato;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFechacontrato() {
        return fechacontrato;
    }

    public void setFechacontrato(String fechacontrato) {
        this.fechacontrato = fechacontrato;
    }


    public static void CreaEmpleado(ArrayList<Empleado> empleados,Empleado empleado){

        empleados.add(empleado);
    }

    public static void InfoEmpleado (Empleado empleado) {
        System.out.println("--------------------------------");

        System.out.println(empleado.nombre);
        System.out.println(empleado.apellidos);
        System.out.println(empleado.fechanacimiento);
        System.out.println(empleado.fechacontrato);

        System.out.println("--------------------------------");
    }

    public static void ListadoEmpleados (ArrayList<Empleado> empleados) {
        System.out.println("--------------------------------");
        System.out.println("Listado de empleados:");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i).nombre);
            System.out.println(empleados.get(i).apellidos);
            System.out.println(empleados.get(i).fechanacimiento);
            System.out.println(empleados.get(i).fechacontrato);
            System.out.println();
        }
        System.out.println("--------------------------------");

    }



    public static Empleado seleccionarEmpleado (String nombre, ArrayList<Empleado> empleados) {
        Empleado res = new Empleado();
        for (int i = 0 ; i< empleados.size(); i++) {
            if (empleados.get(i).nombre == nombre) {
                res = empleados.get(i);
            }
        }
        return res;
    }
}


