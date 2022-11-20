import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Person> queue = new LinkedList<>();
        List<Person> people = generateClient();
        for (Person person : people) {
            queue.offer(person);
        }
        while (!queue.isEmpty()) {
            Person person = queue.poll();
            System.out.println("Посетитель " + person.getName() + " на атракционе");
            person.giveTickets();

            if (person.hasMoreTickets()) {
                queue.offer(person);
            }

        }


    }

    public static List<Person> generateClient() {
        List<Person> visitor = new LinkedList<>();
        visitor.add(new Person("Томас", "Петров", 2));
        visitor.add(new Person("Саня", "Старшов", 3));
        visitor.add(new Person("Филипп", "Маркович", 4));
        visitor.add(new Person("Коля", "Иванов", 1));

        return visitor;
    }
}


class Person {
    private String name;
    private String surname;
    private int tickets;

    public Person(String name, String surname, int tickets) {

        this.name = name;
        this.surname = surname;
        this.tickets = tickets;
    }

    public void giveTickets() {
        tickets--;
    }

    public boolean hasMoreTickets() {
        return tickets > 0;

    }

    public String getName() {
        return name;
    }

    public int getTickets() {
        return tickets;
    }

    public String getSurname() {
        return surname;
    }

    public String toString() {
        return String.valueOf(name);
    }

}

