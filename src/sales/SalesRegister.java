package sales;

import shop.*;

public class SalesRegister { // o static?
	// no existirán instancias de clase
	/*
	 * static significa que cada atributo o método es compartido por todos los
	 * objetos, y se puede usar sin crear un objeto
	 */

	private static long totalSalesCount; // cuantos artiuclos se han vendido
	private static double totalSalesAmount; // para sumar ventas totales

	// GETTERS Y SETTERS
	public static long getTotalSalesCount() {
		return totalSalesCount;
	}

	public static double getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public static ClothingItem processSale(Inventory inventory, String name, char size) {
		// buscar producto en inventario
		// extraer
		// incrementar num articulos vendidos
		// incrementar ventas totales
		ClothingItem itemExtraido = inventory.extractItem(name, size);
		System.out.println(itemExtraido);
		if (itemExtraido != null) {
			totalSalesCount += 1;
			totalSalesAmount += itemExtraido.getPrice(); // 0 name, 1 price, 2 size
			String printy = String.format("Venta procesada: %s (%.2f €)", itemExtraido.getName(),
					itemExtraido.getPrice());
			System.out.println(printy);
		}else {
			System.out.println("Venta no procesada, no se encuentra el item.");
		}
		return itemExtraido;

	}

	public static String getBalance() {
		String printy = String.format("\n%-25s \n-------------------------- \nSalesCount: %10d\nSalesAmount %10.2f €\n",
				"BALANCE", totalSalesCount, totalSalesAmount);
		System.out.println(printy);
		return printy; //pensar si quitar el return
	}

	public static void resetTotalSalesCount() {
		totalSalesCount = 0;
	}

	public static void resetTotalSalesAmount() {
		totalSalesAmount = 0;
	}

}
