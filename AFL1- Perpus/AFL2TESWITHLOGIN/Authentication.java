import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Authentication {
    private HashMap<String, String> credentials;
    private HashMap<String, String> roles;

    public Authentication(String filename) {
        credentials = new HashMap<>();
        roles = new HashMap<>();
        loadCredentials(filename);
    }

    private void loadCredentials(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String role = parts[2].trim();
                    credentials.put(username, password);
                    roles.put(username, role);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + filename);
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        if (credentials.containsKey(username)) {
            String storedPassword = credentials.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    public String getRole(String username) {
        if (roles.containsKey(username)) {
            return roles.get(username);
        }
        return null;
    }
}
