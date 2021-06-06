package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.HRMS.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer> {
	List<CandidateEducation> findByCandidateIdOrderByEndDate(int candidateId);
	List<CandidateEducation> findByCandidate_Id(int candidateId);
}
