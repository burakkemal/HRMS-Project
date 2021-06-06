package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateSocialMediaService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateSocialMediaDao;
import kodlama.io.HRMS.entities.concretes.CandidateSocialMedia;

@Service
public class CandidateSocialMediaManager implements CandidateSocialMediaService {
	
	private CandidateSocialMediaDao candidateSocialMediaDao;

	@Autowired
	public CandidateSocialMediaManager(CandidateSocialMediaDao candidateSocialMediaDao) {
		super();
		this.candidateSocialMediaDao = candidateSocialMediaDao;
	}

	@Override
	public Result add(CandidateSocialMedia candidateSocialMedia) {
		candidateSocialMediaDao.save(candidateSocialMedia);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateSocialMedia>> getAll() {
		return new SuccessDataResult<List<CandidateSocialMedia>>(candidateSocialMediaDao.findAll());
	}

	@Override
	public DataResult<List<CandidateSocialMedia>> findByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateSocialMedia>>(this.candidateSocialMediaDao.findByCandidate_Id(candidateId));
	}
	
	
}
