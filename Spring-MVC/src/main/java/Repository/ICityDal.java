package Repository;

import Model.City;

import java.util.List;

public interface ICityDal {
    List<City> GetAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getbyID(int id);
}
