package com.example.demo17.Repository;

import com.example.demo17.Models.LigneVenteModel;
import com.example.demo17.Models.VenteModel;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<VenteModel, Integer> {

    @Query(value = "select max(codevente) from vente", nativeQuery = true)
    int a();
    @Query(value="select * from lignevente where vente_id = :id", nativeQuery = true)
    List<LigneVenteModel> lu(@Param("id") int id);
}
