package kodlama.io.HRMS.core.utilities.business;

import kodlama.io.HRMS.core.utilities.results.Result;

public class BusinessRules {
    public static Result RunBusinessRules(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess())
                return logic;
            //list yapısı olustur
        }
        return null;
    }
}


