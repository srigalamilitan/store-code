/**
 * 
 */
package id.co.store.code.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.store.code.AppConstants.C_UserType;
import id.co.store.code.domain.Billing;
import id.co.store.code.domain.User;
import id.co.store.code.repository.UserRepository;
import id.co.store.code.service.BillingService;

/**
 * @author krisna Aug 11, 2017
 */
@Service
public class BillingServiceImpl implements BillingService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ObjectMapper objectMapper;

	public BigDecimal calculatePayableAmount(Map<String, Object> _billing) {
		return calculatePayableAmount((Billing) objectMapper.convertValue(_billing, Billing.class));
	}

	public BigDecimal calculatePayableAmount(Billing _bil) {
		User user = userRepository.findByUserId(_bil.getUserId());
		BigDecimal payableAmount = 1 != _bil.getProductType() ? calulateDiscountByUserType(user, _bil.getAmount())
				: _bil.getAmount();
		return payableAmount.subtract(calculateDiscountByAmount(_bil.getAmount())).setScale(2, RoundingMode.HALF_UP);
	}

	private BigDecimal calculateDiscountByAmount(BigDecimal _amount) {
		return BigDecimal.valueOf((int) (_amount.doubleValue() / 100.0D) * 5);
	}

	private BigDecimal calulateDiscountByUserType(User _user, BigDecimal _amount) {
		float discount = (C_UserType.CUSTOMER == _user.getUserType())
				&& (_user.getRegisterDate().plusYears(2L).isBefore(LocalDate.now())) ? DISCOUNT_CUSTOMER
						: C_UserType.AFFLIATE == _user.getUserType() ? DISCOUNT_AFFILATE
								: C_UserType.EMPLOYEE == _user.getUserType() ? DISCOUNT_EMPLOYEE : 0.0F;
		return _amount.subtract(_amount.multiply(BigDecimal.valueOf(discount)));
	}
}
