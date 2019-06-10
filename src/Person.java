
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jerem
 */
public class Person implements Comparable<Person> {

    private String name;
    private Set<String> phoneNumbers;
    private Address address;

    public Person(String name) {
        this.name = name;
        phoneNumbers = new HashSet<String>();
        address = null;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void setAddress(String street, String city) {
        address = new Address(street, city);
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String profile = "";

        if (address != null) {
            profile += "\n  address: " + address.getWholeAddress() + "\n";
        } else {
            profile += "  address unknown\n";
        }

        if (!phoneNumbers.isEmpty()) {
            profile += "  phone numbers:\n";
            for (String number : phoneNumbers) {
                profile += "   " + number + "\n";
            }
        } else {
            profile += "  phone number not found\n";
        }

        return profile;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());

    }

}
