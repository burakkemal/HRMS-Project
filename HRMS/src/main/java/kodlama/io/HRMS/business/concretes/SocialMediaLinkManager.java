package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.SocialMediaLinkService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.SocialMediaLinkDao;
import kodlama.io.HRMS.entities.concretes.SocialMediaLink;

@Service
public class SocialMediaLinkManager implements SocialMediaLinkService{
	
	private SocialMediaLinkDao socialMediaLinkDao;

	@Autowired
	public SocialMediaLinkManager(SocialMediaLinkDao socialMediaLinkDao) {
		super();
		this.socialMediaLinkDao = socialMediaLinkDao;
	}

	@Override
	public Result add(SocialMediaLink socialMediaLink) {
		socialMediaLinkDao.save(socialMediaLink);
		return new SuccessResult("Sosyal medya linki eklendi");
	}

	@Override
	public DataResult<List<SocialMediaLink>> getAll() {
		return new SuccessDataResult<List<SocialMediaLink>>(socialMediaLinkDao.findAll());
	}
	
	
	
}
