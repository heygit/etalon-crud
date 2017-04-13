package project.entities;

import java.math.BigInteger;
import java.util.List;

public class Note {

    private BigInteger id;
    private String name;
    private double weight;
    private List<String> tags;
    private long created;
    private User author;
    private List<User> editors;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<User> getEditors() {
        return editors;
    }

    public void setEditors(List<User> editors) {
        this.editors = editors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (Double.compare(note.weight, weight) != 0) return false;
        if (created != note.created) return false;
        if (id != null ? !id.equals(note.id) : note.id != null) return false;
        if (name != null ? !name.equals(note.name) : note.name != null) return false;
        if (tags != null ? !tags.equals(note.tags) : note.tags != null) return false;
        if (author != null ? !author.equals(note.author) : note.author != null) return false;
        return editors != null ? editors.equals(note.editors) : note.editors == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (int) (created ^ (created >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (editors != null ? editors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", tags=" + tags +
                ", created=" + created +
                ", author=" + author +
                ", editors=" + editors +
                '}';
    }
}
