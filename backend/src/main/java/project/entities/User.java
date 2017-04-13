package project.entities;


import java.math.BigInteger;
import java.util.List;

public class User {

    private BigInteger id;
    private String name;
    private List<Note> ownedNotes;
    private List<Note> editableNotes;

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

    public List<Note> getOwnedNotes() {
        return ownedNotes;
    }

    public void setOwnedNotes(List<Note> ownedNotes) {
        this.ownedNotes = ownedNotes;
    }

    public List<Note> getEditableNotes() {
        return editableNotes;
    }

    public void setEditableNotes(List<Note> editableNotes) {
        this.editableNotes = editableNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (ownedNotes != null ? !ownedNotes.equals(user.ownedNotes) : user.ownedNotes != null) return false;
        return editableNotes != null ? editableNotes.equals(user.editableNotes) : user.editableNotes == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ownedNotes != null ? ownedNotes.hashCode() : 0);
        result = 31 * result + (editableNotes != null ? editableNotes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownedNotes=" + ownedNotes +
                ", editableNotes=" + editableNotes +
                '}';
    }
}
