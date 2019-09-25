package PawInc.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {

    public InputParser() {}

    public ArrayList<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split(" ")));
    }
}
