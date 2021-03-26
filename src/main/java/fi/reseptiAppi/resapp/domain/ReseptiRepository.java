package fi.reseptiAppi.resapp.domain;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author jsaja
 */

public interface ReseptiRepository extends JpaRepository<Resepti, Long> {
    List<Resepti> findByReseptinNimiContainingIgnoreCase(String reseptinNimi);
    List<Resepti> findByRuokalajiContainingIgnoreCase(String ruokalaji);
}
