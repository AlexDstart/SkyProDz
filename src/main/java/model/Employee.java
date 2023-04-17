package model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "employee", schema = "public", catalog = "skypro")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;
    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;
    @Basic
    @Column(name = "gender", nullable = false, length = 6)
    private String gender;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @Basic

    @Column(name = "city_id", nullable = false)
    private Long cityId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
    private City city;

    public Employee(String firstName, String lastName, String gender, int age, Long cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }


    public Employee() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }



    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                ", city=" + city.getCityName() +
                '}';
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
