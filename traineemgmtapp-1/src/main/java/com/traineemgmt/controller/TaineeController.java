package com.traineemgmt.controller;


import org.springframework.web.bind.annotation.*;

import com.traineemgmt.entities.Trainee;
import com.traineemgmt.service.TraineeService;

@RestController
@RequestMapping("/trainees")
public class TaineeController {

    private final TraineeService traineeService;

    public TaineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @PostMapping
    public Trainee addTrainee(@RequestBody Trainee trainee) {
        traineeService.addTrainee(trainee);
        return trainee;
    }

    @GetMapping("/{id}")
    public Trainee getTrainee(@PathVariable int id) {
        return traineeService.getById(id);
    }
}
 


