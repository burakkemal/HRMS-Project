package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	DataResult<List<Experience>> getAll();
}
