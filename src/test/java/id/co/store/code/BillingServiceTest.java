package id.co.store.code;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import id.co.store.code.domain.Billing;
import id.co.store.code.service.BillingService;

/**
 * @author krisna Aug 11, 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class BillingServiceTest {

	@Autowired
	private BillingService billingService;

	/**************************************************************
	 * Testing 
	 * 	Product : Non Groceries
	 * 	Amount  : $990
	 *  expected : User Discount And Price Discount 
	 */
	@Test
	public void calculateUserEmpoyeeAndNonGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(1L), 2, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 648.0D, value, 1.0D);
	}

	@Test
	public void calculateUserAffiliateAndNonGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(2L), 2, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 846.0D, value, 1.0D);
	}

	@Test
	public void calculateUserCustomerOldAndNonGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(3), 2, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 895.5D, value, 1.0D);
	}

	@Test
	public void calculateUserCustomerNewAndNonGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(4L), 2, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 945.0D, value, 1.0D);
	}

	/**************************************************************
	 * Testing 
	 * 	Product :  Groceries
	 * 	Amount  : $990
	 *  expected : Price Discount ONLY
	 */
	@Test
	public void calculateUserEmpoyeeAndGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(1L), 1, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 945.0D, value, 1.0D);
	}

	@Test
	public void calculateUserAffiliateAndGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(2L), 1, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 945.0D, value, 1.0D);
	}

	@Test
	public void calculateUserCustomerOldAndGrocerisProductWithAmount990() {
		Billing billing = new Billing(BigInteger.valueOf(3L), 1, BigDecimal.valueOf(990L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 945.0D, value, 1.0D);
	}
	/**************************************************************
	 * Testing 
	 * 	Product :  Groceries
	 * 	Amount  : $99
	 *  expected : NO DISCOUNT
	 */

	@Test
	public void calculateUserEmpoyeeAndGrocerisProductWithAmount99() {
		Billing billing = new Billing(BigInteger.valueOf(1L), 1, BigDecimal.valueOf(99L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 99.0D, value, 1.0D);
	}

	@Test
	public void calculateUserAffiliateAndGrocerisProductWithAmount99() {
		Billing billing = new Billing(BigInteger.valueOf(2L), 1, BigDecimal.valueOf(99L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 99.0D, value, 1.0D);
	}

	@Test
	public void calculateUserCustomerOldAndGrocerisProductWithAmount99() {
		Billing billing = new Billing(BigInteger.valueOf(3L), 1, BigDecimal.valueOf(99L));
		double value = billingService.calculatePayableAmount(billing).doubleValue();
		Assert.assertEquals("Check Value ", 99.0D, value, 1.0D);
	}

}
