package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.JobService;
import kodlama.io.HRMS.core.utilities.business.BusinessRules;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.ErrorResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlama.io.HRMS.entities.concretes.JobTitle;

@Service
public class JobManager implements JobService {

	private JobTitleDao jobDao;

	@Autowired
	public JobManager(JobTitleDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobDao.findAll(),"İş pozisyonları listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		Result result=BusinessRules.RunBusinessRules(CheckTitle(jobTitle.getTitle()));
		if (result!=null&&!result.isSuccess()) {
			return result;
		}
		jobDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi");
	}
	private Result CheckTitle(String title) {
		if (jobDao.findByTitleContaining(title).isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu iş pozisyonu mevcut");
	}

}
