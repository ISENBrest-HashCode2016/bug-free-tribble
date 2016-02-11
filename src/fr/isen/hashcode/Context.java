package fr.isen.hashcode;

/**
 * Created by crom on 11/02/16.
 */
public class Context {
    public ProductType[] productTypes;
    public Warehouse[] warehouses;
    public Order[] orders;
    public Drone[] drones;


    public Context(Context ctx){
        productTypes = productTypes.clone();
        warehouses = warehouses.clone();
        orders = orders.clone();
        drones = drones.clone();
    }
}
