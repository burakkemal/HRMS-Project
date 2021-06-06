package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.ExperienceService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.ExperienceDao;
import kodlama.io.HRMS.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{
	
 private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
	  experienceDao.save(experience);
		return new SuccessResult("İş tecrübesi eklendi.");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
	 
		return new SuccessDataResult<List<Experience>>(experienceDao.findAll(),"İş tecrübeleri listelendi.");
	}
}
