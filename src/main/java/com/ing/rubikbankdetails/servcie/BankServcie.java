package com.ing.rubikbankdetails.servcie;

import com.ing.rubikbankdetails.dto.BankDto;

public interface BankServcie {
	
	BankDto getBankDetails(String accountNumber);

}
