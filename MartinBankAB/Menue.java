package edward.norberg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menue {

    private class Input {

        public int getInt() {
            Scanner keyboard = new Scanner(System.in);
            try {
                int nextint = keyboard.nextInt();
                return nextint;
            } catch (InputMismatchException Exc) {
                return 0;
            }
        }

        public String getString(){
            Scanner keyboard = new Scanner(System.in);
            String nextString = keyboard.nextLine();
            return nextString;
        }
    }

    public int startMenue() {
        System.out.println("\n       MARTIN BANK AB. \n " +
                           "1: login, 2: register, 3: exit");
        System.out.print("\nWrite a valid number: ");
        Input input = new Input();
        return input.getInt();
    }

    public Account regMenue() {
        System.out.print("Select a username: ");
        Input input = new Input();
        String username = input.getString();
        System.out.print("Select a password: ");
        String password = input.getString();
        return new Account(username, password);
    }

    public Account loginMenue() {
        System.out.print("Provide a username: ");
        Input input = new Input();
        String username = input.getString();
        System.out.print("Provide a password: ");
        String password = input.getString();
        return new Account(username, password);
    }

    public int loggedInMenue(Account account) {
        String username = account.getUsername();
        System.out.println("\nLogged In as: " + username +
                "\nbank saldo: unknown\n    1: log out");
        System.out.print("\nWrite a valid number: ");
        Input input = new Input();
        return input.getInt();
    }
}
