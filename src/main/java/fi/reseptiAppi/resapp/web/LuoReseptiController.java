package fi.reseptiAppi.resapp.web;

import fi.reseptiAppi.resapp.domain.Resepti;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.reseptiAppi.resapp.domain.ReseptiRepository;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author jsaja
 */
@Controller
public class LuoReseptiController {

    @Autowired
    private ReseptiRepository reseptiRepository;

    @GetMapping(value = {"/luoresepti"})
    public String etusivu(Model model) {
        model.addAttribute("resepti", new Resepti());
        return "luoResepti";
    }
   
     /*************************************************************/
    /* Validi ensimmaiseksi ja ModelAttribute sen jälkeen luin, että järjestyksellä on väliä!*/
    @PostMapping("/luoresepti")
    public String luoresepti(@Valid @ModelAttribute() Resepti resepti, BindingResult tulos, Model model) {
        if (tulos.hasErrors()) {
            System.out.println("Virhe tapahtui");
            return "luoResepti";
        } else {
            model.addAttribute("resepti", resepti);
            reseptiRepository.save(resepti);
            return "redirect:/";
        }
    }
    
    /***************************************************************/
    
    
    /*  @PostMapping("/luoresepti")
    public String luoResepti(
            @RequestParam("reseptinnimi") String nimi,
            @RequestParam("ruokalaji") String ruokalaji,
            @RequestParam("ainekset") String ainekset,
            @RequestParam("annoskoko") int annoskoko,
            @RequestParam("valmistusaika") int valmistusaika,
            @RequestParam("valmistusohje") String valmistusohje,
            @RequestParam("vaikeustaso") String vaikeustaso,
            @RequestParam("kuva") MultipartFile kuva) throws IOException {
        
        System.out.println(ainekset);
        System.out.println(kuva.getSize());
        System.out.println(kuva.getContentType());

        Resepti resepti = new Resepti();
        resepti.setReseptinNimi(nimi);
        resepti.setRuokalaji(ruokalaji);

       ! String[] arrOfainekeset = ainekset.split(" ");

      !  for (String a : arrOfainekeset) {
       !     if (null == aineOsaRepository.findByAineOsa(a)) {
        !        resepti.getAineOsat().add(new AineOsa(a));
      !      } else {
         !       resepti.getAineOsat().add(aineOsaRepository.findByAineOsa(a));
          !  }
       ! }
        
        resepti.setAnnosKoko(annoskoko);
        resepti.setValmistusAika(valmistusaika);
        resepti.setVaikeusTaso(vaikeustaso);
        resepti.setValmistusOhje(valmistusohje);

        resepti.setKuva(kuva.getBytes());

        reseptiRepository.save(resepti);

        return "redirect:/";

    } */
}
