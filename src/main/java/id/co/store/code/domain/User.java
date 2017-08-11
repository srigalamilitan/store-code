/**
 * 
 */
package id.co.store.code.domain;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * @author krisna
 * Aug 11, 2017
 */
@Entity
@Table(name="USER")
@Data
public class User implements Serializable { 
  private static final long serialVersionUID = -7432884907307763375L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="USER_ID")
  private BigInteger userId;
  @Column(name="USER_NAME", length=30)
  private String userName;
  @Column(name="USER_TYPE")
  private int userType;
  @Column(name="REGISTER_DATE")
  private LocalDate registerDate;
}