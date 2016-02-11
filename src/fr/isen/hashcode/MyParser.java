package fr.isen.hashcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Created by pierrezemb on 11/02/2016.
 */
public class MyParser {

    public int nbrTypeProducts;
    public int nrbWarehouse;
    public int maximumLoad;
    public int deadline;
    public int row;
    public int column;
    public int nbrDrones;
    public String[] productTypes;
    public String[] productWeigh;
    public Warehouse[] warehouses;
    public int nbrOrder;

    public MyParser() {
        String[] splited;

        try (BufferedReader br = new BufferedReader(new FileReader("res/busy_day.in"))) {

            String line = br.readLine();
            System.out.println("1="+line);

            // First line
            splited = line.split("\\s+");
            this.row = Integer.parseInt(splited[0]);
            this.column = Integer.parseInt(splited[1]);
            this.nbrDrones = Integer.parseInt(splited[2]);
            this.deadline = Integer.parseInt(splited[3]);
            this.maximumLoad = Integer.parseInt(splited[4]);

            // Second line
            line = br.readLine();
            System.out.println("2="+line);
            this.nbrTypeProducts = Integer.parseInt(line);

            // Third line
            line = br.readLine();
            System.out.println("3="+line);
            this.productWeigh = line.split("\\s+");

            // Fourth line, moving to warehouses

            line = br.readLine();
            System.out.println("4="+line);
            splited = line.split("\\s+");
            this.nrbWarehouse = Integer.parseInt(splited[0]);

            warehouses = new Warehouse[this.nrbWarehouse];

            for (int i = 0; i< this.nrbWarehouse; i++){
                line = br.readLine();
                splited = line.split("\\s+");
                Vector<Integer> stock = new Vector<Integer>();
                
                Point point = new Point(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]));

                // moving to content of warehouse
                line = br.readLine();
                splited = line.split("\\s+");
                for (int j = 0; j < this.nbrTypeProducts; j++) {
                    stock.add(j, Integer.parseInt(splited[j]));
                }
                warehouses[i] = new Warehouse(point,stock);
            }

            // Moving to order
            line = br.readLine();
            this.nbrOrder = Integer.parseInt(line);
            // for (int i = 0; i< this.nbrOrder; i++){
            for (int i = 0; i<1; i++){

                // destination
                line = br.readLine();
                splited = line.split("\\s+");
                Point point = new Point(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]));

                // Number of product
                line = br.readLine();
                int nbrProductPerOrder = Integer.parseInt(line);

                Vector<Integer> products = new Vector<Integer>();
                line = br.readLine();
                splited = line.split("\\s+");
                for (int j = 0; j < nbrProductPerOrder; j++) {
                    products.add(j, Integer.parseInt(splited[j]));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
