package VendingMachine.Models;


import java.net.CacheResponse;

public class VendingMachine {
   private Inventory inventory;
   private double amount;
   private int selectItem;

   public VendingMachine(Inventory inventory){
      this.inventory = inventory;
   }

   public Item insertCoin(int amount, int code){

      // First check if the item is currently available or not
      if(!inventory.isAvailable(code)){
         System.out.println("Item out of Stock");
         return null;
      }

      // If the item is available, then get the price
      int price = inventory.getPrice(code);


      // check if the amount is sufficient or not
      // if not sufficient ask remaining amount or refund it.
      if(amount < price){
         System.out.println("Amount is not sufficient for this item");
         System.out.println("inset : " + (price-amount));
         return null;
      }

      // if the amount more than the item price
      // then give change
      if(amount>price){
         int change = amount-price;
         System.out.println(inventory.getItem(code).getName());
         System.out.println("Here is your change "+ change);
      }
      // if amount is sufficient get the item and return it
      Item item = inventory.getItem(code);
      if(amount == price)
      System.out.println("Received : " + inventory.getItem(code).getName());
      inventory.reduceStock(code);
      return item;
   }
}
