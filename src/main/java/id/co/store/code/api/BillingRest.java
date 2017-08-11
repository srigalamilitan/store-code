/**
 * 
 */
package id.co.store.code.api;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.store.code.service.BillingService;

/**
 * @author krisna Aug 11, 2017
 */
@RestController
@RequestMapping({"/rest"})
public class BillingRest {
	@Autowired
	BillingService billingService;

	public BillingRest() {
	}

	@RequestMapping(value = { "/calculatePayable/v1" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	public ResponseEntity<BigDecimal> calculateAmount(@RequestBody Map<String, Object> _billing) {
		return new ResponseEntity<BigDecimal>(billingService.calculatePayableAmount(_billing), HttpStatus.OK);
	}
}
