package controllers;

import models.Person;

public class SortingMethods {

     public void sortByNameWithBubble(Person [] persona){
        for (int i = 0; i < persona.length - 1; i++) {
            for (int j = 0; j < persona.length - i - 1; j++) {
                if (persona[j].getName().compareTo(persona[j + 1].getName()) > 0) {
                    Person temp = persona[j];
                    persona[j] = persona[j + 1];
                    persona[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameWithSelectionDes(Person [] persona){
        int n = persona.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (persona[j].getName().compareTo(persona[minIdx].getName()) > 0) {
                    minIdx = j;
                }
            }
            Person temp = persona[minIdx];
            persona[minIdx] = persona[i];
            persona[i] = temp;
        }
    }

    public void sortByAgeWithInsertion(Person[] persona){
        for (int i = 1; i < persona.length; i++) {
            Person temp = persona[i];
            int j = i - 1;
            while (j >= 0 && persona[j].getAge() > temp.getAge()) {
                persona[j + 1] = persona[j];
                j--;
            }
            persona[j + 1] = temp;
        }
    }

    public void sortByNameWithInsertion(Person [] persona){ 
        for (int i = 1; i < persona.length; i++) {
            Person temp = persona[i];
            int j = i - 1;
            while (j >= 0 && persona[j].getName().compareTo(temp.getName()) > 0) {
                persona[j + 1] = persona[j];
                j--;
            }
            persona[j + 1] = temp;
        }
    }    
}
