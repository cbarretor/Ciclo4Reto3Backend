/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ElMercader3.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ElMercader3.modelo.Order;
import usa.ElMercader3.repositorios.OrderRepository;

/**
 *
 * @author DELL
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repo;

    public List<Order> getAll(){
        return repo.getAll();
    }
    
    public Order save(Order order){
        return repo.save(order);
    }
    
    public void delete(Integer id){
        Optional<Order> oo = repo.getById(id);
        if (oo.isPresent()){
            repo.delete(oo.get());
        }
    }
    
    public Order update(Order order){
        Optional<Order> oo = repo.getById(order.getId());
        if (oo.isPresent()){
            Order act = oo.get();
            //validacion para no actualizar datos nulos o vacios
            if (order.getRegisterDay() != null) {
                act.setRegisterDay(order.getRegisterDay());
            }        
            if (order.getStatus() != null && order.getStatus().length() > 0) {
                act.setStatus(order.getStatus());
            }     
            if (order.getSalesMan() != null) {
                act.setSalesMan(order.getSalesMan());
            }      
            if (order.getProducts() != null) {
                act.setProducts(order.getProducts());
            }  
            if (order.getQuantities() != null) {
                act.setQuantities(order.getQuantities());
            }              
            return repo.save(act);
        }
        return order;
    }
    
    public Order getById(Integer id) {
        Optional<Order> order = repo.getById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            Order e = new Order();
            return e;
        }
    }       
    
    public List<Order> getByZone(String zone) {
        List<Order> order = repo.getByZone(zone);
        return repo.getByZone(zone);
    }   
    
}
