package fr.utbm.mo54.controller;

import fr.utbm.mo54.dao.IOrderDao;
import fr.utbm.mo54.dao.IPanierDao;
import fr.utbm.mo54.dao.IPieceDao;
import fr.utbm.mo54.model.OrderDomain;
import fr.utbm.mo54.model.PanierDomain;
import fr.utbm.mo54.model.PieceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BaseController {

    @Autowired
    IPieceDao iPieceDao;

    @Autowired
    IPanierDao iPanierDao;

    @Autowired
    IOrderDao iOrderDao;

    public String queryCurTime(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        return ft.format(dNow);
    }

    @GetMapping("queryHighestRatePiece")
    public List<PieceDomain> queryHighestRatePiece(){
        return iPieceDao.getHighestRatePiece();
    }

    @GetMapping("queryAllPieceByType")
    public List<PieceDomain> queryAllPieceByType(@RequestParam(value = "type1",required = true) String type1){
        return iPieceDao.getAllPieceByType(type1);
    }

    @GetMapping("queryAllPieceInPanier")
    public List<PanierDomain> queryAllPieceInPanier(@RequestParam(value = "user",required = true) String user){
        return iPanierDao.getAllPieceInPanier(user);
    }

    @GetMapping("queryAllOrder")
    public List<OrderDomain> queryAllOrder(@RequestParam(value = "user",required = true) String user){
        return iOrderDao.getAllOrder(user);
    }

    @PostMapping("addPieceToPanier")
    public void addPieceToPanier(@RequestParam(value = "pid",required = true) Integer pid,
                                 @RequestParam(value = "number",required = true) Integer number,
                                 @RequestParam(value = "brand",required = true) String brand,
                                 @RequestParam(value = "user",required = true) String user){
        iPanierDao.addPiece(pid,number,brand,user);
    }

    @PostMapping("commitOrder")
    public void commitOrder(@RequestParam(value = "user",required = true) String user){
        List<PanierDomain> datas=iPanierDao.getAllPieceInPanier(user);
        String time=queryCurTime();
        for(PanierDomain data:datas){
            iOrderDao.addOrder(data.getPid(),data.getNumber(),data.getBrand(),time,user);
        }
        iPanierDao.deleteAll(user);
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
