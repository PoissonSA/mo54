package fr.utbm.mo54.dao;

import fr.utbm.mo54.model.PanierDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPanierDao extends JpaRepository<PanierDomain,Integer> {

    @Query(nativeQuery=true, value ="select * from panier p where p.user=:user")
    List<PanierDomain> getAllPieceInPanier(@Param("user") String user);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value ="insert into panier (pid,number,brand,user) " +
            "values (:pid, :number, :brand, :user) ")
    int addPiece(@Param("pid") Integer pid,
                 @Param("number") Integer number,
                 @Param("brand") String brand,
                 @Param("user") String user
    );

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value ="update panier p set p.number=:number where p.id=:id")
    int changeNumber(@Param("id") Integer id, @Param("number") Integer number);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value ="delete from panier p where p.id=:id")
    int deletePiece(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value ="delete from panier p where p.user=:user")
    void deleteAll(@Param("user") String user);
}
