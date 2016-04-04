package homework.model;

/**
 * Created by admin on 4/2/16.
 */
public class FileRecord implements Comparable<FileRecord> {
    private char letter;
    private String title;
    private String filename;

    public FileRecord(String title, String filename) {
        this.title = title;
        this.filename = filename;
        this.letter = title.toUpperCase().charAt(0);
    }

    public String toString() {
        return "\"" + title + "\"";
    }

    public int compareTo(FileRecord o) {
        return this.getTitle().toUpperCase().compareTo(o.getTitle().toUpperCase());
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
