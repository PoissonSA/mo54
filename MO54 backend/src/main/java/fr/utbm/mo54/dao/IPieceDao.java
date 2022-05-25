package fr.utbm.mo54.dao;

import fr.utbm.mo54.model.PieceDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPieceDao extends JpaRepository<PieceDomain,Integer> {

    @Query(nativeQuery=true, value ="select * from piece p where p.type=:type")
    List<PieceDomain> getAllPieceByType(@Param(value = "type") String type);

}
