package webadv.s99201105.p02;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Scanner scanner = new Scanner(new File("password.txt"));
        String username = null, password = null;
        while (scanner.hasNextLine()) {
            username = scanner.next();
            if (!scanner.hasNextLine())
                break;
            password = scanner.next();
            map.put(username,password);
        }
        scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Login: ");
                username = scanner.next();
                if (username == null) {
                    throw new Exception();
                }
                System.out.print("Password: ");
                password = String.valueOf(scanner.next());
                if (map.get(username).equals(App.sha256hex(password)))
                    System.out.println("Login Success");
                else
                    System.out.println("Login Filed");
            } catch (Exception e){

            }
        }
    }
}