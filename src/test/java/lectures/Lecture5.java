package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();

        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getPrice() < 50000)
                .collect(Collectors.toList());

        filteredCars.forEach(System.out::println);
        System.out.println(filteredCars.size());

    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                //.map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .map(PersonDTO::map)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
        assertThat(dtos).hasSize(people.size());

    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        ImmutableList<Car> cars = MockData.getCars();


        double averageValue = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(String.format("Average price is: %,.2f", averageValue));

    }

    @Test
    public void test() throws Exception {

    }
}



