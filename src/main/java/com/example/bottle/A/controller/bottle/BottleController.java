package com.example.bottle.A.controller.bottle;

import com.example.bottle.B.BusinessLogic.Services.BottleService;
import com.example.bottle.B.BusinessLogic.Services.LabelService;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreateBottle;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreatedBottle;
import com.example.bottle.B.BusinessLogic.dto.label.CreateLabel;
import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BottleController {

    //    controller > service > data layer
    private final BottleService bottleService;
    private final LabelService labelService;

    @Autowired
    public BottleController(BottleService bottleService, LabelService labelService) {
        this.bottleService = bottleService;
        this.labelService = labelService;
    }


    @GetMapping("bottle/test")
    public ResponseEntity<String> helloBottle() {
        String beerBottle = "bottle says: successful get request!";
        return ResponseEntity.ok().body(beerBottle);
    }

    @PostMapping("bottle/new")
    public ResponseEntity<CreatedBottle> createBottle(@RequestBody CreateBottle createBottle) {
        final CreatedBottle createdBottle = bottleService.addBottle(createBottle);
        return ResponseEntity.ok(createdBottle);
    }



//    @GetMapping("bottle/list")
//    public ResponseEntity<List<CreatedBottle>> getAllBottles(@RequestParam(value = "name", required = false) Optional<String> name){
//        List<CreatedBottle> createdBottleList;
//
//        if(name.isEmpty()){
//            createdBottleList = bottleService.getAllBottles();
//        } else {
//            createdBottleList = bottleService.getAllBottlesByBrandName(name.get());
//        }
//        return ResponseEntity.ok().body(createdBottleList);
//    }

    @GetMapping("bottle/list")
    public ResponseEntity<List<CreatedBottle>> getAllBottles() {
//        List<CreatedBottle> createdBottleList;
//        createdBottleList = bottleService.getAllBottles();
        return ResponseEntity.ok().body(bottleService.getAllBottles());
    }

    @GetMapping("label/list")
    public ResponseEntity<List<CreatedLabel>> getAllLabels(){
        return ResponseEntity.ok().body(labelService.getAllLabels());
    }



    @GetMapping("label/list/{idLabel}")
    public ResponseEntity<CreatedLabel> getLabelByID(@PathVariable("idLabel") Long idLabel) {
        CreatedLabel label = labelService.getLabelByID(idLabel);
        return ResponseEntity.ok().body(label);
    }

    @PutMapping("bottle/list/update/{id}")
    public ResponseEntity<Object> updateBottle(@PathVariable Long ID, @RequestBody CreateBottle createBottle) {
        CreatedBottle createdBottle = bottleService.updateBottle(ID, createBottle);
        return ResponseEntity.ok().body(createdBottle);
    }

    @DeleteMapping("bottle/delete/{id}")
    public ResponseEntity<Object> deleteBottle(@PathVariable Long ID) {
        bottleService.deleteBottle(ID);

        return ResponseEntity.noContent().build();
    }


//    labels/////////////////////////////////////////////

    @PostMapping("label/new")
    public ResponseEntity<CreatedLabel> createLabel(@RequestBody CreateLabel createLabel) {
        final CreatedLabel createdLabel = labelService.addLabel(createLabel);
        return ResponseEntity.ok(createdLabel);
    }


    @PutMapping("glued/bottle/{idBottle}/label/{idLabel}")
    public ResponseEntity<CreatedLabel> stickLabelToBottle(@PathVariable Long idBottle,
                                                            @PathVariable Long idLabel) {
        return ResponseEntity.ok().body(labelService.stickLabelsToBottle(idBottle, idLabel));
    }

    @PutMapping("assign/bottle/{idBottle}/label/{idLabel}")
    public ResponseEntity<CreatedBottle> assign(@PathVariable Long idBottle,
                                                @PathVariable Long idLabel){
        return ResponseEntity.ok().body(labelService.sticky(idLabel, idBottle));
    }



}
