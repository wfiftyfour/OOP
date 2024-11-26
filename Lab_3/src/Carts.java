
public class Carts {
	public static final int MAX_NUMBERS_ORDERS = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
	int qtyOrdered;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERS) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
        }
    }
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc dvd:dvdList) {
			if(qtyOrdered < MAX_NUMBERS_ORDERS) {
				itemsOrdered[qtyOrdered] = dvd;
				qtyOrdered++;
				System.out.println("The disc \"" + dvd.getTitle() + "\" has been added.");
			}else {
				System.out.println("The order is almost full. Cannot add more DVDs.");
			}
		}
	}

        public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; 
                qtyOrdered--;
                break;
            }
        }
    }

        public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    	public void printCarts() {
   		 int i=1;
   		 System.out.println("***********************CART***********************");
   		 System.out.println("Ordered Items:");
   		 for (DigitalVideoDisc dvd : itemsOrdered) {
   			 System.out.println(i + ". "+ dvd.toString()+ "$");
   			 i++;
   		 }
   		 System.out.println("Total cost: " + this.totalCost());
   		 System.out.println("**************************************************");
   	}
}

