package com.traineemgmtapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.traineemgmtapp.entities.Trainee;
@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Integer> {
	@Query("Select t from Trainee t where name=:name")
	// if query annotation is there then whatever the method name is it doesd.t matter
	// query  me jo  =: iske baad jo name hai that should be same as param(name)
	public List<Trainee> findByName(@Param("name")String tname);
	

}
