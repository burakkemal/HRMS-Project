package kodlama.io.HRMS.core.utilities.services.concretes;

import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.services.abstracts.EmailCheckService;

import java.util.regex.Pattern;
public class EmailCheckManager implements EmailCheckService{

	private String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	@Override
	public Result check(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		pattern.matcher(email).find();
		return new SuccessResult();		
	}
 
}
