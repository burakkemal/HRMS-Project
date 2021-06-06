package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.SocialMediaTypeService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.SocialMediaTypeDao;
import kodlama.io.HRMS.entities.concretes.SocialMediaType;

@Service
public class SocialMediaTypeManager implements SocialMediaTypeService {
	private SocialMediaTypeDao socialMediaDao;
	
	@Autowired
	public SocialMediaTypeManager(SocialMediaTypeDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public Result add(SocialMediaType socialMedia) {
		socialMediaDao.save(socialMedia);
		return new SuccessResult("Sosyal medya hesabı eklendi.");
	}

	@Override
	public DataResult<List<SocialMediaType>> getAll() {
	 
		return new SuccessDataResult<List<SocialMediaType>>(socialMediaDao.findAll(),"Sosyal medya hesapları listelendi.");
	}
}
