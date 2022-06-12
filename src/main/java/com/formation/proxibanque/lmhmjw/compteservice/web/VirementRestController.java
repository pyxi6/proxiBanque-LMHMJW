package com.formation.proxibanque.lmhmjw.compteservice.web;


import com.formation.proxibanque.lmhmjw.compteservice.dtos.VirementRequestDTO;
import com.formation.proxibanque.lmhmjw.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirementRestController {

    //faut passer par la couche service

    @Autowired
    private CompteService compteService;

    @PutMapping(path = "comptes/virement")
    // @requestBody car je recoi les donnees dans le corp de la requet
    public  void virement(@RequestBody VirementRequestDTO request){

        compteService.virement(request.getCodeSource(),
                                request.getCodeDestination(), request.getMontant());

    }


}
