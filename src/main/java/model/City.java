package model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
@Entity
@Table(name = "city", schema = "public", catalog = "skypro")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id", nullable = false)
    private long cityId;
    @Basic
    @Column(name = "city_name", nullable = false, length = 50)
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Employee> employees;

    public City(String cityName) {
        this.cityName = cityName;
    }
    public City() {
    }
    public long getCityId() {
        return cityId;
    }
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", employees=" + employees +
                '}';
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
