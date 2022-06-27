package com.example.bottle.B.BusinessLogic.Services;

import com.example.bottle.B.BusinessLogic.Models.Label;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreatedBottle;
import com.example.bottle.B.BusinessLogic.dto.label.CreateLabel;
import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;
import com.example.bottle.B.BusinessLogic.exception.RecordNotFound;
import com.example.bottle.C.repository.BottleRepo;
import com.example.bottle.C.repository.LabelRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {


    private final LabelRepo labelRepo;
    private final BottleRepo bottleRepo;
    private BottleService bottleService;
    private LabelTransfer labelTransfer;

    public LabelService(LabelRepo labelRepo, BottleRepo bottleRepo, BottleService bottleService, LabelTransfer labelTransfer) {
        this.labelRepo = labelRepo;
        this.bottleRepo = bottleRepo;
        this.bottleService = bottleService;
        this.labelTransfer = labelTransfer;
    }


//
//
//    total list of botles: bottlerepo.findall();

//    findbyID.add();


    public CreatedLabel addLabel(CreateLabel createLabel) {
        Label label = labelTransfer.labelMaker(createLabel);
        labelRepo.save(label);
        return labelTransfer.labelDtoMaker(label);
    }

    public List<CreatedLabel> getAllLabels() {
        List<Label> LabelList = labelRepo.findAll();
        List<CreatedLabel> createdLabelList = new ArrayList<>();

        for (Label label : LabelList) {
            CreatedLabel createdLabel = labelTransfer.labelDtoMaker(label);
            createdLabelList.add(createdLabel);
        }
        return createdLabelList;
    }


    public CreatedLabel getLabelByID(Long idLabel) {

        if (labelRepo.findById(idLabel).isPresent()) {
            Label label = labelRepo.findById(idLabel).get();
            return labelTransfer.labelDtoMaker(label);
        } else {
            throw new RecordNotFound("Could not find that label");
        }

    }






    public CreatedBottle stickCreatedLabelstoBottle(String shape, Long idBottle) {
        var optionalBottle = bottleRepo.findById(idBottle);
        var bottle = optionalBottle.get();

        Label newLabel = labelRepo.findLabelByShape(shape);

        List<Label> oldLabels = bottle.getLabels();

        oldLabels.add(newLabel);

        bottle.setLabels(oldLabels);
        bottleRepo.save(bottle);

        return bottleService.bottleDtoMaker(bottle);


    }


    public CreatedLabel stickLabelsToBottle(Long idBottle, Long idLabel) {
        var optionalBottle = bottleRepo.findById(idBottle);
        var optionalLabel = labelRepo.findById(idLabel);

        var bottle = optionalBottle.get();
        var label = optionalLabel.get();

        label.setBottle(bottle);
        labelRepo.save(label);
        return labelTransfer.labelDtoMaker(label);


    }

//    public List<CreatedBottle> stickManyBottlesToLabel(Long idBottle, Long idLabel) {
////        var optionalLabel = labelRepo.findById(idLabel);
////        var label = optionalLabel.get();
////
////        var optionalBottle = bottleRepo.findById(idBottle);
////        var bottle = optionalBottle.get();
//
////        Bottle bottle = bottleRepo.findById(idBottle).get();
////        Label label = labelRepo.findById(idLabel).get();
////
////
////
////
////        List<Label> list = new ArrayList<>();
////        list.add(label);
////        bottle.setLabels(list);
////
////        return bottleDtoMaker(bottle);
//
//
//
//
//
//
//    }
}