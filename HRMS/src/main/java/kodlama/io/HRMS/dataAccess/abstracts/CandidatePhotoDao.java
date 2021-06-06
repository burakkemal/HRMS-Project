package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.HRMS.entities.concretes.CandidatePhoto;

public interface CandidatePhotoDao extends JpaRepository<CandidatePhoto, Integer> {
	List<CandidatePhoto> findByCandidate_Id(int candidateId);
}
