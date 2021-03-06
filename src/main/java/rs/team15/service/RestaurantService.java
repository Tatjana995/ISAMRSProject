package rs.team15.service;

import java.util.Collection;

import rs.team15.model.Region;
import rs.team15.model.Restaurant;
import rs.team15.model.TableR;
import rs.team15.model.User;

public interface RestaurantService {

	Collection<Restaurant> findAll();
	
    Restaurant findById(String id);
    
    //Region findRegion(String id);

    Restaurant create(Restaurant restaurant);


    Collection<Restaurant> findByNameOrType(String name, String type);
    
    TableR create(TableR table);
    
    TableR update(TableR table);
    
    TableR delete(TableR table);
    
    TableR find(Integer id);
    
    TableR update2(TableR table);
    
    Restaurant findOne(Long id);
    
}
