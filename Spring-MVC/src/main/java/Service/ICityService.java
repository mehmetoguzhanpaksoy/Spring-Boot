package Service;

import Model.City;

import java.util.List;

public interface ICityService {
    List<City> GetAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getbyıd(int id);
}
