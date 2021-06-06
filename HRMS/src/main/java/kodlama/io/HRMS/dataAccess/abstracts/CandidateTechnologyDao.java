package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyDao extends JpaRepository<CandidateTechnology, Integer> {
	List<CandidateTechnology> findByCandidate_Id(int candidateId);
}
