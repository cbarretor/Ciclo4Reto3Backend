/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package usa.ElMercader3.repositorios.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import usa.ElMercader3.modelo.Order;

/**
 *
 * @author DELL
 */
public interface CrudOrderRepository extends MongoRepository<Order, Integer>{

    @Query("{id: ?0}")
    public Optional<Order> getById(Integer id);  

    @Query("{'salesMan.zone':{$lte: ?0}}")
    public List<Order> findByZone(String zone);     
    
}
