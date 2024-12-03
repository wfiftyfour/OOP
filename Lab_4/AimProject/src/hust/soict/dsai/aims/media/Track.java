package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;


    public Track(String title, int length) {
        this.setTitle(title);
        this.setLength(length);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Tiêu đề không hợp lệ!");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length >= 0) {
            this.length = length;
        } else {
            System.out.println("Độ dài track không thể âm!");
        }
    }


    public void play() {
        if (length > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength() + " seconds");
        } else {
            System.out.println("Track " + this.getTitle() + " không có nội dung để phát.");
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        return this.length == track.length && Objects.equals(this.title, track.title);
    }

    public int hashCode() {
        return Objects.hash(title, length);
    }

    public String toString() {
        return String.format("Track [title=%s, length=%d]", title, length);
    }
}
