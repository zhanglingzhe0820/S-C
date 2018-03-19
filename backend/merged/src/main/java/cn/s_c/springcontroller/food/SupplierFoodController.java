package cn.s_c.springcontroller.food;

import cn.s_c.blservice.food.SupplierFoodBlService;
import cn.s_c.blservice.supplier.SupplierBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodEditableReturnVo;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import cn.s_c.vo.food.SupplierFoodUpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SupplierFoodController {
    @Autowired
    private SupplierFoodBlService supplierFoodBlService;
    @Autowired
    private SupplierBlService supplierBlService;

    @RequestMapping(method = RequestMethod.POST, path = "/uploadImage", produces = "application/json")
    @ResponseBody
    public String uploadImage(@RequestParam("foodImage") MultipartFile multipartFile) {
        try {
            return supplierFoodBlService.uploadImage(multipartFile.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/saveSupplierFood", produces = "application/json")
    @ResponseBody
    public ResultMessage saveSupplierFood(@RequestParam(name = "name") String name, @RequestParam(name = "price") double price, @RequestParam(name = "url") String url, @RequestParam(name = "hasChoice") boolean hasChoice, @RequestParam(name = "choice") String[] choice, @RequestParam(name = "supplierUsername") String supplierUsername) {
        return supplierFoodBlService.saveSupplierFood(new SupplierFoodSaveVo(name, price, url, hasChoice, choice, supplierBlService.getSupplierByUsername(supplierUsername)));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getSupplierFoodBySupplierUsername", produces = "application/json")
    @ResponseBody
    public SupplierFoodReturnVo[] getSupplierFoodBySupplierUsername(@RequestParam("supplierUsername") String supplierUsername) {
        return supplierFoodBlService.getSupplierFoodBySupplierUsername(supplierUsername);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/loadSupplierFoodById", produces = "application/json")
    @ResponseBody
    public SupplierFoodEditableReturnVo loadSupplierFoodById(@RequestParam("supplierFoodId") int supplierFoodId) {
        return supplierFoodBlService.loadSupplierFoodById(supplierFoodId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateSupplierFood", produces = "application/json")
    @ResponseBody
    public ResultMessage updateSupplierFood(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name, @RequestParam(name = "price") double price, @RequestParam(name = "url") String url, @RequestParam(name = "hasChoice") boolean hasChoice, @RequestParam(name = "choice") String[] choice, @RequestParam(name = "supplierUsername") String supplierUsername) {
        return supplierFoodBlService.updateSupplierFood(new SupplierFoodUpdateVo(id, name, price, url, hasChoice, choice, supplierBlService.getSupplierByUsername(supplierUsername)));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteSupplierFood", produces = "application/json")
    @ResponseBody
    public ResultMessage deleteSupplierFood(@RequestParam("foodId") int foodId) {
        return supplierFoodBlService.deleteSupplierFood(foodId);
    }
}
