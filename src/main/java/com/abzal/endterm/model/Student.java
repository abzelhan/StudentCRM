package com.abzal.endterm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "end_term_students", schema = "public", catalog = "postgres")
public class Student {
    private int id;
    private String address;
    private Date docExpire;
    private String docNumber;
    private String docOrganization;
    private String docType;
    private String email;
    private String firstName;
    private String gender;

    private Integer idEdu;
    private Date birthDate;
    private Specialty specialty;
    private String imagePath;
    private String lastName;
    private String nationality;
    private String phoneNumber;
    private Integer idUser;
    private String motherName;
    private String motherWorkingPlace;
    private String motherEmail;
    private String fatherName;
    private String fatherWorkingPlace;
    private String fatherEmail;
    private Date entryYear;
    private String eduLevel;
    private String paymentType;

    public Student() {
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

    @Column(name = "doc_expire", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getDocExpire() {
        return docExpire;
    }

    public void setDocExpire(Date docExpire) {
        this.docExpire = docExpire;
    }

    @Basic
    @Column(name = "doc_number", nullable = true)
    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    @Basic
    @Column(name = "doc_organization", nullable = true, length = 256)
    public String getDocOrganization() {
        return docOrganization;
    }

    public void setDocOrganization(String docOrganization) {
        this.docOrganization = docOrganization;
    }

    @Basic
    @Column(name = "doc_type", nullable = true)
    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 256)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 256)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "id_edu", nullable = true)
    public Integer getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(Integer idEdu) {
        this.idEdu = idEdu;
    }

    @ManyToOne
    @JoinColumn(name = "id_specialty", referencedColumnName = "id")
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 5000)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 256)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "nationality", nullable = true)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 256)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "id_user", nullable = true)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "mother_name", nullable = true, length = 256)
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Basic
    @Column(name = "mother_working_place", nullable = true, length = 256)
    public String getMotherWorkingPlace() {
        return motherWorkingPlace;
    }

    public void setMotherWorkingPlace(String motherWorkingPlace) {
        this.motherWorkingPlace = motherWorkingPlace;
    }

    @Basic
    @Column(name = "mother_email", nullable = true, length = 256)
    public String getMotherEmail() {
        return motherEmail;
    }

    public void setMotherEmail(String motherEmail) {
        this.motherEmail = motherEmail;
    }

    @Basic
    @Column(name = "father_name", nullable = true, length = 256)
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Basic
    @Column(name = "father_working_place", nullable = true, length = 256)
    public String getFatherWorkingPlace() {
        return fatherWorkingPlace;
    }

    public void setFatherWorkingPlace(String fatherWorkingPlace) {
        this.fatherWorkingPlace = fatherWorkingPlace;
    }

    @Basic
    @Column(name = "father_email", nullable = true, length = 256)
    public String getFatherEmail() {
        return fatherEmail;
    }

    public void setFatherEmail(String fatherEmail) {
        this.fatherEmail = fatherEmail;
    }

    @Column(name = "entry_year", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Date entryYear) {
        this.entryYear = entryYear;
    }

    @Column(name = "birth_date", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birdthDate) {
        this.birthDate = birdthDate;
    }

    @Basic
    @Column(name = "edu_level", nullable = true, length = 256)
    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    @Basic
    @Column(name = "payment_type", nullable = true, length = 256)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (docExpire != null ? !docExpire.equals(student.docExpire) : student.docExpire != null) return false;
        if (docNumber != null ? !docNumber.equals(student.docNumber) : student.docNumber != null) return false;
        if (docOrganization != null ? !docOrganization.equals(student.docOrganization) : student.docOrganization != null)
            return false;
        if (docType != null ? !docType.equals(student.docType) : student.docType != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (gender != null ? !gender.equals(student.gender) : student.gender != null) return false;
        if (idEdu != null ? !idEdu.equals(student.idEdu) : student.idEdu != null) return false;
        if (specialty != null ? !specialty.equals(student.specialty) : student.specialty != null) return false;
        if (imagePath != null ? !imagePath.equals(student.imagePath) : student.imagePath != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (nationality != null ? !nationality.equals(student.nationality) : student.nationality != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(student.phoneNumber) : student.phoneNumber != null) return false;
        if (idUser != null ? !idUser.equals(student.idUser) : student.idUser != null) return false;
        if (motherName != null ? !motherName.equals(student.motherName) : student.motherName != null) return false;
        if (motherWorkingPlace != null ? !motherWorkingPlace.equals(student.motherWorkingPlace) : student.motherWorkingPlace != null)
            return false;
        if (motherEmail != null ? !motherEmail.equals(student.motherEmail) : student.motherEmail != null) return false;
        if (fatherName != null ? !fatherName.equals(student.fatherName) : student.fatherName != null) return false;
        if (fatherWorkingPlace != null ? !fatherWorkingPlace.equals(student.fatherWorkingPlace) : student.fatherWorkingPlace != null)
            return false;
        if (fatherEmail != null ? !fatherEmail.equals(student.fatherEmail) : student.fatherEmail != null) return false;
        if (entryYear != null ? !entryYear.equals(student.entryYear) : student.entryYear != null) return false;
        if (eduLevel != null ? !eduLevel.equals(student.eduLevel) : student.eduLevel != null) return false;
        if (paymentType != null ? !paymentType.equals(student.paymentType) : student.paymentType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (docExpire != null ? docExpire.hashCode() : 0);
        result = 31 * result + (docNumber != null ? docNumber.hashCode() : 0);
        result = 31 * result + (docOrganization != null ? docOrganization.hashCode() : 0);
        result = 31 * result + (docType != null ? docType.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (idEdu != null ? idEdu.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (motherName != null ? motherName.hashCode() : 0);
        result = 31 * result + (motherWorkingPlace != null ? motherWorkingPlace.hashCode() : 0);
        result = 31 * result + (motherEmail != null ? motherEmail.hashCode() : 0);
        result = 31 * result + (fatherName != null ? fatherName.hashCode() : 0);
        result = 31 * result + (fatherWorkingPlace != null ? fatherWorkingPlace.hashCode() : 0);
        result = 31 * result + (fatherEmail != null ? fatherEmail.hashCode() : 0);
        result = 31 * result + (entryYear != null ? entryYear.hashCode() : 0);
        result = 31 * result + (eduLevel != null ? eduLevel.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", docExpire=" + docExpire +
                ", docNumber=" + docNumber +
                ", docOrganization='" + docOrganization + '\'' +
                ", docType=" + docType +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender=" + gender +
                ", idEdu=" + idEdu +
                ", idSpecialty=" + specialty +
                ", imagePath='" + imagePath + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality=" + nationality +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idUser=" + idUser +
                ", motherName='" + motherName + '\'' +
                ", motherWorkingPlace='" + motherWorkingPlace + '\'' +
                ", motherEmail='" + motherEmail + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fatherWorkingPlace='" + fatherWorkingPlace + '\'' +
                ", fatherEmail='" + fatherEmail + '\'' +
                ", entryYear=" + entryYear +
                ", eduLevel='" + eduLevel + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
