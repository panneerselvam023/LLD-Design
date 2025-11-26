package VendingMachine;

import VendingMachine.Models.Inventory;
import VendingMachine.Models.VendingMachine;

public class User {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        VendingMachine  machine = new VendingMachine(inventory);
        machine.insertCoin(20,2);

    }
}
