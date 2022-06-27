package com.example.bottle.B.BusinessLogic.Services;

import com.example.bottle.B.BusinessLogic.Models.Label;
import com.example.bottle.B.BusinessLogic.dto.label.CreateLabel;
import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;
import org.springframework.stereotype.Service;


@Service
public class LabelTransfer {

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
