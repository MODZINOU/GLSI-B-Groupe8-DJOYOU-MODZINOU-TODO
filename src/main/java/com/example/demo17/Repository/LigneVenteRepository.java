package com.example.demo17.Repository;

import com.example.demo17.Models.LigneVenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVenteModel, Integer> {

    LigneVenteModel findAllByventeId(int venteId);
    LigneVenteModel existsByventeId(int venteId);

    @Transactional
    @Query(value = "select sum(l.quantite * p.prix) from produits p inner join lignevente l on l.produit_id = p.id where vente_id= :vente_id ", nativeQuery = true)
    String b(@Param("vente_id") int id);

    @Query(value="select * from lignevente where vente_id = :id", nativeQuery = true)
    List<LigneVenteModel> lu(@Param("id") int id);
}
