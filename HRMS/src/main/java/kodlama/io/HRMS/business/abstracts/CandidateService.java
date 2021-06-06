package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.Candidate;
import kodlama.io.HRMS.entities.dtos.CvDetailDto;


public interface CandidateService {
	DataResult<List<Candidate>> GetAll();
	Result add(Candidate candidate);	
	DataResult<CvDetailDto> getDetailCandidateeCv(int candidateId);
}
