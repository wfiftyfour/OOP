package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class MediaCarts {
	private final ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).equals(media)) {
				System.out.println(media.getTitle() + " đã tồn tại!");
				return;
			}
		}
		itemsOrdered.add(media);
		System.out.println(media.getTitle() + " đã được thêm vào thành công!");
	}

	public void removeMedia(Media media) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).equals(media)) {
				itemsOrdered.remove(i);
				System.out.println("Đã xóa " + media.getTitle() + " thành công!");
				return;
			}
		}
		System.out.println(media.getTitle() + " không tồn tại trong list!");
	}

	public void emptyCart() {
		itemsOrdered.clear();
	}

	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
	}

	public void printCart() {
		System.out.println("---------------------------------------");
		System.out.println("Order Items: ");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("Total Cost: " + totalCost() + "$");
		System.out.println("---------------------------------------");
	}

	public Media search(int id) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println("Tìm thấy media: " + itemsOrdered.get(i).toString());
				return itemsOrdered.get(i);
			}
		}
		System.out.println("Không tìm thấy media với ID: " + id);
		return null;
	}

	public Media search(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
				System.out.println("Tìm thấy media: " + itemsOrdered.get(i).toString());
				return itemsOrdered.get(i);
			}
		}
		System.out.println("Không tìm thấy media với title: " + title);
		return null;
	}

	public void sortCart(int command) {
		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
			for (int j = i + 1; j < itemsOrdered.size(); j++) {
				if (command == 0) { // Sắp xếp theo title
					if (itemsOrdered.get(i).getTitle().compareTo(itemsOrdered.get(j).getTitle()) > 0) {
						Media temp = itemsOrdered.get(i);
						itemsOrdered.set(i, itemsOrdered.get(j));
						itemsOrdered.set(j, temp);
					}
				} else if (command == 1) { // Sắp xếp theo cost
					if (itemsOrdered.get(i).getCost() > itemsOrdered.get(j).getCost()) {
						Media temp = itemsOrdered.get(i);
						itemsOrdered.set(i, itemsOrdered.get(j));
						itemsOrdered.set(j, temp);
					}
				}
			}
		}
		if (command == 0) {
			System.out.println("Giỏ hàng đã được sắp xếp theo title.");
		} else if (command == 1) {
			System.out.println("Giỏ hàng đã được sắp xếp theo cost.");
		} else {
			System.out.println("Lựa chọn sắp xếp không hợp lệ.");
		}
	}
}
