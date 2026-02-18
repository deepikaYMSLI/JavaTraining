package com.traineemgmtapp.service;

import java.util.List;

import com.traineemgmtapp.entities.Trainee;

public interface TraineeService {
	public List<Trainee> getAll();
	public Trainee addTrainee(Trainee trainee);
	public Trainee getById(int id);
	public Trainee updateTrainee(int id, Trainee trainee);
	public Trainee deleteTainee(int id);
	public List<Trainee> getByName(String name);
	
	
	

}
