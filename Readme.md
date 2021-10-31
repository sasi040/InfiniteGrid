# Infinite Grid Design and Solution document.

### Assumptions:
* The grid is assumed to be in two-dimensional

### Design considerations:

* Cell, Grid and Machine are represented as entities/actors.
* A RulesEngine interface is declared which defines what is the next movement of the machine.
* A GridWriter interface defines the behavior to construct grid by considering all the movements of the machine
and also the behavior to serialize the grid to a file.
* The idea is to go with separation of concerns pattern, so we can achieve  different rules engine algorithms and
construction of different grids and serializing to a file.
* As mentioned in the problem a RESTful service is developed which accepts a HTTP PUT request
with number of steps as a path parameter and response is the path of the output file.
* In the output grid:
  1. A white cell is represented using '_'
  2. A black cell is represented using '#'
  3. Current position of the machine is represented using arrow symbol that indicates direction;  
  
### Improvements
* At the moment the construction of grid from the list of traversed cells is using extra space
of m *n to arrange the grid.
* As we move in an infinite grid, we need to have a better solution to collect all the positions instead
  to just keep in an in-memory HashSet. 
* The representation of grid in the text file can be improved to have better user experience.  
  
### Steps to execute the program:

1. Extract the zip file into any directory.
2. Go to application.properties file under  *src/main/resources* and give the path of the directory where text files are written.
   We can also configure *contextPath* and *port* here.
3. open a new command line terminal 
4. Run mvnw clean install
5. Run mvnw spring-boot:run
6. A web application is started using embedded tomcat running on port 8081(as mentioned in properties file)
7. A HTTP PUT endpoint is available: 
   http://localhost:8081/InfiniteGrid/navigate/${steps}
   
example: http://localhost:8081/InfiniteGrid/navigate/5
8. The response of the request contains the path to the output file.

######Thank you for the opportunity!! 

