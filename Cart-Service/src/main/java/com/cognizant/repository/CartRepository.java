package com.cognizant.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Cart;


@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer> {

	@Modifying
	@Query(value="insert into cart(userid,id) values(?1,?2)",nativeQuery = true)
	public int insertCartItems(@Param("userid") Long userId,@Param("id") Long id);

	@Query(value = "select * from cart  where userid=:userid", nativeQuery = true)
	public  List<Cart> findById(@Param("userid") Long userid);

	@Modifying
	@Query(value = "DELETE FROM cart  WHERE id = :id", nativeQuery = true)
	public int deleteById(@Param("id") Long id);

	


}
