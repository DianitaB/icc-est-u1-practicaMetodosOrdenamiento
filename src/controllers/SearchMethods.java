package controllers;

import models.Person;

public class SearchMethods {

    public Person binarySearchByAge(Person[] persona, int age){
        int izquierda = 0;
        int derecha = persona.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (persona[medio].getAge()== age) {
                return persona[medio];
            }
            if (persona[medio].getAge() < age) {
                izquierda = medio + 1;

            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person [] persona, String name){
        int izquierda = 0;
        int derecha = persona.length -1;

        while(izquierda <= derecha){
            int medio = (izquierda + derecha) / 2;
            int compar = persona[medio].getName().compareTo(name);

            if(compar == 0)
            return persona[medio];

            if(compar < 0)
                izquierda = medio + 1 ;
            else    
                derecha = medio - 1 ;

        }
        return null;
    }
    
    public boolean isSortedByAge(Person [] persona){
         for (int i = 0; i < persona.length - 1; i++)
            if (persona[i].getAge() > persona[i + 1].getAge())
                return false;
        return true;
    }

    public boolean isSortedByName(Person[] persona){
          for (int i = 0; i < persona.length - 1; i++)
            if (persona[i].getName().compareTo(persona[i + 1].getName()) > 0)
                return false;
        return true;
    }
}
