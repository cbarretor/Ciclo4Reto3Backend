/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader3.servicios;

import usa.ElMercader3.modelo.User;
import usa.ElMercader3.repositorios.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAll() {
        return repo.getAll();
    }

    public User save(User usuario) {
        return repo.save(usuario);
    }

    public void delete(Integer id) {
        Optional<User> ou = repo.getById(id);
        if (ou.isPresent()) {
            repo.delete(ou.get());
        }
    }

    public User update(User usuario) {
        Optional<User> ou = repo.getById(usuario.getId());
        if (ou.isPresent()) {
            User act = ou.get();
            //validacion para no actualizar datos nulos o vacios
            if (usuario.getId() != null) {
                act.setId(usuario.getId());
            }            
            if (usuario.getIdentification() != null && usuario.getIdentification().length() > 0) {
                act.setIdentification(usuario.getIdentification());
            }
            if (usuario.getName() != null && usuario.getName().length() > 0) {
                act.setName(usuario.getName());
            }    
            if (usuario.getBirthtDay() != null) {
                act.setBirthtDay(usuario.getBirthtDay());
            }     
            if (usuario.getMonthBirthtDay() != null && usuario.getMonthBirthtDay().length() > 0) {
                act.setMonthBirthtDay(usuario.getMonthBirthtDay());
            }  
            if (usuario.getAddress() != null && usuario.getAddress().length() > 0) {
                act.setAddress(usuario.getAddress());
            }    
            if (usuario.getCellPhone() != null && usuario.getCellPhone().length() > 0) {
                act.setCellPhone(usuario.getCellPhone());
            }            
            if (usuario.getEmail() != null && usuario.getEmail().length() > 0) {
                act.setEmail(usuario.getEmail());
            }               
            if (usuario.getPassword() != null && usuario.getPassword().length() > 0) {
                act.setPassword(usuario.getPassword());
            }   
            if (usuario.getZone() != null && usuario.getZone().length() > 0) {
                act.setZone(usuario.getZone());
            }             
            if (usuario.getType() != null && usuario.getType().length() > 0) {
                act.setType(usuario.getType());
            }             
            
            return repo.save(act);
        }
        return usuario;
    }

    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = repo.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            User e = new User();
            return e;
        }
    }

    public boolean getByEmail(String email) {
        Optional<User> user = repo.getByEmail(email);
        return user.isPresent();
    }    

    public User getById(Integer id) {
        Optional<User> user = repo.getById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            User e = new User();
            return e;
        }
    }    
    
}
