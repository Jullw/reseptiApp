package fi.reseptiAppi.resapp.web;

import fi.reseptiAppi.resapp.domain.Resepti;
import fi.reseptiAppi.resapp.domain.ReseptiRepository;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jsaja
 */
@Controller
public class etusivuController {

    @Autowired
    private ReseptiRepository reseptiRepository;

    @GetMapping(value = {"/", "etusivu", "koti"})
    public String etusivu(Model model) {

        model.addAttribute("listaResepteista", reseptiRepository.findAll());
        return "etusivu";
    }

    @PostMapping("/hae")
    public String hae(@RequestParam("hae") String hakunimi, Model model) {
        System.out.println(hakunimi);

        if (!hakunimi.isEmpty()) {
            model.addAttribute("listaResepteista", reseptiRepository.findByReseptinNimiContainingIgnoreCase(hakunimi));

        } else {
            model.addAttribute("listaResepteista", reseptiRepository.findAll());
        }

        return "etusivu";
    }

    @GetMapping(value = "/poista/{ID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String poistaResepti(@PathVariable("ID") Long reseptiID, Model model) {
        reseptiRepository.deleteById(reseptiID);
        return "redirect:../etusivu";
    }

    @GetMapping("/muokkaareseptia/{ID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String muutaReseptia(@PathVariable("ID") Long ID, Model model) {
        Resepti resepti = reseptiRepository.findById(ID).get();
        model.addAttribute("resepti", resepti);
        return "muokkaaResepti";
    }

    @PostMapping("/tallennnaMuokattuResepti")
    public String tallennnaMuokattuResepti(Resepti resepti) {
        reseptiRepository.save(resepti);
        return "redirect:etusivu";
    }

}
