# HighestTree

## Table of Contents

- [Introduction](#introduction)

- [Goals](#goals)

- [Design](#design)

<br>

## How to run the project

To run the project, you can use the built-in tools in the IntelliJ IDEA. It should show up on the home screen with
several of the system capabilities. Also, you can run the project using the command line. If there is any problem
opening or running the project, don't hesitate to contact us. Don't forget to import all the maven dependencies.

## Requirements

[Link to requirements google docs](https://docs.google.com/spreadsheets/d/1xZ9EhlMW8qUNATcF684Nj9N8olOkkjLRqoa5ysPpLKs/edit?usp=sharing)

## 1. Introduction

The project aims to develop a solution that helps historians study the "who," "what," and "when" genealogy tree. The
product aims to help with research plans by providing a method to trace the birth, marriage, and death records of
individuals and their relationships with other individuals, places, and events.

### 1.1 Problem description

Genealogy is a long-term research goal with built-in short-term steps. Its main spotlights are the individuals and their
background in time and geography. It's a research objective where the user can add more information while maintaining
the links between individuals, places, and events.

The team assumed that our model could represent the relationship between two (or more) persons in two ways.
Horizontally, as in married, or had children with; and vertically ("child of," "parent to," "adopted by"). A brief
example of the type of ramifications that can occur is presented in the following image.

One problem that can always occur in the development of these projects (and in such a way in all software projects) is
data redundancy, primarily when representing the relationships between two (or more persons), or when creating a place
and even when creating events. So in our model, we tried to address this problem when implementing it (the solution is
in the design section). The second design problem that we encountered was the dates. Dates in Java are always an issue (
especially when testing them). The problem at hand is that an event can have a specific date or a period. For example, I
know that FEUP was founded in 1926; however, I don't know precisely when Humanity invented the wheel. Historians only
know that it was in the 4th century BC (and that qualifies as a period). So, the user might know that his
great-grandmother was born in the 19th century (a period). However, he knows for sure that his mother was born in 1969 (
a date). Our system should be able to have this flexibility. Also, another minor but essential problems that we faced
were the fact that some information might be incomplete when entering a record. For example, the user knows that FEUP is
located at R. Dr. Roberto Frias, 4200-465 Porto. However, the user doesn't know where his distant relative from Italy
was when he studied at FEUP. The only thing that he knows is that he comes from Italy. When creating Places, Events,
Persons, every object in our model, our system should also allow this option to insert granular information that might
be or might not be filled in the future.

Summing up, the two main problems that we encountered and addressed were the redundancies in our system and the dates,
and last but not least, the granularity when entering information.

![FamilyTreeExample](img/FamilyTreeExample.png)

## 2. Goals

This exercise was presented as a series of bullet points of features or ideas for the system under development. These
were broken down into the following requirements.

**SReq_01**    The system can record and display persons.

**SReq_02**    The system can record and display events.

**SReq_03**    The system can record and display places.

~~**SReq_04**    The system can record types of relationships.~~

**SReq_05**    The individual records "person" are interrelated between themselves through "relationships".

**SReq_06**    When recording a new individual through the user interface, the system pre-fills fields that it can
infer.

**SReq_07**    The system can record types of events.

**SReq_08**    Events can have a special purpose field that is specific to their individual nature.

**SReq_09**    Events can have a connection to a location.

**SReq_10**    The place's entry have different levels of granularity (Only Country, City, District, Parish... or a
combination of some).

**SReq_11**    System can insert dates onto records as a time period or a specific date.

**SReq_12**    The Date entry (time period or specific date) can be partially filled, e.g, only the year and month are
known.

**SReq_13**    Individuals, events, and places are described by the researchers in free text.

**SReq_14**    Individuals, events, places ~~and relationships~~ can have an additional field specifying where each
piece of information was acquired.

**SReq_15**    The system is able to query existing individuals by filtering information using rules based on each of
the available fields and relationships.

**SReq_16**    The system can save queries to be reused.

**SReq_17**    The system is able to export the information gathered from a query.

**SReq_18**    The system is able to save the information gathered from a query.

**SReq_19**    The system is able to load and save records using different formats.

**SReq_20**    It is possible to add different export formats to the system.

**SReq_21**    The system can export the genealogy information to formats that allow a graphical visualization (such as
the DOT language (graphviz)).

**SReq_22**    Any field in a record can be set as sensitive information, and decide when exporting if sensitive
information should be part of the output or not.

**SReq_23**    When exporting, the system as a choice to output, or not, fields marked as sensitive information.

**SReq_24**    System can be used in view-only mode.

**SReq_25**    System can be used in edit-mode.

## 3. Design

This section exposes the design decisions made during the ongoing phases of development of this project.

### 3.1. Domain

#### 3.1.1 First approach

As a first step into the solution, the group modeled the classes in a database manner, while discussing the
implementation, kinds of relationships, and possible patterns that could be applied.

Additionally, some time was spent thinking about the solution to SReq_11 "System can insert dates onto records as a time
period or a specific date." The solution that was devised was a superClass that can take two dates as parameters, but
the user can insert only one date if the specific date is known. For a time period, the user can add two partial, or
complete, dates.

In this phase, the group also discussed options to store queries for SReq_16 "The system can save queries to be reused."
As a simple solution, a specific classes for storing and calling query strings.

As a result one can see the main components of our system as described in the image below.

![Classes_BL1_Freeze_Classes_4](img/HighestTree-class-diagram_V2.svg)

### 3.1.2 Refactor and code smells

### 3.1.3 Second approach

### 3.2. Patterns

This section presents the study of the design patterns considered for this project.

The group first started by looking at the system's requirements versus the patterns given in class. Having identified
some patterns that might be useful for the case in study, we proceeded to investigate further on the mentioned patterns.

In this round of implementation, group B elected several problems for the use of design patterns. The group focused
mainly on the relationship tree between 'person' records. Several design patterns were studied and discussed. It has yet
to be identified the correct approach.

For the eventual patterns used in this project, the group shall include detailed descriptions of the problems,
implementation and consequences were whirling the use of the same.

### Persons and their Relationships to another

* **Problem:** Design the Person-Relationships without redundancies
* **Solution:** Each Person Object is associated to its parents and its spouses.
* **Consequences:**
    * The Family Tree is easy to traverse bottom-up (get the ancestors of a person) but more difficult to traverse
      top-down (get the children of a person), because a person only knows about its parents but not its children.
* **Implementation:** TODO

![Person UML](img/Person_UML.png)

### Date, time periods and super dates

* **Problem:** A person can be born on a specific date or in on a time period. For example, an individual could be born
  in 1578 or in the XVI century (between 1501 and 1600).
* **Classes:** TODO
* **Solution:**
    * There is an interface called SuperDate and two classes called Date and TimePeriod. Those classes implement
      SuperDate and when creating an object that requires a date (for example an Event) it is possible to create a date
      or a time period.
        * This solution implements the [*template method*](https://refactoring.guru/design-patterns/template-method)
          pattern by breaking down the date-time period logic into a series of two steps, and turning these steps into a
          method and then call those methods inside a single template method.
* **Problems:** TODO
* **Implementation:** TODO

![Dates UML](img/HighestTree-dates-class-diagram.svg)

### Granularity of the fields

* **Problem:** TODO
* **Solution:**
  TODO
* **Problems:** TODO
* **Implementation:** TODO

### Model-View-Controller (MVC)

* **Problem:** TODO
* **Solution:**
  TODO
* **Problems:** TODO
* **Implementation:** TODO

### Model-View-Controller Service MVCS

* **Problem:** TODO
* **Solution:**
  TODO
* **Problems:** TODO
* **Implementation:** TODO

### DAO

* **Problem:** TODO
* **Solution:**
  TODO
* **Problems:** TODO
* **Implementation:** TODO

#### Composite

* **Problem:** TODO
* **Solution:**
    * It is a structural design pattern. At first glace, the composite pattern got elected for structuring our tree of
      records.
        * "This pattern creates a class that contains group of its own objects. This class provides ways to modify its
          group of same
          objects." [Source: tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/composite_pattern.htm)
        * "A Composite Pattern says that just "allow clients to operate in generic manner on objects that may or may not
          represent a hierarchy of objects." [Source: javapoint.com](https://www.javatpoint.com/composite-pattern)
* **Problems:** TODO
* **Implementation:** TODO
