
public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        PhoneSearch search = new PhoneSearch();
//        search.addPhoneNumber("ikachu", "09293042737");
//        search.addPhoneNumber("ikachu", "12345");
//        search.addPhoneNumber("waaat", "4565467");
//        for (String number : search.getPhoneNumbersByPerson("ikachu")) {
//            System.out.println(number);
//        }
//        
//        System.out.println(search.getPersonByPhoneNumber("45"));
//        search.setAddress("ikachu", "luh st", "weh city");
//        
//        System.out.println(search.getPhonebook().get("ikachu").getAddress());
//        search.printAllInformation("ikachu");

        TextUserInterface ui = new TextUserInterface(search);

        ui.start();
    }
}
