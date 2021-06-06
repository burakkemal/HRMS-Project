package kodlama.io.HRMS.core.utilities.cloudinary;



import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<?> save(MultipartFile file);
}
