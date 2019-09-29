package com.stackroute.springbootneo4jexample1.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
public class User {

  @GraphId

  private String userEmail;
    private String userName;

    private List<String> category;
    @Relationship(type = "LIKES", direction = Relationship.OUTGOING)
    private List<Category> categories;

   public List<Category> getCategories() {
        return categories;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public User() {

    }



    public List<String> getCategory() {
        return category;
    }
}
