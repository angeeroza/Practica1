package org.example;

import java.util.List;
/*
Class representing a person with a name, age and gender

@author Angela Roza Moreno
 */
public class Person {
    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender){
        if(age<0){
            throw new RuntimeException("Error: la edad debe ser positiva");
        }
        if(name == null || name.equals("")){
            throw new RuntimeException("Error: el nombre no puede ser null ni estar en blanco");
        }
        if(!gender.equals("Female") && !gender.equals("Male")){
            throw new RuntimeException("Error: el genero debe ser male o female");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String name(){
        return name;
    }
    public int age(){
        return age;
    }
    public String gender(){
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     * @param persons persons to compute their age
     * @return the average of the age of the persons in the list
     */
    public static double[] averageAgePerGender(List<Person> persons){
        double[] lista = new double[2];
        int female = 0;
        int men = 0;
        int sumaFemale = 0;
        int sumMen = 0;

        for(Person p : persons){
            if(p.gender.equals("Male")){
                sumMen += p.age;
                men++;
            }else{
                sumaFemale += p.age;
                female++;
            }
        }

        if(men>0){
            lista[0] = sumMen/men;
        }else{
            lista[0] = 0;
        }

        if(female>0){
            lista[1] = sumMen/female;
        }else{
            lista[1] = 0;
        }
        return  lista;
    }
}
