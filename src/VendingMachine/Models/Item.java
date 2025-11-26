package VendingMachine.Models;

import java.util.HashMap;

public class Item {
    private int code;
    private String name;
    private int price;

    public Item(int code, String name, int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
