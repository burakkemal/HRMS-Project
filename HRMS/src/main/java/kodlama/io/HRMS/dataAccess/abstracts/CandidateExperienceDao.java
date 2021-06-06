package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer>{
	List<CandidateExperience> findByCandidateIdOrderByExperience_EndDateDesc(int candidateId);
	List<CandidateExperience>  findByCandidate_Id(int candidateId);
}
