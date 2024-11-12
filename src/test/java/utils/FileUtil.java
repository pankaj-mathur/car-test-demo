package utils;

import models.Vehicle;
import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Utility class for reading and processing files related to vehicle data.
 * Provides methods to read and extract vehicle registration numbers and 
 * vehicle details from specified file paths.
 */
public class FileUtil {

    /**
     * Reads the specified input file and extracts vehicle registration numbers
     * based on a predefined pattern. The extracted registration numbers are stored
     * in a list.
     *
     * @param filePath the path to the input file containing registration numbers
     * @return a list of registration numbers extracted from the input file
     * @throws IOException if an error occurs while reading the file
     */
    public static List<String> readInputFile(String filePath) throws IOException {
        List<String> registrations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("\\b[A-Z]{2}\\d{2}\\s?[A-Z]{3}\\b"); // Registration Pattern
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    registrations.add(matcher.group().replace(" ", ""));
                }
            }
        }
        return registrations;
    }

    /**
     * Reads the specified output file and maps vehicle registration numbers
     * to their corresponding vehicle details. Each line in the file represents
     * a vehicle's data, split by commas.
     *
     * @param filePath the path to the output file containing vehicle data
     * @return a map of registration numbers to Vehicle objects created from the output file data
     * @throws IOException if an error occurs while reading the file
     */
    public static Map<String, Vehicle> readOutputFile(String filePath) throws IOException {
        Map<String, Vehicle> vehicles = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                vehicles.put(parts[0], new Vehicle(parts[0], parts[1], parts[2], parts[3]));
            }
        }
        return vehicles;
    }
}
