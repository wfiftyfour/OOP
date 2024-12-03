package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID phải là số dương!");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Tiêu đề không được để trống!");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null && !category.trim().isEmpty()) {
            this.category = category;
        } else {
            System.out.println("Danh mục không hợp lệ!");
        }
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            System.out.println("Giá tiền không thể âm!");
        }
    }

    public String toString() {
        return String.format("Media [id=%d, title=%s, category=%s, cost=%.2f]", id, title, category, cost);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Media media = (Media) o;
        return Objects.equals(this.title, media.title);
    }

    public int hashCode() {
        return Objects.hash(title);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
