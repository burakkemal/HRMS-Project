package kodlama.io.HRMS.core.utilities.services.concretes;



import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.services.abstracts.MernisCheckService;


public class MernisCheckAdapter implements MernisCheckService{

	@Override
	public Result checkIfRealPerson() {
		return new SuccessResult("Mernis Doğrulaması Gerçekleştirildi");
	}
	
}
