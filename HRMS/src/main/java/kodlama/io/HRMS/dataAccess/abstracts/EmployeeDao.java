package kodlama.io.HRMS.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.HRMS.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	@Modifying
    @Transactional
    @Query(value = "update employers set is_verify = true where id = (:id)", nativeQuery = true)
   public void activeEmployee(@Param("id") int id);
}
