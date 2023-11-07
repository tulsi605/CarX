package com.carapplication.Service.Controller;


import com.carapplication.Service.Entity.Car;
import com.carapplication.Service.Entity.Service;
import com.carapplication.Service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getAllService")
    public List<Service> getAllService(Model model) {
        List<Service> service = serviceService.getAllService();
        return service;
    }

    @GetMapping("/service/{id}")
    public Service getServiceById(@PathVariable Long id) {
        Service service = serviceService.getServiceById(id);
        Car car1=this.restTemplate.getForObject("http://localhost:8080/car/"+id, Car.class);
        service.setCar(car1);
        return service;
    }

    @PostMapping("/save-service")
    public Service saveService( @RequestBody Service service){
        System.out.println(service);
        return serviceService.saveService(service);
    }

    @DeleteMapping("/delete-service/{id}")
    public void deleteService(@PathVariable Long id){
        serviceService.deleteService(id);
    }



}
