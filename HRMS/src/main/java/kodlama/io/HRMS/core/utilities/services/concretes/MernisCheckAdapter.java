package kodlama.io.HRMS.core.utilities.services.concretes;



import org.springframework.stereotype.Service;

import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.services.abstracts.MernisCheckService;

@Service
public class MernisCheckAdapter implements MernisCheckService{

	
	@Override
	public Result checkIfRealPerson() {
		return new SuccessResult("Mernis Doğrulaması Gerçekleştirildi");
	}
	
}
