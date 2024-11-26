public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store(4);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		store.addDisc(dvd1);
		store.addDisc(dvd2);
		store.addDisc(dvd3);
		
		store.printStore();
	}
}