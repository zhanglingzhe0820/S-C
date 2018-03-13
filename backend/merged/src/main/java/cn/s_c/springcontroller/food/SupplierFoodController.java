package cn.s_c.springcontroller.food;

import cn.s_c.blservice.food.SupplierFoodBlService;
import cn.s_c.blservice.supplier.SupplierBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodEditableReturnVo;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import cn.s_c.vo.food.SupplierFoodUpdateVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String uploadImage(@RequestParam("foodImage") MultipartFile multipartFile) {
        try {
            return supplierFoodBlService.uploadImage(multipartFile.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
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

    @ApiOperation(value = "getSupplierFoodBySupplierUsername", nickname = "getSupplierFoodBySupplierUsername")
    @RequestMapping(method = RequestMethod.POST, path = "/getSupplierFoodBySupplierUsername", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = SupplierFoodReturnVo[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public SupplierFoodReturnVo[] getSupplierFoodBySupplierUsername(@RequestParam("supplierUsername") String supplierUsername) {
        return supplierFoodBlService.getSupplierFoodBySupplierUsername(supplierUsername);
    }

    @ApiOperation(value = "loadSupplierFoodById", nickname = "loadSupplierFoodById")
    @RequestMapping(method = RequestMethod.POST, path = "/loadSupplierFoodById", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = SupplierFoodEditableReturnVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public SupplierFoodEditableReturnVo loadSupplierFoodById(@RequestParam("supplierFoodId") int supplierFoodId) {
        return supplierFoodBlService.loadSupplierFoodById(supplierFoodId);
    }

    @ApiOperation(value = "updateSupplierFood", nickname = "updateSupplierFood")
    @RequestMapping(method = RequestMethod.POST, path = "/updateSupplierFood", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage updateSupplierFood(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name, @RequestParam(name = "price") double price, @RequestParam(name = "url") String url, @RequestParam(name = "hasChoice") boolean hasChoice, @RequestParam(name = "choice") String[] choice, @RequestParam(name = "supplierUsername") String supplierUsername) {
        return supplierFoodBlService.updateSupplierFood(new SupplierFoodUpdateVo(id, name, price, url, hasChoice, choice, supplierBlService.getSupplierByUsername(supplierUsername)));
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
