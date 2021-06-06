package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
