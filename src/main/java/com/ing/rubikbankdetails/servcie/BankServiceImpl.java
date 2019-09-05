package com.ing.rubikbankdetails.servcie;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.rubikbankdetails.dto.BankDto;
import com.ing.rubikbankdetails.entity.BankDetails;
import com.ing.rubikbankdetails.exception.CommonException;
import com.ing.rubikbankdetails.repository.BankRepository;
import com.ing.rubikbankdetails.util.RubikConstants;

/**
 * 
 * @author HariPriya G
 * This class get the bank details based  on the bankCode
 *
 */

@Service
public class BankServiceImpl implements BankServcie {

	public static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

	@Autowired
	BankRepository bankRepository;

	/**
	 * 
	 * This method is intended to get the bank details by bankcode
	 * 
	 * @param accountNumber is the input request
	 * @return it returns BankDto object with bankName and bankCode
	 */

	@Override
	public BankDto getBankDetails(String bankCode) {
		logger.info("get the bank details service impl");

		Optional<BankDetails> bankDb = bankRepository.findByBankCode(bankCode);
		if (!bankDb.isPresent())
			throw new CommonException(RubikConstants.ERROR_BANK_CODE_EXIST);
		BankDto bankDto = new BankDto();
		BeanUtils.copyProperties(bankDb.get(), bankDto);

		return bankDto;
	}

}
