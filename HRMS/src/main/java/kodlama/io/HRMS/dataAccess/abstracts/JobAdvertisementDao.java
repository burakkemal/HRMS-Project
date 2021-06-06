package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> findByIsActiveTrue();
	List<JobAdvertisement> findByIsActiveTrueOrderByCreationDateDesc();
	List<JobAdvertisement> findByIsActiveTrueAndEmployerId(int employerId);
	
//	@Query("Select New kodlama.io.HRMS.entities.dtos.JobAdvertisementWithCity(j.id,j.description,j.minSalary,j.maxSalary,j.creationDate,j.deadlineDate,j.openPositonNumber,c.cityName)" 
//			            + " From JobAdvertisement j Inner Join j.city c ")   
//			List<JobAdvertisementWithCity> getJobAdvertisementWithCity();
	
}
