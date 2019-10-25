package com.example.ccd_survey.Models;

public class Evaluator {

    private Integer idEvaluator;
    private String name;
    private String username;
    private String password;
    private Integer category_id;

    public Integer getIdEvaluator() {
        return idEvaluator;
    }

    public void setIdEvaluator(Integer idEvaluator) {
        this.idEvaluator = idEvaluator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
