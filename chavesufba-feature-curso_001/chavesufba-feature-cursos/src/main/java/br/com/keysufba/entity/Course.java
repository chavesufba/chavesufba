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
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String name;

    @Column(name = "Nivel", nullable = false)
    private String level;

    Course() { // jpa only

    }

    public Course(final Integer id, String name, String level) {
		this.id = id;
		this.name = name;
		this.level = level;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
