package fr.isen.hashcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by pierrezemb on 11/02/2016.
 */
public class MyParser {

    public int maximumLoad;
    public int deadline;
    public int row;
    public int column;
    public int nbrDrones;
    public String[] productType;
    public String[] productWeigh;
    public Warehouse[] warehouses;

    public MyParser() {
        String[] splited;

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/pierrezemb/Downloads/busy_day.in"))) {

            String line = br.readLine();

            // First line
            splited = line.split("\\s+");
            this.row = Integer.parseInt(splited[0]);
            this.column = Integer.parseInt(splited[1]);
            this.nbrDrones = Integer.parseInt(splited[2]);
            this.deadline = Integer.parseInt(splited[3]);
            this.maximumLoad = Integer.parseInt(splited[4]);

            // Second line
            line = br.readLine();
            this.productType = line.split("\\s+");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}