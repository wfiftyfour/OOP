package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	@Override
	public int compare(Media M1, Media M2) {
		int titleComparison = M1.getTitle().compareTo(M2.getTitle());
		if (titleComparison != 0) {
			return titleComparison;
		}
		return Float.compare(M2.getCost(), M1.getCost());
	}
}