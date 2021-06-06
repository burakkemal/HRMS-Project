package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.SchoolService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.SchoolDao;
import kodlama.io.HRMS.entities.concretes.School;


@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		 schoolDao.save(school);
		return new SuccessResult("Okul eklendi.");
	}

	@Override
	public DataResult<List<School>> getAll() {
		 
		return new SuccessDataResult<List<School>>(schoolDao.findAll(),"Okullar listelendi.");
	}
}
