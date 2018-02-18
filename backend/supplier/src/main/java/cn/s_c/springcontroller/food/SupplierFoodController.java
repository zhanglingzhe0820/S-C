package cn.s_c.springcontroller.food;

import cn.s_c.blservice.food.SupplierFoodBlService;
import cn.s_c.blservice.supplier.SupplierBlService;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierFoodController {
    @Autowired
    private SupplierFoodBlService supplierFoodBlService;
    @Autowired
    private SupplierBlService supplierBlService;

    @ApiOperation(value = "uploadImage", nickname = "uploadImage")
    @RequestMapping(method = RequestMethod.POST, path = "/uploadImage", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public String uploadImage(@RequestParam("foodImage") byte[] bytes) {
        return supplierFoodBlService.uploadImage(bytes);
    }

    @ApiOperation(value = "saveSupplierFood", nickname = "saveSupplierFood")
    @RequestMapping(method = RequestMethod.POST, path = "/saveSupplierFood", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage saveSupplierFood(@RequestParam(name = "name") String name, @RequestParam(name = "price") double price, @RequestParam(name = "url") String url, @RequestParam(name = "hasChoice") boolean hasChoice, @RequestParam(name = "choice") String[] choice, @RequestParam(name = "supplierUsername") String supplierUsername) {
        return supplierFoodBlService.saveSupplierFood(new SupplierFoodSaveVo(name, price, url, hasChoice, choice, supplierBlService.getSupplierByUsername(supplierUsername)));
    }

    @ApiOperation(value = "getSupplierFoodBySupplierId", nickname = "getSupplierFoodBySupplierId")
    @RequestMapping(method = RequestMethod.POST, path = "/getSupplierFoodBySupplierId", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = SupplierFoodReturnVo[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public SupplierFoodReturnVo[] getSupplierFoodBySupplierId(@RequestParam("supplierId") int supplierId) {
        return supplierFoodBlService.getSupplierFoodBySupplierId(supplierId);
    }

    @ApiOperation(value = "deleteSupplierFood", nickname = "deleteSupplierFood")
    @RequestMapping(method = RequestMethod.POST, path = "/deleteSupplierFood", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage deleteSupplierFood(@RequestParam("foodId") int foodId) {
        return supplierFoodBlService.deleteSupplierFood(foodId);
    }
}
