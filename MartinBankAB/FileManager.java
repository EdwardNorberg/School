package edward.norberg;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public ArrayList<Account> read(){
        ArrayList<Account> arrayList = new ArrayList<>();
        try {
            File file = new File(getPathToTxtFilesFolder());
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()) {
                String line = br.readLine();
                String[] split = line.split("@");
                Account account = new Account(split[0], split[1]);
                arrayList.add(account);
            }
        } catch(FileNotFoundException e1) {
            System.out.println("\nFirst time program execution, text file will be created upon termination\n");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public void write(ArrayList<Account> accounts) {
        String toSend = "";
        for(Account x : accounts){
            toSend = toSend + x.getUsername() + "@" + x.getPassword() + "\n";
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(getPathToTxtFilesFolder())));
            writer.write(toSend);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPathToTxtFilesFolder() {
        String standardPath = System.getProperty("user.dir");
        String relativePath = "\\database.txt"; //unsure how this will work on other operating systems than windows.
        String completePath = standardPath + relativePath;
        return completePath;
    }


}
