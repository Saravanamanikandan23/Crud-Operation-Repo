package com.example.ECommerceSample.Controller;

import com.example.ECommerceSample.Model.ECommerceModel;
import com.example.ECommerceSample.Service.ECommerceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ProductDetails")
public class ECommerceController {

    private ECommerceService eCommerceService;

    public ECommerceController(ECommerceService eCommerceService) {
        this.eCommerceService = eCommerceService;
    }

    @PostMapping(value = "/Created")
    @ResponseStatus(HttpStatus.CREATED)
    public String createDetails(@RequestBody ECommerceModel eCommerceModel) {
        return eCommerceService.addDetails(eCommerceModel);
    }

    @PutMapping(value = "/update/{id}")
    public String updateDetails(@PathVariable Integer id,@RequestBody ECommerceModel eCommerceModel) {
        return eCommerceService.updateById(id,eCommerceModel);
    }

    @GetMapping(value = "/getAll")
    public List<ECommerceModel> getAll(){
        return eCommerceService.getAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Optional<ECommerceModel> getById(@PathVariable Integer id ){
        return eCommerceService.getById(id);
    }

    @DeleteMapping(value = "/Delete/{id}")
    public String deleteDetails(@PathVariable Integer id){
        return eCommerceService.deleteDetails(id);
    }


}
