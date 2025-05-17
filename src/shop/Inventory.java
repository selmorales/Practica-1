package shop;
import java.util.Arrays;

public class Inventory {
	private ClothingItem[] items;
	private int itemLength;
	private int MAX_SIZE;


	//Constructor
	public Inventory(int MAX_SIZE) {
		this.MAX_SIZE = MAX_SIZE;
		this.items = new ClothingItem[MAX_SIZE];
		this.itemLength = 0; // = 0
	}

	//GETTERS Y SETTERS
	public int getMAX_SIZE() {
		return this.MAX_SIZE;
	}
	public void setMAX_SIZE(int nuevaMAX_SIZE) {
		this.MAX_SIZE = nuevaMAX_SIZE;
		ClothingItem[] items2 = Arrays.copyOf(items, nuevaMAX_SIZE);
		System.out.println("Tamaño del inventario actualizado.");
		this.items = items2;
	}
	public ClothingItem[] getItems() {
		return this.items;
	}
	public void setItems() {
		System.out.println("No se puede usar desde aquí");
	}
	
	public int getItemLength() {
		return this.itemLength;
	}
	public void setItemLength() {
		System.out.println("No se puede editar");
	}
	


	//MÉTODOS
	public int getItemCount() {
		//System.out.println("Incicio getItemCount");
		itemLength = 0;
		if(this.items != null) { // verificar si la lista no es vacía para no saltar error
			for (int i =0; i < this.MAX_SIZE; i++) { //recorrer lista
				if(this.items[i]!= null) { // sumar al contador los objetos no vacíos
					itemLength += 1;
				}
			}
			// System.out.println("Hay " + itemLength + " items en el inventario.");
		} else {
			System.out.println("Inventario vacío.");
			
		} return itemLength; }




	public void addItem(ClothingItem prenda) {
		//itemLength = this.getItemCount();
		
		if(itemLength >= this.MAX_SIZE) {
			System.out.println("Inventario lleno.");
		}else {
			this.items[itemLength] = prenda; // porque el índice empieza por 0 entonces itemLength coincide con el primer hueco
			System.out.println(prenda.getName() + " añadido a inventario");
			itemLength +=1; 
			}
		}
	 
	//}//fin addItem

	
	
	
	
	public int checkStock(String name2, char size2) {
		//System.out.println("Buscando Stock...");
		//itemLength = this.getItemCount();
		//getItemCount(); NO ES NECESARIO
		int contador = 0;
		//System.out.println("itemLength: " + itemLength);
		for (int i = 0; i < itemLength; i++) { //itemLength coincide con primer hueco
			if(this.items[i] != null && this.items[i].equals(name2, size2) == true) {
				contador += 1;	 
			}else {
				System.out.println("En "+ i + " no está.");
				
			}
		} System.out.println("contador: " + contador + "\n ");
		return contador;
	} // fin checkStock

	
	private int buscador(String name2, char size2) {
		int posicion = -1; // por defecto para saber si cambia o no
		for (int i = 0; i < itemLength; i++) { //podría poner hasta itemLength
				if(this.items[i] != null && this.items[i].getName().equals(name2) && this.items[i].getSize() == size2) {
				//System.out.println("posicion : " + i + " = " + this.items[i]); 
				posicion = i;	
				//System.out.println("posicion " + posicion);
				}
		}//fin for
		return posicion;
	}
	
	private void remove(int posicion) {
		if (posicion != -1) {
			// eliminar prenda de la posición y mover las posteriores
			this.items[posicion] = null;
			for (int i = posicion; i < MAX_SIZE-1; i++) {
					this.items[i] = this.items[i+1];
			} itemLength -=1;

			// Ult prenda a 0
			this.items[itemLength] = null;
			//System.out.println("Item eliminado."); Lo pongo en removeItem
		}else {//fin if
			System.out.println("No se encontró el item");
		}
	}
	

	public ClothingItem extractItem(String name2, char size2) {
		ClothingItem itemExtraido;
		// 1. checkStock
		int stock = this.checkStock(name2, size2);
		if (stock == 0) {
			itemExtraido = null;
			System.out.println( "No está dicho item");
			
		}else { // 2. buscar posición, guardar y eliminar
			int posicion = buscador(name2, size2);
			itemExtraido = this.items[posicion];
			remove(posicion);
			
		}//fin else
		return itemExtraido;
	}// fin removeItem
	
	
	public void removeItem(String name2, char size2) {
		// 1. checkStock
		int stock = this.checkStock(name2, size2);
		if (stock == 0) {
			System.out.println( "No está dicho item");
					
		}else { // 2. buscar posición y eliminar
			int posicion = buscador(name2, size2);
			remove(posicion);
			System.out.println("Item eliminado.");
		}//fin else
	}// fin removeItem
	
	

	@Override
	public String toString() {		
		String printy = "--------------------------------\n" + "Nombre       Precio       Talla\n" +
	"--------------------------------\n" ;
		//Recorrer el vector y crear string que vaya añadiendo las filas
		 for (ClothingItem producto : items) {
			 if(producto != null) {
		        printy += String.format("%-12s %-14.2f %-6s\n", 
		                                producto.getName(), 
		                                producto.getPrice(), 
		                                producto.getSize());
		    }
	}return printy;
	}
}
