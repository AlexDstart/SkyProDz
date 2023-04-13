package model;

import javax.persistence.*;

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
}
