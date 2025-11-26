package VendingMachine.Models;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer,Item> items = new HashMap<>();
    private Map<Integer, Integer> quantities = new HashMap<>();

    public Inventory() {
        addNewItem(new Item(1, "Coke", 20), 10);
        addNewItem(new Item(2, "Pepsi", 25), 5);
        addNewItem(new Item(3, "Chips", 15), 8);
    }

    public void addNewItem(Item item, int quantity) {
        items.put(item.getCode(), item);
        quantities.put(item.getCode(), quantity);
    }

    public boolean isAvailable(int code) {
        return quantities.containsKey(code) && quantities.get(code) > 0;
    }

    public int getPrice(int code) {
        return items.get(code).getPrice();
    }

    public Item getItem(int code) {
        return items.get(code);
    }

    public void reduceStock(int code) {
        quantities.put(code, quantities.get(code) - 1);
    }

}
