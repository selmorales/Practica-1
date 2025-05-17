package app;

import shop.*;
import test.*;
import sales.*;
import java.util.Scanner ; 
import java.util.InputMismatchException;

public class Main{
	static Scanner tec = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClothingItem falda = new ClothingItem("Falda", 50.99, 'M');		
		ClothingItem camisa = new ClothingItem("Camisa", 45, 'X');
		ClothingItem pantalon = new ClothingItem("Pantalon", 45, 'S');
		ClothingItem zapatos = new ClothingItem("Zapatos", 45, 'X');

		camisa.setSize('L');
		camisa.setSize('X');



		//System.out.println("///////////PRUEBAS INVENTORY//////////////");
		Inventory inventario1 = new Inventory(10);


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
		SalesRegister.resetTotalSalesCount();
		SalesRegister.resetTotalSalesAmount();

		//TestSalesRegister.checkSalesRegister();

		///////////////PARTE 2///////////////////////////////////////////
		//int inventorySize = 10;
		//Inventory inventario = new Inventory(inventorySize);
		Inventory inventario = inventario1;
		int seleccion = -1;
		System.out.println(falda);
		do {
			System.out.println("\n*** Bienvenido a Strafalarius ***\nSeleccione opción:\n1. Agregar nueva prenda al inventario\n2. Mostrar inventario\n3.Procesar venta\n4. Mostrar estadísticas de ventas\n5. Salir\nSeleccione una opción (1-5)");
			try {
                seleccion = tec.nextInt();  // Intenta leer número
                tec.nextLine();
                opcionesMenu(seleccion, inventario);
               
            } catch (InputMismatchException e) {
                System.out.println("¡Eso no es un número válido!");
                tec.nextLine(); // Limpiar el buffer (muy importante)
            }
			
		} while (seleccion != 5);
		System.out.println("¡Hasta pronto!");
		tec.close();
		
		


	}
	public static void opcionesMenu(int seleccion, Inventory inventario) {
		String name;
		double price;
		char size;
		
		switch (seleccion) {
			case 1:
				System.out.println("Introduce los detalles de la prenda: ");
				System.out.println("Nombre: ");
				name = tec.nextLine();
				name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
			
				System.out.println("Precio: ");
				price = tec.nextDouble();
				tec.nextLine();
				
				System.out.println("Talla (S/M/L): ");
				size = tec.next().charAt(0); //Se lee solo un caracter
				tec.nextLine();
				size = Character.toUpperCase(size);
				
				ClothingItem prenda = new ClothingItem(name, price, size);
				inventario.addItem(prenda);
				
				break;
				
			case 2:
				System.out.println("Inventario => itemLength = " + inventario.getItemLength()+ ", tamaño = "+ inventario.getMAX_SIZE());
				System.out.println(inventario);
				break;
				
			case 3:
				System.out.println("Introduce el nombre de la prenda: ");
				name = tec.nextLine();
				name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
				System.out.println(name);
				
				System.out.println("Introduce la talla de la prenda: (S/M/L)");
				size = tec.next().charAt(0); //Se lee solo un caracter
				tec.nextLine();
				size = Character.toUpperCase(size);
				
				ClothingItem prendaProcesada = SalesRegister.processSale(inventario, name, size);
				break;

			case 4:
				System.out.println(SalesRegister.getBalance());
				break;
			case 5:
				System.out.println("Saliendo del menú...");
				break;
			default: 
				System.out.println("Opción no válida");
		}
	}
}




/* P3, carrito al elegir una prenda, eliminar del inventario aunque no esté confirmado.
 * Si decide eliminar el carrito, se vuelve a meter el artículo al inventario. Lo que haría sería 
 *  crear una lista de reserva.
 *  Agregar nueva prenda: pedir contraseña y si no "no tiene autorización"
 *  array para el inventario, lista enlazada para carrito
 */

