/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.reseptiAppi.resapp.web;

import fi.reseptiAppi.resapp.domain.Resepti;
import fi.reseptiAppi.resapp.domain.ReseptiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jsaja
 */
@RestController
public class RestReseptiController {

    @Autowired
    private ReseptiRepository reseptiRepository;

    @RequestMapping("/reseptit")
    public List<Resepti> reseptitRest() {
        return (List<Resepti>) reseptiRepository.findAll();
    }

    @GetMapping("/resepti/{ID}")
    public @ResponseBody Optional<Resepti> reseptiRest(@PathVariable("ID") Long ID) {
        return reseptiRepository.findById(ID);
    }
}
