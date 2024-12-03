package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        if (authors != null) {
            this.authors = authors;
        } else {
            System.out.println("Danh sách tác giả không hợp lệ!");
        }
    }

    public Book(String title) {
        this.setTitle(title);
    }

    public Book(String title, String category) {
        this(title); // Sử dụng constructor chuỗi
        this.setCategory(category);
    }

    public Book(String title, String category, float cost) {
        this(title, category); // Sử dụng constructor chuỗi
        this.setCost(cost);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        this(title, category, cost); // Sử dụng constructor chuỗi
        this.setAuthors(authors);
    }

    public void addAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Tên tác giả không hợp lệ!");
            return;
        }
        if (authors.contains(author)) {
            System.out.println("Tác giả \"" + author + "\" đã tồn tại!");
        } else {
            authors.add(author);
            System.out.println("Tác giả \"" + author + "\" đã được thêm!");
        }
    }

    public void removeAuthor(String author) {
        if (authors.remove(author)) {
            System.out.println("Đã xóa \"" + author + "\" khỏi danh sách tác giả.");
        } else {
            System.out.println("Không tìm thấy tác giả \"" + author + "\".");
        }
    }
}

