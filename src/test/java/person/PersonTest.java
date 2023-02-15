package person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    /**
     * Casos de test:
     *
     * - Edad no valida.
     * - Genero no valido.
     * - Nombre en blanco o nulo.
     * - Lista con solo una persona que sea mujer.
     * - Lista con solo una persona que sea hombre.
     * - Lista con dos personas, una hombre y otra mujer.
     * - Lista con varias personas de cada.
     */

    Person persona1;
    Person persona2;
    Person persona3;
    Person persona4;
    List<Person> persons;

    @BeforeEach
    void setUp(){

        persona1 = new Person("Angela",20,"Female");
        persona2 = new Person("Pepe",86,"Male");
        persona3 = new Person("Pablo",34,"Male");
        persona4 = new Person("Lucia",8,"Female");
    }

    @AfterEach
    void shutDown(){
        persona1 = null;
        persona2 = null;
        persona3 = null;
        persona4 = null;
        persons = null;
    }

    @Test
    void listaSoloUnaMujer(){
        List<Person> persons = new ArrayList<Person>();
        persons.add(persona1);
        assertEquals(0,Person.averageAgePerGender(persons)[0]);
        assertEquals(20,Person.averageAgePerGender(persons)[1]);

    }

    @Test
    void listaSoloUnHombre(){
        List<Person> persons = new ArrayList<Person>();
        persons.add(persona2);
        assertEquals(86,Person.averageAgePerGender(persons)[0]);
        assertEquals(0,Person.averageAgePerGender(persons)[1]);

    }

    @Test
    void listaUnHombreUnaMujer(){
        List<Person> persons = new ArrayList<Person>();
        persons.add(persona1);
        persons.add(persona2);
        assertEquals(86,Person.averageAgePerGender(persons)[0]);
        assertEquals(20,Person.averageAgePerGender(persons)[1]);
    }

    @Test
    void listaVarios(){
        List<Person> persons = new ArrayList<Person>();
        persons.add(persona1);
        persons.add(persona2);
        persons.add(persona3);
        persons.add(persona4);
        assertEquals(60,Person.averageAgePerGender(persons)[0]);
        assertEquals(14,Person.averageAgePerGender(persons)[1]);
    }

    @Test
    void constructorEdadNegativa(){

        assertThrows(RuntimeException.class,() -> new Person("Angela",-1,"Female"));
    }

    @Test
    void constructorGeneroErroneo(){

        assertThrows(RuntimeException.class,() -> new Person("Angela",20,"none"));
    }

    @Test
    void constructorNombreVacio(){

        assertThrows(RuntimeException.class,() -> new Person("",20,"Male"));
    }

    @Test
    void constructorNombreNulo(){

        assertThrows(RuntimeException.class,() -> new Person(null,-1,"none"));
    }

}