import model.Person;
import utils.FileUtils;
import utils.JWTUtils;

public class Main {

    private static final String fileRoute = "raw/key.txt";
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Person person = new Person("Gabriel", "García", null);
        System.out.println("Person Before Encrypting");
        System.out.println(person.toString());
        String token = JWTUtils.encryptInformation(person.getName() + " " + person.getSurname(), fileRoute);
        person.setToken(token);
        System.out.println("Person After Encrypting");
        System.out.println(person.toString());
        String userInfo = JWTUtils.decryptInformation(person.getToken(), fileRoute);
        System.out.println("User Information Retrieved " + userInfo);



    }
}
