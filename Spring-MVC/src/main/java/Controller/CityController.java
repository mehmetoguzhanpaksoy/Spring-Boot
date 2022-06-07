package Controller;

import Model.City;
import Service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    private ICityService iCityService;



    @GetMapping("/apies")
    public List<City> getAll(){
        return this.iCityService.GetAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody City city){
       this.iCityService.add(city);
    }
    @PostMapping("/update")
    public void update(@RequestBody City city){
        this.iCityService.update(city);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody City city){
        this.iCityService.delete(city);
    }
    @GetMapping("/cities/{id]")
    public void getbyid(@PathVariable int id){
        this.iCityService.getbyıd(id);
    }
}
