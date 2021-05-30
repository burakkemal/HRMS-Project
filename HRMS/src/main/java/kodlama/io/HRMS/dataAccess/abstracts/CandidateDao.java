package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.Candidate;
import kodlama.io.HRMS.entities.concretes.User;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	List<User> findByMailContaining(String mail);
	List<Candidate> findByidentificationNumberContaining(String identificationNumber);
}
