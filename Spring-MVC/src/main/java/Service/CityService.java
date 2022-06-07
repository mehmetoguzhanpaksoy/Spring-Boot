package Service;

import Model.City;
import Repository.ICityDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private ICityDal iCityDal;

    @Override
    @Transactional
    public List<City> GetAll() {
        return this.iCityDal.GetAll();
    }

    @Override
    @Transactional
    public void add(City city) {
        this.iCityDal.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        this.iCityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.iCityDal.delete(city);
    }

    @Override
    @Transactional
    public City getbyıd(int id) {
        return this.iCityDal.getbyID(id);
    }
}
