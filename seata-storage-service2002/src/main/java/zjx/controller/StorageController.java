package zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zjx.domain.CommonResult;
import zjx.service.StorageService;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    public CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        return storageService.decreaseStorage(productId, count);
    }

}
