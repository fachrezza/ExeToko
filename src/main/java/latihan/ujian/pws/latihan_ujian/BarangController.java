/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan.ujian.pws.latihan_ujian;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A S U S
 */

@RestController
@ResponseBody
@RequestMapping("/toko")
public class BarangController {
    Barang data = new Barang ();
    BarangJpaController actrl = new BarangJpaController();
    
    @RequestMapping("/getnama/{id}")
    public String getName(@PathVariable("id") int id) {
        try{
            data = actrl.findBarang(id);
            return data.getNamaBarang()+ "<br>" + data.getJumlahBarang();
        }
        catch (Exception error){return "error";}
        
    }
    //HAPUS
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        try{
            actrl.destroy(id);
            return id + "Product is deleted successsfully";
        }
        catch (Exception error){return "Product deleted is error";}
    }
}