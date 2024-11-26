public class Store {
    private DigitalVideoDisc[] items;
    private int discCount;

    public Store(int capacity) {
        items = new DigitalVideoDisc[capacity];
        discCount = 0;
    }

    public void addDisc(DigitalVideoDisc disc) {
        if (discCount < items.length) {
            items[discCount++] = disc;
            System.out.println("Disc \"" + disc.getTitle() + "\" added successfully.");
        } else {
            System.out.println("Store is full. Cannot add more discs.");
        }
    }

    public void removeDisc(DigitalVideoDisc disc) {
        if (discCount == 0) {
            System.out.println("Store is empty. No discs to remove.");
            return;
        }

        int position = -1;
        for (int i = 0; i < discCount; i++) {
            if (items[i].equals(disc)) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.arraycopy(items, position + 1, items, position, discCount - position - 1);
            items[--discCount] = null;
            System.out.println("Disc removed successfully.");
        } else {
            System.out.println("Disc not found in store.");
        }
    }

    public void printStore() {
        System.out.println("********** Store Content **********");
        for (int i = 0; i < discCount; i++) {
            System.out.println((i + 1) + ". " + items[i].toString());
        }
        System.out.println("***********************************");
    }
}
