package views;
import java.util.Scanner;

import models.Person;

public class View {

    private Scanner scanner;

    public View (){
        System.out.println("Métodos de Ordenamiento: ");
        System.out.println();
        scanner = new Scanner(System.in);
    }
       public int showMenu() {
        System.out.println("Estudiante : Diana Borja");
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Ordenar personas");
        System.out.println("4. Buscar persona");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.println("\n--- Ingresar Persona ---");
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("\n=== Métodos de Ordenamiento ===");
        System.out.println("1. Burbuja por nombre - Ascendente");
        System.out.println("2. Selección por nombre - Descendente");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion (){
        System.out.println("\n=== Criterio de Búsqueda ===");
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por edad");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person [] persona){
        System.out.println("\n===== LISTA DE PERSONAS =====");

        if (persona.length == 0) {
            System.out.println("No hay personas registradas.");
            return;
        }
        for (Person personas : persona) {
            System.out.println("Nombre: " + personas.getName() + " - Edad: " + personas.getAge());
        }
        

    }

    public void displaySearchResult(Person persona){
          System.out.println("\n===== RESULTADO DE BÚSQUEDA =====");

        if (persona == null) {
            System.out.println("La persona NO fue encontrada.");
        } else {
            System.out.println("Persona encontrada:");
            System.out.println("Nombre: " + persona.getName());
            System.out.println("Edad: " + persona.getAge());
        }

    }

    public int inputAge(){
        System.out.print("Ingrese edad: ");
        return scanner.nextInt();
    }

    public String inputName(){
        System.out.print("Ingrese nombre: ");
        scanner.nextLine(); 
        return scanner.nextLine();
    }
}
