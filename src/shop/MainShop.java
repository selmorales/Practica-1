package shop;

import test.TestClothingItem;
import test.TestInventory;

public class MainShop {

		public static void main(String[] args) {
			/*ClothingItem item1 = new ClothingItem("Camisa", 25.99, 'M');
			if (item1 != null) {
			TestClothingItem.checkClass(item1.getClass());
			}*/
			
			
			
			Inventory inventory = new Inventory(100);
			if (inventory != null) {
			TestInventory.checkClass(inventory.getClass());
			}
			
		}
}
