# HighestTree

## Table of Contents
[Introduction](#Introduction)

[Goals](#Goals)

[Design](#Design)

<br>

## 1. Introduction

The aim of this project is to have a product to support the work of historians in recording the who, what, when, where of a particular genealogy tree. 
The product aims to help with research plans by providing a method to trace the birth, marriage and death records of individuals and they'r relationships with other individuals, places and events. 



## 2. Goals

The system should:

**SReq_01**	The system can record and display persons

**SReq_02**	The system can record and display important events

**SReq_03**	The system can record and display places

**SReq_04**	The system can record types of relationships

**SReq_05**	The individual records "person" are interelatable between themselfes trough relationships. 

**SReq_06**	When recording a new individual through the user-interface, The system pre-fills fields that it can infer.

INFO: the surname may be guessed if the individual is already assigned to a set of parents; the gender may be guessed if the the first name is the same of other individuals with an assigned gender.

**SReq_07**	The system can record types of events

**SReq_08**	Events can have a special purpose field that is specific to it's individual nature.

**SReq_09**	Events can have a conection to a place.

**SReq_10**	Places entry have different levels of granularity (Only Country, City, District, Parish... or a combination of some).

**SReq_11**	System can select if dates are a time period or specific.

**SReq_12**	Dates (period begining and end, or specific date) entries can be partially filled. (Only the year, month, day... in decresing order).

**SReq_13**	Individuals, events and places may be described by the researchers in free text.

**SReq_14**	Individuals, events, places and relationships can have additional field specifying where each piece of information was acquired.

**SReq_15**	The system is able to query existing individuals by filtering information using rules based on each of the available fields and relationships.

**SReq_16**	The system can save queries to be reused.

**SReq_17**	The system is able to export the information gathered from a query.

**SReq_18**	The system is able to save the information gathered from a query.

**SReq_19**	The system is able to load and save records using different formats.

**SReq_20**	It is possible to add different export formats to the system.

**SReq_21**	The system can export the genealogy information to formats that allow a graphical visualization Note: such as the DOT language (graphviz).

**SReq_22**	Any field in a record can be set as sensitive information, and decide when exporting if sensitive information should be part of the output or not.

**SReq_23**	When exporting, the system as a choise to output, or not, fields marked as sensitive information.

**SReq_24**	System can be used in view-only mode.

**SReq_25**	System can be used in edit-mode.


## 3. Design 
This section explains the design choices of the various
 features developed in this project.
 
### 3.1. Domain

The main components of our system are described in the image below.

![Classes_BL1_Freeze_Classes_3](https://github.com/ADS2022/HighestTree/blob/master/img/Classes_BL1_Freeze_Classes_3.png)
![Classes_BL1_Freeze_Classes_2](https://github.com/ADS2022/HighestTree/blob/master/img/Classes_BL1_Freeze_Classes_2.png)


### 3.2. Patterns

This section presents the patterns used in this project, including a description
of the problem that led to the use of the pattern, details about its implementation,
and consequences.

#### 3.3.1. Composite
It is a structural design pattern. 

https://www.tutorialspoint.com/design_pattern/composite_pattern.htm
This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.

https://www.javatpoint.com/composite-pattern
A Composite Pattern says that just "allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects".

- **Problem in Context**
   
- **Implementation**
  
- **Consequences**
   

    
#### 3.3.2. Observer
- **Problem in Context**
 
- **The Pattern**
   
- **Implementation**

- **Consequences**
  
#### 3.3.3. Factory Method
-
- **The Pattern**
 
- **Implementation**
   
- **Consequences**
  
 

#### 3.3.4. Visitor
- **Problem in Context**
  
  
- **The Pattern**

    
- **Implementation**
 
- **Consequences**
   

#### 3.3.5. Template
- **Problem in Context**
 
- **The Pattern**

- **Consequences**

#### 3.3.6. Singleton
- **Problem in Context**
   
- **Implementation**
  
- **Consequences**
