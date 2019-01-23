package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long>, DistilleryRepositoryCustom {

	List<Distillery> getDistilleryByRegion(String region);
//	List<Whisky> findWhiskiesFromDistilleriesWithAge(Integer age);
	List<Distillery> findDistilleryByName(String distillery);
	List<Whisky> findWhiskiesFromDistilleriesWithAge(String name, Integer age);
}
