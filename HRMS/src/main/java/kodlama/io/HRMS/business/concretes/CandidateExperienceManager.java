package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateExperienceService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateExperienceDao;
import kodlama.io.HRMS.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {
	private CandidateExperienceDao candidateExperienceDao;

	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
		super();
		this.candidateExperienceDao = candidateExperienceDao;
	}

	@Override
	public Result add(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<List<CandidateExperience>>(candidateExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CandidateExperience>> findByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(candidateExperienceDao.findByCandidateIdOrderByExperience_EndDateDesc(candidateId));
	}

	@Override
	public DataResult<List<CandidateExperience>> findByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(candidateExperienceDao.findByCandidate_Id(candidateId));
	}
		
}
