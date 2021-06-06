package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateTechnology;

public interface CandidateTechologyService {
	Result add(CandidateTechnology candidateTechnology);
	DataResult<List<CandidateTechnology>> getAll();
	DataResult<List<CandidateTechnology>> findByCandidate_Id(int candidateId);
}
