package com.carapplication.Service.Service;

import com.carapplication.Service.Entity.Service;
import com.carapplication.Service.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }
    public Service getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public Service saveService(Service service) {
        return serviceRepository.save(service);
    }


    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
