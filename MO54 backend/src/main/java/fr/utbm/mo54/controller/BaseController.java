package fr.utbm.mo54.controller;

import fr.utbm.mo54.dao.IPanierDao;
import fr.utbm.mo54.dao.IPieceDao;
import fr.utbm.mo54.model.PanierDomain;
import fr.utbm.mo54.model.PieceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @Autowired
    IPieceDao iPieceDao;

    @Autowired
    IPanierDao iPanierDao;

    @GetMapping("queryAllPieceByType")
    public List<PieceDomain> queryAllPieceByType(@RequestParam(value = "type1",required = true) String type1){
        return iPieceDao.getAllPieceByType(type1);
    }

    @GetMapping("queryAllPieceInPanier")
    public List<PanierDomain> queryAllPieceInPanier(){
        return iPanierDao.getAllPieceInPanier();
    }

    @PostMapping("addPieceToPanier")
    public void addPieceToPanier(@RequestParam(value = "pid",required = true) Integer pid,
                                 @RequestParam(value = "number",required = true) Integer number){
        iPanierDao.addPiece(pid,number);
    }

    @PostMapping("changeNumberOfPieceToPanier")
    public void changeNumberOfPieceToPanier(@RequestParam(value = "id",required = true) Integer id,
                                 @RequestParam(value = "number",required = true) Integer number){
        iPanierDao.changeNumber(id, number);
    }

    @PostMapping("deletePieceInPanier")
    public void deletePieceInPanier(@RequestParam(value = "id",required = true) Integer id){
        iPanierDao.deletePiece(id);
    }
}
