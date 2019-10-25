package com.example.ccd_survey.Models;

public class Evaluated {

    private Integer idEvaluated;
    private String name;
    private Integer category_id;
    private String image;

    public Integer getIdEvaluated() {
        return idEvaluated;
    }

    public void setIdEvaluated(Integer idEvaluated) {
        this.idEvaluated = idEvaluated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
