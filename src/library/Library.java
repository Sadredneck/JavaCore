package library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Library {

    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "JAVA", "");

            BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Menu:");
                System.out.println("1) Add book.");
                System.out.println("2) Get books.");
                System.out.println("3) Change book amount.");
                System.out.println("4) Exit.");

                int choice;
                try {
                    choice = Integer.parseInt(inputLine.readLine());
                } catch (Exception e) {
                    choice = 0;
                }
                switch (choice) {
                    case 1:
                        Request.addBook(conn);
                        break;
                    case 2:
                        Request.getBooks(conn);
                        break;
                    case 3:
                        Request.changeBookAmount(conn);
                        break;
                    case 4:
                        conn.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Type 1, 2, 3 or 4 mate.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
