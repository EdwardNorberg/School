package edward.norberg;

public class Account {

    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean check_valid() {
        if(username.contains("@") || password.contains("@"))
            return false;
        return true;
    }
}
