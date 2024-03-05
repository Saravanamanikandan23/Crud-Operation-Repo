package com.example.ECommerceSample.Service;

import com.example.ECommerceSample.Model.ECommerceModel;
import com.example.ECommerceSample.Repository.ECommerceRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECommerceService {

    private ECommerceRepo eCommerceRepo;

    public ECommerceService(ECommerceRepo eCommerceRepo) {
        this.eCommerceRepo = eCommerceRepo;
    }

    public String addDetails(ECommerceModel eCommerceModel) {
        eCommerceRepo.save(eCommerceModel);
        return "Details created";
    }

    public String updateById(Integer id,ECommerceModel eCommerceModel) {
        ECommerceModel eCommerceModel1 = eCommerceRepo.findById(id).get();
        eCommerceModel1.setProductName(eCommerceModel.getProductName());
        eCommerceModel1.setProductQuantity(eCommerceModel.getProductQuantity());
        eCommerceModel1.setProductType(eCommerceModel.getProductType());
        eCommerceModel1.setProductPrice(eCommerceModel.getProductPrice());
        eCommerceRepo.save(eCommerceModel1);
        return "Details Updated";
    }

    public List<ECommerceModel> getAll() {
        return eCommerceRepo.findAll();
    }

    public Optional<ECommerceModel> getById(Integer id) {
        Optional<ECommerceModel> eCommerceModel = eCommerceRepo.findById(id);
        return eCommerceRepo.findById(id);
    }

    public String deleteDetails(Integer id){
        eCommerceRepo.deleteById(id);
        return "Details Deleted";
    }
}
