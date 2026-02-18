package com.traineemgmtapp.service;

import java.util.List;

//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.traineemgmtapp.entities.Trainee;
import com.traineemgmtapp.exceptions.ResourceNotFoundException;
import com.traineemgmtapp.repo.TraineeRepo;



@Service
@Transactional

public class TraineeServiceImpl implements TraineeService {
	private TraineeRepo traineeRepo;

	@Override
	public List<Trainee> getAll() {
		return traineeRepo.findAll();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		traineeRepo.save(trainee);
		return trainee;
	}

	@Override
	public Trainee getById(int id) {
		
		return traineeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("trainee not found"));
	}

	@Override
	public Trainee updateTrainee(int id, Trainee trainee) {
		Trainee traineeToUpdate = getById(id);
		traineeToUpdate.setMarks(trainee.getMarks());
		traineeRepo.save(traineeToUpdate);
		return traineeToUpdate;
	}

	@Override
	public Trainee deleteTainee(int id) {
		Trainee traineeToDelete = getById(id);
		traineeRepo.delete(traineeToDelete);
		return traineeToDelete;
	}

	@Override
	public List<Trainee> getByName(String name) {
		// TODO Auto-generated method stub
		return traineeRepo.findByName(name);
	}
	

}
