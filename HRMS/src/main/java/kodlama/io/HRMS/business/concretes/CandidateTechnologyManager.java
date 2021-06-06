package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateTechologyService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateTechnologyDao;
import kodlama.io.HRMS.entities.concretes.CandidateTechnology;

@Service
public class CandidateTechnologyManager implements CandidateTechologyService {

	private CandidateTechnologyDao candidateTechnologyDao;
	
	@Autowired
	public CandidateTechnologyManager(CandidateTechnologyDao candidateTechnologyDao) {
		super();
		this.candidateTechnologyDao = candidateTechnologyDao;
	}

	@Override
	public Result add(CandidateTechnology candidateTechnology) {
		
		candidateTechnologyDao.save(candidateTechnology);
		return new SuccessResult();
		
	}

	@Override
	public DataResult<List<CandidateTechnology>> getAll() {
		return new SuccessDataResult<List<CandidateTechnology>>(this.candidateTechnologyDao.findAll());
	}

	@Override
	public DataResult<List<CandidateTechnology>> findByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateTechnology>>(candidateTechnologyDao.findByCandidate_Id(candidateId));
		
	}

}
