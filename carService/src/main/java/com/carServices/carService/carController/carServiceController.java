package com.carServices.carService.carController;

import com.carServices.carService.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class carServiceController {
    @Autowired
    private Car carService;
    @GetMapping("/")
    public String home()
    {
        return "Home";
    }
    @GetMapping("/show-allcars")
    public String showMyPage() {
        return "show-allcars";
    }
    @GetMapping("/periodicservice")
    public String periodicService()
    {
        return "Home";
    }
}
