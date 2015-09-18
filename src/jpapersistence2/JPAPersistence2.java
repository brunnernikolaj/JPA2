/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpapersistence2;

import entity.Grade;
import entity.PHDStudent;
import entity.Person;
import entity.Student;

/**
 *
 * @author Nikolaj
 */
public class JPAPersistence2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JPAFacade facade = new JPAFacade();
        
        Person lars = new Person("Lars", "Lund", 10);
        Grade grade = new Grade("Fysik", 10);
        
        facade.create(grade);
        facade.create(lars);
        
        lars.setGrade(grade);
        facade.update(lars);
        
        Student morten = new Student("Morten", "Petersen", 12);
        
        facade.create(morten);
        
        
        PHDStudent phdStudent = new PHDStudent("Casper", "Larsen", 20);
        Grade grade2 = new Grade("Matematik", 12);
        
        facade.create(grade);
        facade.create(phdStudent);
        
        phdStudent.setGrade(grade);
        
        facade.update(phdStudent);
        
        facade.assignSupervisor(lars, phdStudent);
        
        System.out.println(facade.findPhd(phdStudent.getId()));
    }
    
}
