package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {


	Result add(CandidateExperience candidateExperience);
	DataResult<List<CandidateExperience>> getAll();
	DataResult<List<CandidateExperience>>  findByCandidateIdOrderByEndDateDesc(int candidateId);
	DataResult<List<CandidateExperience>> findByCandidate_Id(int candidateId);
}
