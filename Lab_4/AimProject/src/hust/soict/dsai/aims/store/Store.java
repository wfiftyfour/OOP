package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private final ArrayList<Media> itemsStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		for (int i = 0; i < itemsStore.size(); i++) {
			if (itemsStore.get(i).equals(media)) {
				System.out.println(media.getTitle() + " đã tồn tại trong store!");
				return;
			}
		}
		itemsStore.add(media);
		System.out.println(media.getTitle() + " đã được thêm vào store!");
	}

	public void removeMedia(Media media) {
		for (int i = 0; i < itemsStore.size(); i++) {
			if (itemsStore.get(i).equals(media)) {
				itemsStore.remove(i);
				System.out.println("Đã xóa " + media.getTitle() + " thành công!");
				return;
			}
		}
		System.out.println("Không tìm thấy " + media.getTitle());
	}

	public void printStore() {
		System.out.println("---------------------------------------");
		System.out.println("Items in store:");
		for (int i = 0; i < itemsStore.size(); i++) {
			System.out.println(itemsStore.get(i).toString());
		}
		System.out.println("---------------------------------------");
	}

	public Media search(String title) {
		for (int i = 0; i < itemsStore.size(); i++) {
			if (itemsStore.get(i).getTitle().equalsIgnoreCase(title)) {
				return itemsStore.get(i);
			}
		}
		System.out.println("Không tìm thấy media với title: " + title);
		return null;
	}

	public Media search(int id) {
		for (int i = 0; i < itemsStore.size(); i++) {
			if (itemsStore.get(i).getId() == id) {
				return itemsStore.get(i);
			}
		}
		System.out.println("Không tìm thấy media với ID: " + id);
		return null;
	}
}