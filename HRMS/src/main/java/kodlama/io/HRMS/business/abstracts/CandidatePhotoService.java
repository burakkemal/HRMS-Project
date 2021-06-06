package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidatePhoto;

public interface CandidatePhotoService {
	
	Result add(CandidatePhoto candidatePhoto);
	Result addCloudinary(CandidatePhoto candidatePhoto,MultipartFile file);
	DataResult<List<CandidatePhoto>> getAll();
	DataResult<List<CandidatePhoto>> findByCandidate_Id(int candidateId);
}
