package service;


import model.City;
import skypro.dz.Dao.CityDAO;

import java.util.List;

public class CityService {
    private static CityDAO cityDAO;

    public CityService() {
        cityDAO = new CityDAO();
    }

    public void addNewEmployee(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.addNewEmployee(entity);
        cityDAO.closeCurrentSessionWithTransaction();
    }

    public void updateById(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.updateById(entity);
        cityDAO.closeCurrentSessionWithTransaction();
    }

    public City findById(Long id) {
        cityDAO.openCurrentSession();
        City city = cityDAO.findById(id);
        cityDAO.closeCurrentSession();
        return city;
    }

    public void deleteById(Long id) {
        cityDAO.openCurrentSessionWithTransaction();
        City city = cityDAO.findById(id);
        cityDAO.deleteById(city);
        cityDAO.closeCurrentSessionWithTransaction();
    }

    public List<City> findAll() {
        cityDAO.openCurrentSession();
        List<City> cities = cityDAO.findAll();
        cityDAO.closeCurrentSession();
        return cities;
    }
}
