# Proiect - Etapa 2 - Santa Claus is coming to ACS students

After parsing the input and loading it into the classes from the input package, a list of children
is created. For round 0, after deciding each child's (from santa's list) age, if they aren't a
young adult, the average score is being calculated and the nice score bonus is added (if necessary),
then the child is added to the list. Afterwards, the assigned budget is calculated and based on the
type of elf each child ha assigned, the budget is modified or not. Then, based on the strategy
specified for the current round and the type of elf assigned to a child, the gifts are being given
out to the children. For the next rounds, a new list is made every year and the children
who have yet to become young adults are added to the new list along with their new gifts preferences,
nice score history, new age and new assigned elf. Then, the new list of children from the annual
change is appended to the current list. A new budget is assigned to each child and as per round 0,
the gifts are being given out according to the yearly strategy and the children's preferences and
assigned elf. The output consists of the final "Nice List" that contains all the lists of children
from all years.

## Project Flow

### Input
These classes will not be modified.

AnnualChange
- loads from the input files
- stores:
    - new santa budget
    - list of new gifts
    - list of new children
    - list of updated for the already existing children
    - strategy type

ChildInput
- loads from the input files
- stores:
    - id
    - last name
    - first name
    - age
    - city
    - nice score
    - list of gifts preferences
    - nice score bonus
    - assigned elf

ChildUpdate
- loads from the input files
- stores:
    - id
    - new nice score
    - new list of gifts preferences
    - new assigned elf

InitialData
- loads from the input files
- stores:
    - list of children
    - list of gifts
    - list of cities

InputData
- loads from the input files
- stores:
    - the number of years the list is taken in account for
    - initial santa budget
    - instance of initialData
    - a list of annual changes

### Gifts
DeliverPresents
- abstract class that implements methods used for giving out gifts
- methods:
    - calculateBudgetUnit
    - getGifts
    - getGiftsFromCategory
    - sortByPrice

Gifts
- stores:
    - product name
    - price
    - category
    - quantity


#### Assignment (Strategy Pattern)
* AssignmentStrategy - strategy
* IdStrategy - concrete strategies
* NiceScoreStrategy - concrete strategies
* NiceScoreCityStrategy - concrete strategies
* YearlyRound - context class

+---------------------------+
| AssignmentStrategy        |
+---------------------------+                               +------------------------------------+
| + assignGifts()           |<------------------------------| YearlyRound                       |
+---------------------------+                               +------------------------------------+
^                                                           |  (...)                             |
|                                                           | + assignGifts(AssignmentStrategy)  |
|  +-------------------+                                    ------------------------------------ +
|- | IdStrategy        |                                    
|  +-------------------+                                    
|  | - childrenList    |                                    
|  | - santaGiftList   |                                    
|  +--------------------                                    
|  | + assignGifts()   |                                    
|  | + sortById ()     |                                    
|  +--------------------
|
|  +------------------- +                                   
|- | NiceScoreStrategy  |                                  
|  +------------------- +
|  | - childrenList     |                                  
|  | - santaGiftList    | 
|  + ------------------ +
|  | + assignGifts()    |
|  | + sameScoreGifts() |
|  | + sortByNiceScore()|                        
|  +---------------------                                
| 
|  +---------------------------+                               
|- |NiceScoreCityStrategy      |                                    
   +---------------------------+                                   
   | - childrenList            |                                   
   | - santaGiftList           |                                     
   +---------------------------+
   | + assignGifts()           |
   | + sameScoreCities()       |
   | + sortCitiesByNiceScore() |                         
   +---------------------------

#### Elves (Command Pattern)
* Santa - invoker class
* SantaWorkshop - command class
* BlackElf - concrete command class
* PinkElf - concrete command class
* WhiteElf - concrete command class
* YellowElf - concrete command class
* Elf - receiver

+---------------------------+
|  SantaWorkshop            |
+---------------------------+                               +------------------------------------+
| + doJob()                 |<------------------------------| Santa                              |
+---------------------------+                               +------------------------------------+
^                                                           | + talkToElves(Workshop)            |
|                                                           ------------------------------------ +
|  +-------------------+                                    
|- | BlackElf          |  --------------|                                
|  +-------------------+                |                    
|  | - elf             |                |                    
|  +--------------------                |                    
|  | + doJob()         |                |                    
|  +--------------------                |
|                                       |
|  +------------------- +               |                    
|- | PinkElf            | --------------|                            
|  +------------------- +               |
|  | - elf              |               |
|  + ------------------ +               |                         +------------------------------------+
|  | + doJob()          |               |------------------------>| Elf                                |                     
|  +---------------------               |                         +------------------------------------+
|                                       |                         | + blackElfJob()                    |   
|  +-------------------+                |                         | + pinkElfJob()                     |
|- | WhiteElf          | ---------------|                         | + whiteElfJob()                    |  
|  +-------------------+                |                         | + yellowElfJob()                   |
|  | - elf             |                |                         +------------------------------------+
|  +--------------------                |                   
|  | + doJob()         |                |                   
|  +--------------------                | 
|                                       |
|  +------------------ +                |                  
|-  YellowElf          | ---------------|                         
  +------------------- +
  | - elf              |                                  
  + ------------------ +
  | + doJob()          |                                    
  +---------------------


### Nice list
Child
- main class to store initial and updated data about a child
- has two constructors: one used in round 0 and another used for the yearly rounds
- implements abstract method calculateAverage used by the sub-classes to calculate the average nice score
- implements roundAverageScore used to round the average score if it passes the max value of 10
- stores:
    - id
    - last name
    - first name
    - age
    - city
    - average nice score
    - nice score history
    - list of gifts preferences
    - assigned budget
    - received gifts
    - nice score bonus
    - assigned elf

NiceList
- represents the final list with children from every year
- stores:
    - a list of lists of children (list of annual children)


#### Ages (Builder + Factory Pattern)

AgeRangeFactory (Abstract Factory Pattern)
- uses factory method to sub-class the age categories of the children
- the method is implemented twice to be used in both child classes of the rounds

+---------------------------+
| Child                     |
+---------------------------+
| (...)                     |                               +------------------------------------+
| + calculateAverageScore() |                               | AgeRangeFactory                    |
+---------------------------+                               +------------------------------------+
^                                                           |  (...)                             |
|                                                           | + chooseRange(AgeRange): Child     |
|  +---------------------------- +                          | -> factory method                  |
|- | Baby                        |<-----|                   ------------------------------------ +         
|  +---------------------------- +      |                                  |
|  | + calculateAverageScore()   |      |                                  |
|  +------------------------------      |                                  |
|                                       |                                  |
|  +---------------------------- +      |                                  |
|- | Kid                         |<-----|                                  |
|  +---------------------------- +      |                                  |
|  | + calculateAverageScore()   |      |----------------------------------|                      
|  +------------------------------      |                
|                                       |
|  +---------------------------- +      |                               
|- | Teen                        |<-----|                            
|  +---------------------------- +      |                               
|  | + calculateAverageScore()   |      |                              
|  +------------------------------      |
|                                       |
|  +---------------------------- +      |                               
|- | YoungAdult                  |<-----|                            
   +---------------------------- +                                     
   | + calculateAverageScore()   |                                    
   +------------------------------


Baby (Builder Pattern)
- extends class Child
- has two constructors:
  - one used to update the age range (if necessary) in the yearly rounds
  - a private constructor with a Builder parameter
- has a Builder inner class used to build instances of the specified age range
where the nice score bonus is optional
- overrides method calculateAverageScore to return 10.0

Kid (Builder Pattern)
- extends class Child
- also has two constructors:
  - one used to update the age range (if necessary) in the yearly rounds
  - a private constructor with a Builder parameter
- has a Builder inner class used to build instances of the specified age range
  where the nice score bonus is optional
- overrides method calculateAverageScore to calculate the arithmetic mean of all the nice
  scores in the child's nice score history

Teen (Builder Pattern)
- extends class Child
- also has two constructors:
  - one used to update the age range (if necessary) in the yearly rounds
  - a private constructor with a Builder parameter
- has a Builder inner class used to build instances of the specified age range
  where the nice score bonus is optional
- overrides method calculateAverageScore to calculate the ponderate mean of all the nice
  scores in the child's nice score history as follows:
  e.g. list = [7, 8, 9] => averageScore = (7 * 1 + 8 * 2 + 9 * 3) / (1 + 2 + 3)

YoungAdult (Builder Pattern)
- extends class Child
- also has two constructors:
  - one used to update the age range (if necessary) in the yearly rounds
  - a private constructor with a Builder parameter
- has a Builder inner class used to build instances of the specified age range
  where the nice score bonus is optional
- overrides method calculateAverageScore, but doesn't return anything as Young Adults will
  not be added to the nice list

#### Rounds
AnnualChildren
- abstract class
- stores the list of children from a year
- implements getAgeRange, assignBudget, doElvesJob and chooseStrategy methods

Round0
- extends AnnualChildren
- methods:
    - makeNiceList
    - calculateAge
    - checkIfYoungAdult
    - receiveGifts

YearlyRound
- extends AnnualChildren
- methods:
    - makeNiceList
    - calculateAge
    - checkIfYoungAdult
    - receiveGifts
    - childrenUpdate
    - updatePreferences
    - updateSantaGiftList
    - assignGifts

### Main
Main
- creates the directory for the output files
- parses the input from the json files
- entry-point
- writes the results in the output files
- calculates the score






