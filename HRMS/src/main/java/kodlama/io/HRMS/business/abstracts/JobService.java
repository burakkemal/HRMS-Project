package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.JobTitle;

public interface JobService {
	DataResult<List<JobTitle>>	getAll();
	Result add(JobTitle jobTitle);
	
}
