/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author Nikolaj
 */
@Entity
public class PHDStudent extends Employee{
    private String dissSubject;

    public PHDStudent() {
    }

    public PHDStudent(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public String getDissSubject() {
        return dissSubject;
    }

    public void setDissSubject(String dissSubject) {
        this.dissSubject = dissSubject;
    }
    
    
}
