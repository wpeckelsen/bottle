package com.example.bottle.C.repository;

import com.example.bottle.B.BusinessLogic.Models.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepo extends JpaRepository<Label, Long> {



    Label findLabelByShape(String shape);
}
