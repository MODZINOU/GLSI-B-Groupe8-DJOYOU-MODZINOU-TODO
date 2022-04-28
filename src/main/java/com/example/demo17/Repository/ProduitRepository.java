package com.example.demo17.Repository;

import com.example.demo17.Models.ProduitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitModel, Integer> {

   /* @Modifying
    @Transactional
    @Query(value = "update produits p set p.qtstock =p.qtstock+:qte where p.id=:id", nativeQuery = true)
            void updateQteProduit(@Param("id") int id, @Param("qte") int qte);*/
}
