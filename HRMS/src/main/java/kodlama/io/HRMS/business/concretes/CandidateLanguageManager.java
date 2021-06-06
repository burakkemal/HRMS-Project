package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateLanguageService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateLanguageDao;
import kodlama.io.HRMS.entities.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService{
		private CandidateLanguageDao candidateLanguageDao;

		@Autowired
		public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
			super();
			this.candidateLanguageDao = candidateLanguageDao;
		}

		@Override
		public Result add(CandidateLanguage candidatelanguage) {
			candidateLanguageDao.save(candidatelanguage);
			return new SuccessResult();
		}

		@Override
		public DataResult<List<CandidateLanguage>> getall() {
			return new SuccessDataResult<List<CandidateLanguage>>(candidateLanguageDao.findAll());
		}

		@Override
		public DataResult<List<CandidateLanguage>> findByCandidate_Id(int candidateId) {
			return new SuccessDataResult<List<CandidateLanguage>>(candidateLanguageDao.findByCandidate_Id(candidateId));
		}
		
		
}
