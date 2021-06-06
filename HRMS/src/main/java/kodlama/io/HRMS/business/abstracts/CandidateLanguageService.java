package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	Result add(CandidateLanguage candidatelanguage);
	DataResult<List<CandidateLanguage>> getall();
	DataResult<List<CandidateLanguage>> findByCandidate_Id(int candidateId);
}
