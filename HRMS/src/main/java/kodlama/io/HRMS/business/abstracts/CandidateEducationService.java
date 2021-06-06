package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateEducation;

public interface CandidateEducationService {
	Result add(CandidateEducation candidateEducation);
	DataResult<List<CandidateEducation>> getAll();
	DataResult<List<CandidateEducation>> findByCandidateIdOrderByEndDate(int candidateId);
	DataResult<List<CandidateEducation>> findByCandidate_Id(int candidateId);
}
