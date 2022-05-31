package fr.utbm.mo54.dao;

import fr.utbm.mo54.model.OrderDomain;
import fr.utbm.mo54.model.PanierDomain;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderDao extends JpaRepository<OrderDomain,Integer> {
    @Query(nativeQuery=true, value ="select * from `order`")
    List<OrderDomain> getAllOrder();

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value ="insert into `order` (pid,number,brand,time) " +
            "values (:pid, :number, :brand, :time) ")
    int addOrder(@Param("pid") Integer pid,
                 @Param("number") Integer number,
                 @Param("brand") String brand,
                 @Param("time") String time
    );
}
