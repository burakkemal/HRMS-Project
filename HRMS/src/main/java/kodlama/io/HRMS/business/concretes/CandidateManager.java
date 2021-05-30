package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateService;
import kodlama.io.HRMS.core.utilities.business.BusinessRules;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.ErrorResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.services.abstracts.MernisCheckService;
import kodlama.io.HRMS.core.utilities.services.concretes.MernisCheckAdapter;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateDao;
import kodlama.io.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;	
	}

	@Override
	public DataResult<List<Candidate>> GetAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		Result result = BusinessRules.RunBusinessRules(mernisCheck(),checkEmailAdress(candidate.getMail()),
				checkNationalIdentity(candidate.getIdentificationNumber()), nullControl(candidate));
		if (result != null && !result.isSuccess()) {
			return result;
		}
		candidateDao.save(candidate);
		return new SuccessResult("Kayıt başarılı");
	}

	private Result checkNationalIdentity(String Tc) {

		if (this.candidateDao.findByidentificationNumberContaining(Tc).isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu Tc No Kullanılıyor.");
	}

	private Result checkEmailAdress(String mail) {

		if (this.candidateDao.findByMailContaining(mail).isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("Mail adresi kullanılıyor");
	}

	private Result nullControl(Candidate candidate) {
		if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentificationNumber().isEmpty() || candidate.getBirthDate().toString().isEmpty()
				|| candidate.getMail().isEmpty() || candidate.getPassword().isEmpty()) {
			return new ErrorResult("Alanlar bos birakilamaz!!");
		}
		return new SuccessResult();
	}
	private Result mernisCheck() {
		MernisCheckService mernis=new MernisCheckAdapter();
		mernis.checkIfRealPerson();
		return new SuccessResult();
	}

	

}
