package kodlama.io.HRMS.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.Experience;

public interface ExperienceDao  extends JpaRepository<Experience, Integer>{
	
}
