package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private CarServiceImpl service;

    @Autowired
    public CarsController(CarServiceImpl service) {
        this.service = service;
    }

    @GetMapping("")
    public String getCars(@RequestParam(required = false, defaultValue = "5") int count,
                          Model model) {
        if (count <= 0 || count > 5) {
            count = 5;
        }
        model.addAttribute("cars", service.getNCars(count));
        return "cars";
    }
}
