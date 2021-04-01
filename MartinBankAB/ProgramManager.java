package edward.norberg;

import java.util.ArrayList;

public class ProgramManager {

    AccountManager accountManager = new AccountManager();
    Menue menue = new Menue();
    FileManager fileManager = new FileManager();

    public void run() {
        int selection = 0;
        while(selection != 3) {
            selection = menue.startMenue();
            if(selection == 1) {
                login();
            } else if(selection == 2) {
                register();
            } else if(selection == 3) {
                System.out.println("\nExiting MARTIN BANK AB");
            }
        }
        ArrayList<Account> accounts = accountManager.getAccounts();
        fileManager.write(accounts);
    }

    public void register() {
        Account account = menue.regMenue();
        Boolean is_valid = account.check_valid();
        if(is_valid) {
            Boolean is_added = accountManager.reg(account);
            if (is_added) {
                System.out.println("\nThe account has been created");
            } else {
                System.out.println("\nThe username is already taken");
            }
        } else {
            System.out.println("\n\"@\" is not an allowed character");
        }
    }

    public void login() {
        Account account = menue.loginMenue();
        Boolean exists = accountManager.loginCheck(account);
        if(exists)
            loggedIn(account);
        else
            System.out.println("\nWrong username and/or password");
    }

    public void loggedIn(Account account) {
        int selection = 0;
        while(selection != 1) {
            selection = menue.loggedInMenue(account);
        }
    }
}
