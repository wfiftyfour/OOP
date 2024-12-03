package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist != null && !artist.trim().isEmpty()) {
            this.artist = artist;
        } else {
            System.out.println("Tên nghệ sĩ không hợp lệ!");
        }
    }


    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Track không hợp lệ!");
            return;
        }

        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" đã tồn tại!");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" đã được thêm!");
        }
    }


    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("Track không hợp lệ!");
            return;
        }

        if (tracks.remove(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" đã được xóa!");
        } else {
            System.out.println("Không tìm thấy track \"" + track.getTitle() + "\" trong danh sách!");
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }


    public void play() {
        System.out.println("Playing CD: \"" + this.getTitle() + "\"");
        System.out.println("Artist: \"" + this.getArtist() + "\"");
        tracks.forEach(Track::play);
    }
}
