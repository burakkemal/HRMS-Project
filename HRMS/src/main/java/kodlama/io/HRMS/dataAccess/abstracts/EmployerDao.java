package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.HRMS.entities.concretes.Employer;
import kodlama.io.HRMS.entities.concretes.User;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<User> findByMailContaining(String mail);
	
	@Modifying
    @Transactional
    @Query(value = "update job_advertisement set is_active = false where id = (:id)", nativeQuery = true)
   public void activeEmployer(@Param("id") int id);
}
