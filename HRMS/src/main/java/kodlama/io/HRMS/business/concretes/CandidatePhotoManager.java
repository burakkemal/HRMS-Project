package kodlama.io.HRMS.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.business.abstracts.CandidatePhotoService;
import kodlama.io.HRMS.core.utilities.cloudinary.ImageService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidatePhotoDao;
import kodlama.io.HRMS.entities.concretes.CandidatePhoto;

@Service
public class CandidatePhotoManager implements CandidatePhotoService {
	private CandidatePhotoDao candidatePhotoDao;
	private ImageService imageService;

	@Autowired
	public CandidatePhotoManager(CandidatePhotoDao candidatePhotoDao, ImageService imageService) {
		super();
		this.candidatePhotoDao = candidatePhotoDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CandidatePhoto candidatePhoto) {
		candidatePhotoDao.save(candidatePhoto);
		return new SuccessResult();
	}

	@Override
	public Result addCloudinary(CandidatePhoto candidatePhoto, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageService.save(file).getData();
        String url = result.get("url");
        candidatePhoto.setPhotoLink(url);        
       add(candidatePhoto);
       return new SuccessResult("Fotoğraf başarıyla yüklendi.");
	}

	@Override
	public DataResult<List<CandidatePhoto>> getAll() {
		return new SuccessDataResult<List<CandidatePhoto>>(candidatePhotoDao.findAll());
	}

	@Override
	public DataResult<List<CandidatePhoto>> findByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidatePhoto>>(candidatePhotoDao.findByCandidate_Id(candidateId));
	}

}
