package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;

public class Request {
    //query to create table
    //create table book (id int primary key auto_increment, ISBN varchar(13) not null, added date not null, author varchar(255), title varchar(255), amount int not null check (amount >=0))

    private static String addBookLine = "insert into BOOK(ISBN,AUTHOR,TITLE,ADDED,AMOUNT) values(?,?,?,now(),?)";

    private static String selectBooksLine = "Select * from BOOK order by ";

    private static String updateAmountLine = "update BOOK set AMOUNT=? where ISBN=?";

    public static void addBook(Connection connection) {
        try {
            InputParameters inputParameters = new InputParameters("ISBN", "AUTHOR", "TITLE", "AMOUNT");
            HashMap<String, String> parameters = inputParameters.getValues();

            PreparedStatement statement;
            statement = connection.prepareStatement(addBookLine);
            statement.setString(1, parameters.get("ISBN"));
            statement.setString(2, parameters.get("AUTHOR"));
            statement.setString(3, parameters.get("TITLE"));
            statement.setInt(4, Integer.parseInt(parameters.get("AMOUNT")));
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Can't add book");
        } catch (NumberFormatException e) {
            System.out.println("Wrong type parameter");
        } catch (IOException e) {
            System.out.println("Wrong input parameter");
        }
    }

    public static void getBooks(Connection connection) {
        try {
            Statement statement;
            ResultSet resultSet;
            statement = connection.createStatement();
            BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Sort by: 1) ISBN. 2) Added date. 3) Author. 4) Title. 5) Amount.");

            int choice = 0;
            try {
                choice = Integer.parseInt(inputLine.readLine());
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    resultSet = statement.executeQuery(selectBooksLine + "ISBN");
                    break;
                case 2:
                    resultSet = statement.executeQuery(selectBooksLine + "ADDED");
                    break;
                case 3:
                    resultSet = statement.executeQuery(selectBooksLine + "AUTHOR");
                    break;
                case 4:
                    resultSet = statement.executeQuery(selectBooksLine + "TITLE");
                    break;
                case 5:
                    resultSet = statement.executeQuery(selectBooksLine + "AMOUNT");
                    break;
                default:
                    resultSet = statement.executeQuery(selectBooksLine + "ID");
                    break;
            }
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID") + "   " +
                        resultSet.getString("ISBN") + "   " +
                        resultSet.getString("ADDED") + "   " +
                        resultSet.getString("AUTHOR") + "   " +
                        resultSet.getString("TITLE") + "   " +
                        resultSet.getInt("AMOUNT") + "   ");
            }

        } catch (SQLException e) {
            System.out.println("Can't get books");
        } catch (NumberFormatException e) {
            System.out.println("Wrong type parameter");
        }
    }

    public static void changeBookAmount(Connection connection) {
        try {
            InputParameters inputParameters = new InputParameters("AMOUNT", "ISBN");
            HashMap<String, String> parameters = inputParameters.getValues();

            PreparedStatement statement;
            statement = connection.prepareStatement(updateAmountLine);
            statement.setInt(1, Integer.parseInt(parameters.get("AMOUNT")));
            statement.setString(2, parameters.get("ISBN"));
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Can't update book");
        } catch (NumberFormatException e) {
            System.out.println("Wrong type parameter");
        } catch (IOException e) {
            System.out.println("Wrong input parameter");
        }
    }

}
