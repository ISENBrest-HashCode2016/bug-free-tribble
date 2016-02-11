package fr.isen.hashcode;

import java.util.Vector;

/**
 * Created by pierrezemb on 11/02/2016.
 */
public class Warehouse {

    public Point position;
    public Vector<ProductType> stock; // ProductType IDs

    public Warehouse(Point position, Vector<ProductType> stock) {
        this.position = position;
        this.stock = stock;
    }
}
