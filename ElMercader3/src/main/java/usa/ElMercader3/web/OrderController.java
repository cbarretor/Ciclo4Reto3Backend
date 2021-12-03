/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ElMercader3.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usa.ElMercader3.modelo.Order;
import usa.ElMercader3.modelo.User;
import usa.ElMercader3.servicios.OrderService;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
    
    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> getAll() {
        return service.getAll();
    }
    
    // CONSULTA ID PUNTUAL
    @GetMapping("/{id}")
    private Order getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }     
    
    // CONSULTA ZONA
    @GetMapping("/zona/{zone}")
    private List<Order> getByZone(@PathVariable("zone") String zone) {
        return service.getByZone(zone);
    }      

    @PostMapping("/new")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return new ResponseEntity(service.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return new ResponseEntity(service.update(order), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
}
