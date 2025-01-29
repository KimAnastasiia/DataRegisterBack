package com.uniovi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uniovi.entities.Indice;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IndiceRepository  extends JpaRepository<Indice, Integer> {
}
