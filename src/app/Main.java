package app;

import shop.*;
import test.*;
import sales.*;
//import java.util.Scanner ; 

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClothingItem falda = new ClothingItem("Falda", 50.99, 'M');		
		ClothingItem camisa = new ClothingItem("Camisa", 45, 'X');
		ClothingItem pantalon = new ClothingItem("Pantalon", 45, 'S');
		ClothingItem zapatos = new ClothingItem("Zapatos", 45, 'X');
	
		camisa.setSize('L');
		camisa.setSize('X');
	
		
		
		//System.out.println("///////////PRUEBAS INVENTORY//////////////");
		Inventory inventario1 = new Inventory(5);
		
		
		//System.out.println("getItemCount :" + inventario1.getItemCount());
		inventario1.addItem(pantalon);
		//System.out.println("getItemCount :" +inventario1.getItemCount());
		inventario1.addItem(camisa);
		//System.out.println(inventario1);
		//System.out.println("getItemCount :" +inventario1.getItemCount());
		inventario1.addItem(falda);
		inventario1.addItem(camisa);
		inventario1.addItem(pantalon);
		//System.out.println("\n" + inventario1);
		
		inventario1.addItem(zapatos);
		//System.out.println("///////////FIN PRUEBAS INVENTORY//////////////");
		
		/* 	///////////PRUEBA CAMBIO MAX_SIZE
		System.out.println("checkStock");
		int contador = inventario1.checkStock("Pantalon", 'S');
		System.out.println(contador);
		
		
		System.out.println("\ntamaño items: " + inventario1.getMAX_SIZE() +" getItemcount: " + inventario1.getItemCount() );
		System.out.println( inventario1 + "\n" );
		
		inventario1.setMAX_SIZE(6);
		System.out.println("\ntamaño items: " + inventario1.getMAX_SIZE() +" getItemcount: " + inventario1.getItemCount() );
		System.out.println(inventario1);
		*/
	

	///////////PRUEBAS REMOVE////////////////////////7
		//System.out.println("///////////PRUEBAS REMOVE//////////////////");
		//inventario1.removeItem("Pantalon", 'S');
		//System.out.println(inventario1);
		
		//System.out.println(inventario1);
		inventario1.removeItem("Falda", 'S');
		
		ClothingItem itemExtraido = inventario1.extractItem("Pantalon", 'S');
		System.out.println(inventario1);
		//System.out.println(itemExtraido);
		//System.out.println("///////////FIN PRUEBAS REMOVE//////////////////");
////////////////////////////////////////////////////////////////////////		
		
		
///////////PRUEBAS SALES//////////////////
		ClothingItem item1 = SalesRegister.processSale(inventario1, "Pantalon", 'S');
		ClothingItem item2 = SalesRegister.processSale(inventario1, "Camisa", 'L');
		
		//System.out.println(ClothingItem.ver(item1));
		//System.out.println(item2);
		
		System.out.println(SalesRegister.getBalance());
		
		TestSalesRegister.checkSalesRegister();
		
		
	}
}





/* P3, carrito al elegir una prenda, eliminar del inventario aunque no esté confirmado.
 * Si decide eliminar el carrito, se vuelve a meter el artículo al inventario. Lo que haría sería 
 *  crear una lista de reserva.
 *  Agregar nueva prenda: pedir contraseña y si no "no tiene autorización"
 *  array para el inventario, lista enlazada para carrito
 */

