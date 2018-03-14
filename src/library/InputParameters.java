package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class InputParameters {
    private HashMap<String, String> values = new HashMap<>();

    InputParameters(String... parameters) throws IOException {
        for (String a : parameters) {
            System.out.print("Enter " + a + ": ");
            BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
            values.put(a, inputLine.readLine());
        }
    }

    public HashMap<String, String> getValues() {
        return values;
    }
}
