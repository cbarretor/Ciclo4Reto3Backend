/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ElMercader3.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ElMercader3.modelo.Order;
import usa.ElMercader3.repositorios.crud.CrudOrderRepository;

/**
 *
 * @author DELL
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private CrudOrderRepository repo;
    
    public List<Order> getAll(){
        return repo.findAll();
    }
    
    // Metodo para consulta de Id puntual
    public Optional<Order> getById(Integer id){
        return repo.getById(id);
    }
    
    public Order save(Order order){
        return repo.save(order);
    }
    
    public void delete(Order order){
        repo.delete(order);
    }    
    
    // Metodo para consulta de zona puntual
    public List<Order> getByZone(String zone){
        return repo.findByZone(zone);
    }     
    
}
