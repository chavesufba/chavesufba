# chavesufba
Projeto Controle de Chaves, trabalho da disciplina MATA63 - Eng. de Soft II, do DCC-UFBA.

#chavesufba
Key Control Project, academic work of subject MATA63 - Software Engineering II, Department of Computer Science, Federal University of Bahia.

## The directory structure
- src
	- main
		- java
			- keys
				- controller
				- model
		- resources
			- templates

## Import Project with git and maven command line

* git clone https://github.com/mmsdivino/chavesufba.git
* cd chavesufba
* git branch -a
* git checkout dev
* git branch team_xxx_yourname

### Run Project 
```
mvn spring-boot:run
```

### Clean Project 
```
mvn clean package
```

## Import Project in Eclipse IDE

* File -> Import -> Maven -> Existing maven Projects
* Let's coding! ∂

### Run Project 

* Right Click on chavesufba project to open context menu.
* Select Run as option -> 3 Maven Build
* Write on input Goals: clean install
* Right Click on Application.java -> Run as java Application


### View Project
```
http://localhost:8080
```

### References
```
http://spring.io/guides
```