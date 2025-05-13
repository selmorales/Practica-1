package shop;

// import java.util.Objects;

public class ClothingItem {
	private String name;
	private double price;
	private char size; // Solo S, M o L
	

	//Constructor
	public ClothingItem(String name , double price, char size) {
		this.name = name;
		this.price = price;
		if(size == 'S' || size == 'M' || size == 'L') {
			this.size = size;
		}else {
			System.out.println("Talla inválida, se asigna S por defecto.");
			this.size = 'S';
		}
	}//
	
	//Getters y Setters
		//name
	public String getName() {return this.name;}
	public void SetName(String name) {
		this.name = name;
	}
		//price
	public double getPrice() {return this.price;}
	public void setPrice(double price) {
		this.price = price;
	}
		//size
	public char getSize() {return this.size;} // habría que tratar fallos de tipo
	public void setSize(char size) {
		if(size == 'S' || size == 'M' || size == 'L') {
			this.size = size;
		}else {
			System.out.println("Error, talla inválida.");
		}
	} 
	//// Fin getters y setters
	
	


	
	// print
	/*Cuando un objeto es null y se le llama en un print, java ni siquiera entra en el toString
	 * o sea que lo de verificarSiVacio en el toString no sirve
	 */
	
	public static String ver(ClothingItem prenda) {
		if (prenda == null) {
			return "Vacío";
		}else {
			return prenda.toString();
		}
	}
	@Override 
	public String toString() {
		//String print;
			return String.format("%8s | %-3.2f € | %1c\n", name, price, size);
	}
	/*return "> " + this.name; 
	 comentado para pruebas
				"> Prenda: " + this.name V+ ".\n Precio: " + this.price + ".\n Talla: " + this.size +"\n\n";
	*/
	
	//return String.format("%s  %.2f  %c", name, prize, size);
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}else if (obj == null ||this.getClass() != obj.getClass()) {
			return false;
		}
		ClothingItem item = (ClothingItem) obj;
	 return this.size == item.size && this.name == item.name;
	}
	
	
	
	
	
}
