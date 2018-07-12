package com.abzal.endterm.model;

import javax.persistence.*;

@Entity
@Table(name = "end_term_specialty", schema = "public", catalog = "postgres")
public class Specialty {
    private int id;
    private Faculty faculty;
    private String name;

    public Specialty() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_faculty", referencedColumnName = "id")
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialty = (Specialty) o;

        if (id != specialty.id) return false;
        if (name != null ? !name.equals(specialty.name) : specialty.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
