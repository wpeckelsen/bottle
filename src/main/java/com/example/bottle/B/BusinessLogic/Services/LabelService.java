package com.example.bottle.B.BusinessLogic.Services;
import com.example.bottle.B.BusinessLogic.dto.label.CreateLabel;
import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;
import com.example.bottle.B.BusinessLogic.Models.Label;
import com.example.bottle.B.BusinessLogic.exception.RecordNotFound;
import com.example.bottle.C.repository.LabelRepo;
import org.springframework.stereotype.Service;

@Service
public class LabelService {

    private final LabelRepo labelRepo;

    public LabelService(LabelRepo labelRepo) {
        this.labelRepo = labelRepo;
    }


    public CreatedLabel addLabel(CreateLabel createLabel) {
        Label label = labelMaker(createLabel);
        labelRepo.save(label);
        return labelDtoMaker(label);
    }


    public CreatedLabel getLabelByID(Long idLabel) {

        if (labelRepo.findById(idLabel).isPresent()){
            Label label = labelRepo.findById(idLabel).get();
            return labelDtoMaker(label);
        } else {
            throw new RecordNotFound("Could not find that label");
        }

    }



    public Label labelMaker(CreateLabel createLabel) {
        Label label = new Label();

        label.setColor(createLabel.getColor());
        label.setShape(createLabel.getShape());
        label.setMaterial(createLabel.getMaterial());

        return label;
    }


    public CreatedLabel labelDtoMaker(Label label) {
        CreatedLabel createdLabel = new CreatedLabel();

        createdLabel.setIdLabel(label.getIdLabel());
        createdLabel.setColor(label.getColor());
        createdLabel.setShape(label.getShape());
        createdLabel.setMaterial(label.getMaterial());

        return createdLabel;
    }

}