package fr.isen.hashcode;

import java.util.Vector;

/**
 * Created by brendan on 11/02/16.
 */
public class Order {
    public Point destination;
    public Vector<ProductType> list;

    public Order(Point destination, Vector<ProductType> list) {
        this.destination = destination;
        this.list = list;
    }
}
