# HighestTree

## Table of Contents

[Introduction](#Introduction)

[Goals](#Goals)

[Design](#Design)

<br>

## How to run the project

Due to this being the first iteration, to run the project, you should open this project in IntelliJ IDEA from existing
Maven sources, and then it is possible to run the tests using the built-in tools from the IDEA. If there is any problem
opening or running the project, don't hesitate to contact us. Don't forget to import all the Gradle dependencies.

## 1. Introduction

The aim of this project is to have a product to support the work of historians in recording the who, what, when, whereof
a particular genealogy tree. The product aims to help with research plans by providing a method to trace the birth,
marriage, and death records of individuals and their relationships with other individuals, places, and events.

### 1.1 Problem descrition

Genealogy is a long-term research goal with built-in short-term steps. Its main spotlights are the individuals and their
background in time and geography. It's a research objective where the user can keep adding in more information while
maintaining the links between the individuals, places and events.

For the purpose of this work, the relationship between people can be tought of as horizontal (as in maried, or had
children with) and vertical  (child of, parent to, adopted by). A brief example of the type of ramifications that can
occur is presented in the following image.

![FamilyTreeExample](https://github.com/ADS2022/HighestTree/blob/master/img/FamilyTreeExample.png)

## 2. Goals

This exercise was presented as a series of bullet points of features or ideas for the system under development. These
were broken down into the following requirements.

**SReq_01**    The system can record and display persons.

**SReq_02**    The system can record and display events.

**SReq_03**    The system can record and display places.

~~**SReq_04**    The system can record types of relationships.~~

**SReq_05**    The individual records "person" are interrelatable between themselves through "relationships".

**SReq_06**    When recording a new individual through the user interface, the system pre-fills fields that it can
infer.

**SReq_07**    The system can record types of events.

**SReq_08**    Events can have a special purpose field that is specific to their individual nature.

**SReq_09**    Events can have a connection to a place.

**SReq_10**    The places entry have different levels of granularity (Only Country, City, District, Parish... or a
combination of some).

**SReq_11**    System can insert dates onto records as a time period or a specific date.

**SReq_12**    The Date entry (time period or specific date) can be partially filled, e.g, only the year and month are
known.

**SReq_13**    Individuals, events, and places are described by the researchers in free text.

**SReq_14**    Individuals, events, places ~~and relationships~~ can have an additional field specifying where each piece
of information was acquired.

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

![Classes_BL1_Freeze_Classes_4](https://github.com/ADS2022/HighestTree/blob/master/img/Classes_BL1_Freeze_Classes_4.drawio.svg)

### Persons and their Relationships to another

* **Problem:** Design the Person-Relationships without redundancies
* **Solution:** Each Person Object is associated to its parents and its spouses.
* **Consequences:**
    * The Family Tree is easy to traverse bottom-up (get the ancestors of a person) but more difficult to traverse
      top-down (get the children of a person), because a person only knows about its parents but not its children.
    * spouses are still redundant

![Person UML](https://github.com/ADS2022/HighestTree/blob/master/img/Person_UML.png)

### Date, time periods and super dates

* **Problem:** A person can be born on a specific date or in on a time period. For example, an individual could be born
  in 1578 or in the XVI century (between 1501 and 1600).
* **Solution:**
    * There is an interface called SuperDate and two classes called Date and TimePeriod. Those classes implement
      SuperDate and when creating an object that requires a date (for example an Event) it is possible to create a date
      or a time period.
        * This solution implements the [*template method*](https://refactoring.guru/design-patterns/template-method)
          pattern by breaking down the date-time period logic into a series of two steps, and turning these steps into a
          method and then call those methods inside a single template method.

![Dates UML](https://github.com/ADS2022/HighestTree/blob/master/img/TimePeriod.png)

### 3.2. Patterns

This section presents the study of the design patterns considered for this project.

The group first started by having a look at the requirements of the system versus the patterns given in class. Having
identified some patterns that might be useful for the case in study, we proceeded to investigate further on the
mentioned patterns.

In this round of implementation, several problems were elected for the use of design patterns. The group focused mainly
on the relationship tree between 'person' records. Several design patterns were studied and discussed. It has yet to be
identified the correct approach.

For the eventual patterns used in this project, the group shall include detailed descriptions of the problems,
implementation, and consequences whirling the use of the same.

#### 3.3.1. Composite

It is a structural design pattern. At first glace, the composite pattern got elected for structuring our tree of
records.

"This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of
same objects". [Source: tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/composite_pattern.htm)

"A Composite Pattern says that just "allow clients to operate in generic manner on objects that may or may not represent
a hierarchy of objects". [Source: javapoint.com](https://www.javatpoint.com/composite-pattern)

- **Problem in Context**

  UNDER STUDY:

  -- Applying a method to show/hide a particular branch of the tree for visualization or export.


- **Implementation**

- **Consequences**

## 4. Next "sprint"

In the next sprint work will be focused on SReq_01, SReq_05 and the structured tree that will result from such
relationships. 

