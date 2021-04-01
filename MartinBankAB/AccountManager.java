package edward.norberg;

import java.util.ArrayList;

public class AccountManager {

    ArrayList<Account> accounts = new ArrayList<>();

    public AccountManager() {
        FileManager fileManager = new FileManager();
        this.accounts = fileManager.read();
    }

    public boolean reg(Account account) {
        for(Account acc: accounts) {
            if(acc.getUsername().equals(account.getUsername()))
                return false;
        }
        accounts.add(account);
        return true;
    }

    public boolean loginCheck(Account account) {
        for(Account acc: accounts) {
            if(acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword()))
                return true;
        }
        return false;
    }

    public ArrayList<Account> getAccounts () {
        return accounts;
    }
}
