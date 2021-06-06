package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateSocialMedia;

public interface CandidateSocialMediaService {
	
	Result add(CandidateSocialMedia candidateSocialMedia);
	DataResult<List<CandidateSocialMedia>> getAll();
	DataResult<List<CandidateSocialMedia>> findByCandidate_Id(int candidateId);
}
