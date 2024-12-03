package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media M1, Media M2) {
		int costComparison = Float.compare(M2.getCost(), M1.getCost());
		if (costComparison != 0) {
			return costComparison;
		}
		return M1.getTitle().compareTo(M2.getTitle());
	}
}