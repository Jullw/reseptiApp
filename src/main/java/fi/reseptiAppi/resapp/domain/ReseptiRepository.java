package fi.reseptiAppi.resapp.domain;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author jsaja
 */

public interface ReseptiRepository extends CrudRepository <Resepti, Long> {
    List<Resepti> findByReseptinNimiContainingIgnoreCase(String reseptinNimi);
    List<Resepti> findByRuokalajiContainingIgnoreCase(String ruokalaji);
}
