package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import zavrsni.devopstrk.model.Zadatak;

import java.util.List;

@Transactional
public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {

    List<Zadatak> findByIdZahtjeva(String idZahtjeva);

    List<Zadatak> findByProjekt_IdProjekta(Long idProjekta);

    Zadatak findByIdZadatka(Long idZadatka);

    void deleteZadatakByIdZahtjeva(String idZahtjeva);

    void deleteZadatakByIdZadatka(Long idZadatka);

    @Query("SELECT z FROM Zadatak z WHERE z.projekt.idProjekta = :idProjekta AND lower(z.nazivZadatka) LIKE lower(concat('%', :trazi, '%')) OR z.projekt.idProjekta = :idProjekta AND lower(z.opisZadatka) LIKE lower(concat('%', :trazi, '%')) OR z.projekt.idProjekta = :idProjekta AND lower(z.izvrsitelj.ime) LIKE lower(concat('%', :trazi, '%')) OR z.projekt.idProjekta = :idProjekta AND lower(z.izvrsitelj.prezime) LIKE lower(concat('%', :trazi, '%')) OR z.projekt.idProjekta = :idProjekta AND lower(z.prioritet.nazivPrioriteta) LIKE lower(concat('%', :trazi, '%')) OR z.projekt.idProjekta = :idProjekta AND lower(z.stanje.nazivStanja) LIKE lower(concat('%', :trazi, '%'))")
    List<Zadatak> findProjektZadaciTrazi(@Param("idProjekta") Long idProjekta, @Param("trazi") String trazi);

    @Query("SELECT count(z) FROM Zadatak z WHERE z.idZahtjeva = :idZahtjeva AND z.stanje.idStanja = 3")
    int findBrojZavrsenih(@Param("idZahtjeva") String idZahtjeva);

    @Query("SELECT count(z) FROM Zadatak z WHERE z.idZahtjeva = :idZahtjeva AND z.stanje.idStanja = 1 OR z.idZahtjeva = :idZahtjeva AND z.stanje.idStanja = 2")
    int findBrojNezavrsenih(@Param("idZahtjeva") String idZahtjeva);

    List<Zadatak> findByProjekt_IdProjektaAndIzvrsitelj_IdKorisnika(Long idProjekta, Long idKorisnika);
}
