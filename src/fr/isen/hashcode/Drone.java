package fr.isen.hashcode;

import java.util.Vector;

/**
 * Created by pierrezemb on 11/02/2016.
 */
public class Drone {

    public Point position;
    // ProductTypeID, inventory
    public Vector<Integer> inventory;
    public Boolean isAvailable;

    public Drone(Point position, Vector<Integer> inventory, Boolean isAvailable) {
        this.position = position;
        this.inventory = inventory;
        this.isAvailable = isAvailable;
    }

    public int getWeigh(Context context){
        int weight = 0;
        for(int i = 0; i < inventory.size(); i++){
            int id = inventory.elementAt(i);
            ProductType element = context.productTypes[id];
            weight += element.weight;
        }
        return weight;
    }

    public int load(int ProdType, int qty, Point provider){
        for(int i = 0; i < qty; i++) {
            inventory.addElement(ProdType);
        }
        position = provider;
        return (int)Math.sqrt(Math.pow(this.position.x - provider.x, 2)+Math.pow(this.position.y - provider.y, 2)) + 1;
    }

    public int deliver(int ProdType, int qty, Point destination, Context context){
        if(this.position.equals(destination)) {
            for(int i = 0; i < qty; i++) {
                for(int j = 0; j < inventory.size(); j++) {
                    int id = inventory.elementAt(j);
                    if(ProdType == id) {
                        inventory.removeElementAt(j);
                        break;
                    }
                }
            }
            position = destination;
            return (int)Math.floor(Math.sqrt(Math.pow(this.position.x - destination.x, 2)+Math.pow(this.position.y - destination.y, 2))) + 1;
        }
        return 0;
    }

    public int wait(int turns){
        return turns;
    }

    public int unload(int ProdType, int qty, Point destination){
        for(int i = 0; i < qty; i++) {
            for(int j = 0; j < inventory.size(); j++) {
                if(ProdType == inventory.elementAt(j)) {
                    inventory.removeElementAt(j);
                    break;
                }
            }
        }
        return 0;
    }


}
