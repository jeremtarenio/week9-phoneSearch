
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jerem
 */
public class TextUserInterface {

    private Scanner reader;
    private PhoneSearch phonebook;

    public TextUserInterface(PhoneSearch phonebook) {
        this.reader = new Scanner(System.in);
        this.phonebook = phonebook;
    }

    public void start() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");

        while (true) {
            System.out.print("command: ");
            String ans = reader.nextLine();
            if (ans.equals("x")) {
                break;
            } else if (ans.equals("1")) {
                System.out.print("whose number: ");
                String name = reader.nextLine();
                System.out.print("number: ");
                String number = reader.nextLine();

                phonebook.addPhoneNumber(name, number);
            } else if (ans.equals("2")) {
                System.out.print("whose number: ");
                String name = reader.nextLine();

                if (phonebook.getPhoneNumbersByPerson(name) != null) {
                    for (String temp : phonebook.getPhoneNumbersByPerson(name)) {
                        System.out.println(" " + temp);
                    }
                } else {
                    System.out.println("  not found");
                }
            } else if (ans.equals("3")) {
                System.out.print("number: ");
                String number = reader.nextLine();

                if (phonebook.getPersonByPhoneNumber(number) != null) {
                    System.out.println(" " + phonebook.getPersonByPhoneNumber(number));
                } else {
                    System.out.println(" not found");
                }
            } else if (ans.equals("4")) {
                System.out.print("whose address: ");
                String name = reader.nextLine();
                System.out.print("street: ");
                String street = reader.nextLine();
                System.out.print("city: ");
                String city = reader.nextLine();

                phonebook.setAddress(name, street, city);
            } else if (ans.equals("5")) {
                System.out.print("whose information: ");
                String name = reader.nextLine();
                if (phonebook.getPhonebook().containsKey(name)) {
                    System.out.print(phonebook.getPhonebook().get(name));
                } else {
                    System.out.println("  not found");
                }
            } else if (ans.equals("6")) {
                System.out.print("whose information: ");
                String name = reader.nextLine();
                phonebook.getPhonebook().remove(name);
            } else if (ans.equals("7")) {
                System.out.print("keyword (if empty, all listed): ");
                String keyword = reader.nextLine();
                boolean existing = false;
                
                List<Person> sortedPeople = new ArrayList<Person>(phonebook.getPhonebook().values()); 
                
                Collections.sort(sortedPeople);
                
                for (Person person : sortedPeople) {
                    //System.out.println(person.toString());
                    if (person.toString().contains(keyword) || person.getName().contains(keyword)) {
                        existing = true;
                        System.out.print(" " + person.getName());
                        System.out.print(person);
                    }
                }

                if (!existing) {
                    System.out.println(" keyword not found");
                }

            }
        }
    }

}
