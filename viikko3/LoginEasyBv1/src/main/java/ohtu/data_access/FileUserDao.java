
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

public class FileUserDao implements UserDao{
    
    private File tiedosto;

    public FileUserDao(String tiedostoPolku) {
        this.tiedosto = new File(tiedostoPolku);
    }
    
    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parsed = line.split(";");
            users.add(new User(parsed[0], parsed[1]));
        }
        return users;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        List<User> users = listAll();
        users.add(user);
        StringBuilder strb = new StringBuilder();
        users.stream().forEach((u) -> {
            strb.append(u.getUsername()).append(";").append(u.getPassword()).append("\n");
        });
        
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(tiedosto, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        pw.write(strb.toString());
        pw.close();
    }
    
}
