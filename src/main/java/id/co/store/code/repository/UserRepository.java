/**
 * 
 */
package id.co.store.code.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import id.co.store.code.domain.User;

/**
 * @author krisna
 * Aug 11, 2017
 */
@Repository
public interface UserRepository extends CrudRepository<User, BigInteger>{
	public abstract User findByUserId(BigInteger _userId);
}
