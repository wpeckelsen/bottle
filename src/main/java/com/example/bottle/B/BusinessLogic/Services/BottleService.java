package com.example.bottle.B.BusinessLogic.Services;

import com.example.bottle.B.BusinessLogic.dto.bottle.CreatedBottle;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreateBottle;
import com.example.bottle.B.BusinessLogic.Models.Bottle;
import com.example.bottle.B.BusinessLogic.exception.RecordNotFound;
import com.example.bottle.C.repository.BottleRepo;
import com.example.bottle.C.repository.LabelRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BottleService {
    private final BottleRepo bottleRepo;
    private final LabelRepo labelRepo;

    public BottleService(BottleRepo bottleRepo, LabelRepo labelRepo) {
        this.bottleRepo = bottleRepo;
        this.labelRepo = labelRepo;
    }

    // TODO 1: make a list of all bottle objects
    public List<CreatedBottle> getAllBottles() {
        List<Bottle> bottleList = bottleRepo.findAll();
        List<CreatedBottle> createdBottleList = new ArrayList<>();

        for (Bottle bottle : bottleList) {
            CreatedBottle createdBottle = bottleDtoMaker(bottle);
            createdBottleList.add(createdBottle);
        }
        return createdBottleList;
    }

    // TODO 2: get bottles by brand
    public List<CreatedBottle> getAllBottlesByBrandName(String name) {
        List<Bottle> bottleList = bottleRepo.findBottlesByName(name);
        List<CreatedBottle> createdBottleList = new ArrayList<>();

        for (Bottle bottle : bottleList) {
            CreatedBottle createdBottle = bottleDtoMaker(bottle);
            createdBottleList.add(createdBottle);
        }
        return createdBottleList;
    }

    // TODO 3: get bottles by ID.
    public CreatedBottle getBottleById(Long idBottle) {
        if (bottleRepo.findById(idBottle).isPresent()) {
            Bottle bottle = bottleRepo.findById(idBottle).get();
            return bottleDtoMaker(bottle);
        } else {
            throw new RecordNotFound("Could not find that bottle");
        }
    }

    // TODO 4: add a bottle
    public CreatedBottle addBottle(CreateBottle createBottle) {
        Bottle bottle = bottleMaker(createBottle);
        bottleRepo.save(bottle);
        return bottleDtoMaker(bottle);
    }

    // TODO 5: DELETE
    public void deleteBottle(Long identityCode) {
        bottleRepo.deleteById(identityCode);

    }

    // TODO 6: UPDATE
    public CreatedBottle updateBottle(Long identityCode, CreateBottle createBottle) {
        if (bottleRepo.findById(identityCode).isPresent()) {
            Bottle bottle = bottleRepo.findById(identityCode).get();
            Bottle bottle1 = bottleMaker(createBottle);

            bottle1.setIdBottle(bottle.getIdBottle());
            bottleRepo.save(bottle1);
            return bottleDtoMaker(bottle1);
        } else {
            throw new RecordNotFound("that bottle aint here");
        }
    }

//    public TelevisionDto televisionWhitCI_Modules(Long televisionId, Long ci_moduleId) {
//        CI_Module ci_module = ci_moduleRepository.getById(ci_moduleId);
//        Television television = televisionRepository.getById(televisionId);
//
//        ci_module.televisionCISet(television);
//
//        televisionRepository.save(television);
//        return fromTelevision(television);
//    }
//

//        public void assignCIModuleToTelevision(Long id, Long ciModuleId) {
//        var optionalTelevision = televisionRepository.findById(id);
//        var optionalCIModule = ciModuleRepository.findById(ciModuleId);
//
//        if(optionalTelevision.isPresent() && optionalCIModule.isPresent()) {
//            var television = optionalTelevision.get();
//            var ciModule = optionalCIModule.get();
//
//            television.setCiModule(ciModule);
//            televisionRepository.save(television);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

    // TODO 7: BOTTLE & LABEL
    public CreatedBottle stickLabelsToBottle(Long idBottle, Long idLabel) {
        var optionalBottle = bottleRepo.findById(idBottle);
        var optionalLabel = labelRepo.findById(idLabel);
        var bottle = optionalBottle.get();
        var label = optionalLabel.get();
        bottle.setLabel(label);
        bottleRepo.save(bottle);
        return bottleDtoMaker(bottle);
    }


    public Bottle bottleMaker(CreateBottle createbottle) {
        Bottle bottle = new Bottle();

        bottle.setName(createbottle.getName());
        bottle.setColor(createbottle.getColor());
        bottle.setMilliliters(createbottle.getMilliliters());
        bottle.setProduced(createbottle.getProduced());
        bottle.setFactory(createbottle.getFactory());
        bottle.setAlcoholPercentage(createbottle.getAlcoholPercentage());
        bottle.setProductionTime(createbottle.getProductionTime());

        return bottle;
    }

//    1 (User user) >       Userdto dto
//    2 (Userdto userdto) > User user

//     (Bottle bottle) >   Createdbottle createdbottle
//    1 (Create create) >   Bottle bottle

    public CreatedBottle bottleDtoMaker(Bottle bottle) {
        CreatedBottle createdBottle = new CreatedBottle();

        createdBottle.setIdBottle(bottle.getIdBottle());
        createdBottle.setName(bottle.getName());
        createdBottle.setColor(bottle.getColor());
        createdBottle.setMilliliters(bottle.getMilliliters());
        createdBottle.setFactoryCode(bottle.getFactoryCode());
        createdBottle.setProduced(bottle.getProduced());
        createdBottle.setFactory(bottle.getFactory());
        createdBottle.setAlcoholPercentage(bottle.getAlcoholPercentage());
        createdBottle.setProductionTime(bottle.getProductionTime());
        //        label
        createdBottle.setLabel(bottle.getLabel());

        return createdBottle;
    }

}
