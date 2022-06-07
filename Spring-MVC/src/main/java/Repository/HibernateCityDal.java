package Repository;

import Model.City;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateCityDal implements ICityDal{

    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    public List<City> GetAll() {
        Session session= entityManager.unwrap(Session.class);
        List<City> cities=session.createQuery("from City ",City.class).getResultList();
        return cities;
    }

    @Override
    public void add(City city) {
        Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void update(City city) {
        Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
        Session session= entityManager.unwrap(Session.class);
        session.delete(city);
    }

    @Override
    public City getbyID(int id) {
        Session session= entityManager.unwrap(Session.class);
        City city=session.get(City.class,id);
        return city;
    }
}
