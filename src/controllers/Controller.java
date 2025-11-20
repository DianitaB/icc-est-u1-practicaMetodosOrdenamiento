package controllers;

import models.Person;
import views.View;

public class Controller{
    private View view;
    private Person[] persons = new Person[0];
    private SortingMethods sortingMethods;
    private SearchMethods  searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    public void start(){
        int opcion;
        do{
            opcion = view.showMenu();
            switch (opcion) {
                case 1:
                inputPersons();
                break;
                case 2:
                view.displayPersons(persons);
                break;
                case 3: 
                sortPersons();
                break;
                case 4:
                searchPerson();
                break;
                case 5: 
                System.out.println("Saliendoooo, Chaooo");
                default:
                    break;
            }
        } while (opcion != 5);
    }

    public void inputPersons() {
    int cantidad;
    while (true) {
        System.out.println("¿Cuántas personas desea ingresar?");
        cantidad = view.inputAge();

        if (cantidad <= 0) {
            System.out.println("Error: Debe ingresar un número mayor que 0. Intente nuevamente.");
        } else {
            break; 
        }
    }
    for (int i = 0; i < cantidad; i++) {
        System.out.println("Persona: " + (i + 1));
        addPersons();
    }
}

   public void addPersons() {
    System.out.println("Ingrese los datos de la persona:");

    Person persona = view.inputPerson();

    if (persona == null) {
        System.out.println("No se pudo agregar la persona. Entrada inválida.");
        return;
    }

    System.out.println("Agregando persona...");

    Person[] nuevo = new Person[persons.length + 1];

    for (int i = 0; i < persons.length; i++) {
        nuevo[i] = persons[i];
    }

    nuevo[nuevo.length - 1] = persona;
    persons = nuevo;

    System.out.println("Persona agregada correctamente.");
    System.out.println("Total de personas registradas: " + persons.length);
}


   public void sortPersons() {

    if (persons == null || persons.length == 0) {
        System.out.println("No hay personas registradas. Agregue personas antes de ordenar.");
        return;
    }

    int method = view.selectSortingMethod();

    switch (method) {
        case 1:
            sortingMethods.sortByNameWithBubble(persons);
            System.out.println("Ordenando por nombre - Burbuja");
            break;

        case 2:
            sortingMethods.sortByNameWithSelectionDes(persons);
            System.out.println("Ordenando por nombre descendente - Selección");
            break;

        case 3:
            sortingMethods.sortByAgeWithInsertion(persons);
            System.out.println("Ordenando por edad - Inserción");
            break;

        case 4:
            sortingMethods.sortByNameWithInsertion(persons);
            System.out.println("Ordenando por nombre - Inserción");
            break;

        default:
            System.out.println("Método inválido.");
            return;
    }

    System.out.println("Personas ordenadas correctamente.\n");
    view.displayPersons(persons);
}


    public void searchPerson() {

    if (persons == null || persons.length == 0) {
        System.out.println("No hay personas registradas. Agregue personas antes de buscar.");
        return;
    }

    int criterio = view.selectSearchCriterion();
    Person resultado = null;

    switch (criterio) {

        case 1: 
            if (!searchMethods.isSortedByName(persons)) {
                System.out.println("Primero debe ordenar por nombre antes de realizar la búsqueda.");
                return;
            }
            String nombre = view.inputName();
            System.out.println("Buscando por nombre :) ");
            resultado = searchMethods.binarySearchByName(persons, nombre);
            break;

        case 2:
            if (!searchMethods.isSortedByAge(persons)) {
                System.out.println("Primero debe ordenar por edad antes de realizar la búsqueda.");
                return;
            }
            int edad = view.inputAge();
            System.out.println("Buscando por edad :)");
            resultado = searchMethods.binarySearchByAge(persons, edad);
            break;

        default:
            System.out.println("Criterio inválido.");
            return;
    }
    view.displaySearchResult(resultado);
    }

}