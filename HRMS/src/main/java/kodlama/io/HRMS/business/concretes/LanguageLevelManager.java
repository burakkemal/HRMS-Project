package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.LanguageLevelService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.LanguageLevelDao;
import kodlama.io.HRMS.entities.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService {

	private LanguageLevelDao languageLevelDao;
	
	@Autowired
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		super();
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public Result add(LanguageLevel languageLevel) {
		 languageLevelDao.save(languageLevel);
		return new SuccessResult("Dil seviyesi eklendi.");
	}

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		 
		return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll(),"Dil seviyeleri listelendi.");
	}
}
