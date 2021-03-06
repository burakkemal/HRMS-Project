package kodlama.io.HRMS.core.utilities.cloudinary;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.ErrorDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;


@Service
public class CloudinaryManager implements ImageService{
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return new ErrorDataResult<Map>("Cannot added!");
	}
	
}
