package com.abzal.endterm.model;

import javax.persistence.*;

@Entity
@Table(name = "end_term_education_history", schema = "public", catalog = "postgres")
public class EducationHistory {
    private int id;
    private String address;
    private String duringTime;

    private String educatedPlaceName;

    private Student student;

    public EducationHistory() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 256)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "during_time", nullable = true, length = 256)
    public String getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(String duringTime) {
        this.duringTime = duringTime;
    }

    @Basic
    @Column(name = "educated_place_name", nullable = true, length = 256)
    public String getEducatedPlaceName() {
        return educatedPlaceName;
    }

    public void setEducatedPlaceName(String educatedPlaceName) {
        this.educatedPlaceName = educatedPlaceName;
    }

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student idStudent) {
        this.student = idStudent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationHistory)) return false;

        EducationHistory that = (EducationHistory) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (duringTime != null ? !duringTime.equals(that.duringTime) : that.duringTime != null) return false;
        if (educatedPlaceName != null ? !educatedPlaceName.equals(that.educatedPlaceName) : that.educatedPlaceName != null)
            return false;
        return student != null ? student.equals(that.student) : that.student == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (duringTime != null ? duringTime.hashCode() : 0);
        result = 31 * result + (educatedPlaceName != null ? educatedPlaceName.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }
}
