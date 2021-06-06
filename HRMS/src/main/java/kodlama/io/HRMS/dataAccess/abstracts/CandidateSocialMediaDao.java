package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.CandidateSocialMedia;

public interface CandidateSocialMediaDao extends JpaRepository<CandidateSocialMedia, Integer> {
	List<CandidateSocialMedia> findByCandidate_Id(int candidateId);
}
