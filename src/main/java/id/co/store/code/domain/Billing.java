/**
 * 
 */
package id.co.store.code.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author krisna Aug 11, 2017
 */
@Data
@AllArgsConstructor
public class Billing {
	private BigInteger userId;
	private int productType;
	private BigDecimal amount;
}
