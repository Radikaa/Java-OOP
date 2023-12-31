package Encapsulation_SalaryIncrease;

import Encapsulation_SalaryIncrease.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < countOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        double bonus = Double.parseDouble(scanner.nextLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}