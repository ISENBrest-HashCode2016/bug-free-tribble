package fr.isen.hashcode;

import java.util.Vector;

/**
 * Created by brendan on 11/02/16.
 */
public class ProductType {
    public int weight;
    public Vector<Integer> providers; // Warehouse IDs

    public ProductType(int weight, Vector<Integer> providers) {
        this.weight = weight;
        this.providers = providers;
    }
}
