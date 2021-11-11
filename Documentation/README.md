# HighestTree

## Resources used

[Maven Repository](https://mvnrepository.com/)

What is a **Maven Repository**? A repository in Maven holds build artifacts and dependencies of varying types. In Maven
terminology, a repository is a directory where all the project jars, library jar, plugins or any other project specific
artifacts are stored and can be used by Maven easily. The *local* repository is a directory on the computer where Maven
runs. It caches remote downloads and contains temporary build artifacts that you have not yet released.
*Remote* repositories refer to any other type of repository. These repositories might be a truly remote repository set
up by a third party to provide their artifacts for downloading (for example, repo.maven.apache.org).

* Source: [TuturialPoints](https://www.tutorialspoint.com/maven/maven_repositories.html)
* Source: [Apache Maven Project](https://maven.apache.org/guides/introduction/introduction-to-repositories.html)

## Architecture
### Persons and their Relationships to another
* Problem: Design the Person-Relationships without redundancies
* Solution: Each Person Object is associated to its parents and its spouses.
* Consequences: 
  * The Family Tree is easy to traverse bottom-up (get the ancestors of a person) but more difficult to traverse top-down (get the children of a person), 
    because a person only knows about its parents but not its children.
  * spouses are still redundant
    

![Person UML](../img/Person_UML.png)


