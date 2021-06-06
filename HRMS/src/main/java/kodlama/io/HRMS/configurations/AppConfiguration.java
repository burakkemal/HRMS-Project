package kodlama.io.HRMS.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.HRMS.core.utilities.cloudinary.CloudinaryManager;
import kodlama.io.HRMS.core.utilities.cloudinary.ImageService;

@Configuration
public class AppConfiguration {
	
	  @Bean
	    public Cloudinary cloudinaryService(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "dacwowmz3",
	                "api_key", "658158954695385",
	                "api_secret", "32vdvXqJ1MwBqQj8hXz-iM8fTMs"));
	    }

	    @Bean
	    public ImageService imageService(){
	        return new CloudinaryManager(cloudinaryService());
	    }
}
