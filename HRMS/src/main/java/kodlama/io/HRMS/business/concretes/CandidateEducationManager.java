package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateEducationService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateEducationDao;
import kodlama.io.HRMS.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService{
	
	private CandidateEducationDao candidateEducationDao;

	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		candidateEducationDao.save(candidateEducation);
		return new SuccessResult("Eğitim bilgileri Eklendi");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll(),"Eğitim bilgileri listelendi");
	}

	@Override
	public DataResult<List<CandidateEducation>> findByCandidateIdOrderByEndDate(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(candidateEducationDao.findByCandidateIdOrderByEndDate(candidateId));
	}

	@Override
	public DataResult<List<CandidateEducation>> findByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(candidateEducationDao.findByCandidate_Id(candidateId));
	}
}
