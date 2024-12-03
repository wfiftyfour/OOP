package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();

		DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Action", "Wachowski Brothers", 136, 14.99f);
		Book book = new Book("1984", "Dystopian", 8.99f);
		CompactDisc cd = new CompactDisc("Abbey Road", "Music", 12.99f, 47, "The Beatles", "John Lennon");

		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(cd);

		store.printStore();

		store.removeMedia(cd);
		store.printStore();

	}
}
