/**
 * 
 */
package id.co.store.code.service;

import java.math.BigDecimal;
import java.util.Map;

import id.co.store.code.domain.Billing;

/**
 * @author krisna Aug 11, 2017
 */
public interface BillingService {

	public static final float DISCOUNT_EMPLOYEE = 0.3F;
	public static final float DISCOUNT_AFFILATE = 0.1F;
	public static final float DISCOUNT_CUSTOMER = 0.05F;

	BigDecimal calculatePayableAmount(Map<String, Object> bilingMap);

	BigDecimal calculatePayableAmount(Billing billing);
}
