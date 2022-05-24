package fr.utbm.mo54.controller;

import fr.utbm.mo54.dao.IPieceDao;
import fr.utbm.mo54.model.PieceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @Autowired
    IPieceDao iPieceDao;

    @GetMapping("queryAllPieceByType")
    public List<PieceDomain> queryAllPieceByType(@RequestParam(value = "type",required = true) Integer type){
        return iPieceDao.getAllPieceByType(type);
    }
}
