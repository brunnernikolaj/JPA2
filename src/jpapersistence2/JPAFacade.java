/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpapersistence2;

import entity.BaseEntity;
import entity.PHDStudent;
import entity.Person;
import entity.Student;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Nikolaj
 */
public class JPAFacade {

    EntityManager manager;

    public JPAFacade() {
        manager = Persistence.createEntityManagerFactory("PU").createEntityManager();
    }

    public Person findPerson(long id) {
        return manager.find(Person.class, id);
    }


    public Student findStudent(long id) {
        return manager.find(Student.class, id);
    }
    
    public PHDStudent findPhd(long id) {
        return manager.find(PHDStudent.class, id);
    }

    public void assignSupervisor(Person user, Person supervisor) {

        supervisor.getSupervised().add(user);
        user.setSupervisor(supervisor);

        updateMany(user,supervisor);
    }
//
//    public void assignTask(Task task, long projectId) {
//        Project project = manager.find(Project.class, projectId);
//
//        project.getTasks().add(task);
//        task.setProject(project);
//
//        updateMany(task,project);
//    }

    public <T extends BaseEntity> void create(T entity) {
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(entity);
        transaction.commit();
    }
    
    public <T extends BaseEntity> void update (T entity){
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.merge(entity);
        transaction.commit();
    }
    
    public <T extends BaseEntity> void updateMany (T... entities){
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        for (T entity : entities){
            manager.merge(entity);
        }      
        transaction.commit();
    }
    
    public <T extends BaseEntity> void delete (T entity){
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.remove(entity);
        transaction.commit();
    }
}
