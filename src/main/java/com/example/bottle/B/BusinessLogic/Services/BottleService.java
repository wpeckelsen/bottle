package com.example.bottle.B.BusinessLogic.Services;

import com.example.bottle.B.BusinessLogic.Models.Bottle;
import com.example.bottle.B.BusinessLogic.Models.Label;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreateBottle;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreatedBottle;
import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;
import com.example.bottle.B.BusinessLogic.exception.RecordNotFound;
import com.example.bottle.C.repository.BottleRepo;
import com.example.bottle.C.repository.LabelRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BottleService {

//test
    private final BottleRepo bottleRepo;
    private final LabelRepo labelRepo;
    private final LabelTransfer labelTransfer;



    //    @Autowired


    public BottleService(BottleRepo bottleRepo, LabelRepo labelRepo, LabelTransfer labelTransfer) {
        this.bottleRepo = bottleRepo;
        this.labelRepo = labelRepo;
        this.labelTransfer = labelTransfer;
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


//        public CreatedBottle getBottleById(Long idBottle) {
//        if (bottleRepo.findById(idBottle).isPresent()) {
//            Bottle bottle = bottleRepo.findById(idBottle).get();
//            return bottleDtoMaker(bottle);
//        } else {
//            throw new RecordNotFound("Could not find that bottle");
//        }
//    }


    //    TODO 7.1: find and add
//    public Label findAddLabel(List<Label> labels, String shape) {
//        Label foundLabel = labelRepo.findLabelByShape(shape);
//        List<Label> labelList = new ArrayList<>();
//
//        labelList.add(foundLabel);
//        return
//
////        if(foundLabel.isPresent()){
////            labels.add(foundLabel.get());
////        }
////        return
//
//
////                List<Television> tvList = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
////        return transferTvListToDtoList(tvList);
//
//    }


//    label
//    createdlabel

//    findbyID
//    .add

//    set


//    TODO 7.2: get labels. moved to labelservice

//    public List<CreatedLabel> makeCreatedLabels(String shape) {
//        Label foundLabel = labelRepo.findLabelByShape(shape);
//        List<Label> labels = new ArrayList<>();
//        labels.add(foundLabel);
//
//
//        List<CreatedLabel> createdLabels = new ArrayList<>();
//
//        for (Label label : labels) {
//            CreatedLabel createdLabel = labelService.labelDtoMaker(label);
//
//            createdLabels.add(createdLabel);
//        }
//
//        return createdLabels;
//
//    }
    //

//        Collection<CreatedLabel> createdLabels = new HashSet<>();
//
//        for (Label label1 : foundLabel) {
//            CreatedLabel createdLabel = labelService.labelDtoMaker(label1);
////            TelevisionDto dto = transferToDto(tv);
////            CreatedLabel createdLabel = labelService.labelDtoMaker(label1);
//            createdLabels.add(createdLabel);
//        }
//        return createdLabels;


//                for(Television tv : televisions) {
//            TelevisionDto dto = transferToDto(tv);


//
//
//        bottle.setLabels(list);
//        return bottleDtoMaker(bottle);
//    }

    //    transfer to dto
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

        List<Label> labels = bottle.getLabels();

        List<CreatedLabel> createdLabelList = new ArrayList<>();

        if (labels != null){
            for(Label label : labels){
                CreatedLabel createdlabel = labelTransfer.labelDtoMaker(label);
                createdLabelList.add(createdlabel);
            }
        }

        bottle.getLabels();
        createdBottle.setLabels(createdLabelList);


        return createdBottle;
    }


    //    transfer to bottle
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


}


//created label and label model has no bottle.