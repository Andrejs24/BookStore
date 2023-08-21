This is Book-Store Server and DataBase part.
--
## Getting Started

You need to clone this code to you IDE, then start code with BookStoreAplication.java
it's also nescessary to have PostgreSQL database on your device to set database.
If you prefer to work with another DB you can manage DataBaseConfiguration class, but don't forget to add Driver dependency for you specific Database
Now you are able to send requests to server side and manage data into database.

When all previous steps are passed you can start UI part
which you can find in here ---> https://github.com/Andrejs24/book-store

Data Flow 
--
<img src="https://zellwk.com/images/2019/frontend-vs-backend/server.png" alt="Data flow" >

# Advantages and Disadvantages of Decoupled Architecture

| **Advantages**                                      | **Disadvantages**                                 |
|-----------------------------------------------------|---------------------------------------------------|
| - Scalability: This architecture allows you to scale different components independently.   | - Complexity: Managing communication between components can be complex.  |
| - Flexibility: You can use the best-suited technologies for each component.               | - Performance Overhead: Communication over a network can introduce performance overhead.  |
| - Team Independence: Different teams can work on components simultaneously.               | - Increased Development Time: Coordinating development efforts can result in longer timelines. |
| - Isolation: Issues in one area are less likely to affect the others.                    | - Resource Overhead: Running multiple components requires more resources. |
| - Interoperability: It enables integration with other systems and third-party services.  | - Consistency and Data Synchronization: Ensuring data consistency can be challenging. |
                                                                                         
