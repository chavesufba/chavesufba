package br.com.keysufba.entity;

import javax.persistence.*;

/**
 * Created by ian on 28/08/16.
 */

@Table(name = "Curso", schema = "SCHEMAA")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Nome", nullable = false)
    private String name;

    @Column(name = "Nivel", nullable = false)
    private String level;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
