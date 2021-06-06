package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.SocialMediaType;

public interface SocialMediaTypeService {
	Result add(SocialMediaType socialMedia);
	DataResult<List<SocialMediaType>> getAll();
}
