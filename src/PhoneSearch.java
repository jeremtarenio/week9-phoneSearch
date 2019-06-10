
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class PhoneSearch {

    private Map<String, Person> phonebook;

    public PhoneSearch() {
        phonebook = new HashMap<String, Person>();
    }

    public void addPhoneNumber(String name, String phoneNumber) {
        if (!phonebook.containsKey(name)) {
            Person person = new Person(name);
            person.addPhoneNumber(phoneNumber);
            phonebook.put(name, person);
        } else {
            phonebook.get(name).addPhoneNumber(phoneNumber);
        }
    }

    public Set<String> getPhoneNumbersByPerson(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name).getPhoneNumbers();
        }

        return null;
    }

    public String getPersonByPhoneNumber(String number) {
        for (Person person : phonebook.values()) {
            for (String phoneNumber : person.getPhoneNumbers()) {
                if (phoneNumber.equals(number)) {
                    return person.getName();
                }
            }
        }

        return null;
    }

    public void setAddress(String name, String street, String city) {
        if (!phonebook.containsKey(name)) {
            Person person = new Person(name);
            person.setAddress(street, city);
            phonebook.put(name, person);
        } else {
            phonebook.get(name).setAddress(street, city);
        }

    }

    public Address getAddress(String name) {
        for (Person person : phonebook.values()) {
            if (person.getName().equals(name)) {
                return person.getAddress();
            }
        }

        return null;
    }

    public Map<String, Person> getPhonebook() {
        return phonebook;
    }

}
