## Setting Up the Spring Boot Backend Locally

## Clone the Repository:
   
git clone https://github.com/<your-username>/BookManagementBackend.git
cd BookManagementBackend

Install Dependencies:
Ensure you have:
Java 17+
Maven
MySQL installed and running

Create MySQL Database:
CREATE DATABASE bookdb;

Configure application.properties
Update the following in src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/bookdb
spring.datasource.username=root
spring.datasource.password=root

Or use environment variables (recommended for production/deployments):
spring.datasource.url=jdbc:mysql://${DATABASE_HOST:localhost}:${DATABASE_PORT:3306}/${DATABASE_NAME:bookdb}
spring.datasource.username=${DATABASE_USER:root}
spring.datasource.password=${DATABASE_PASSWORD:root}

Build & Run
./mvnw spring-boot:run
From IDE:
Run BookManagementSystemApplication.java

Installing Required Dependencies
Handled automatically by Maven when you run:
./mvnw clean install
Or in IDEs like Eclipse/IntelliJ: Right Click > Maven > Update Project.

## Setting Up Environment Variables:
If deploying on Render, use environment variables like:
DATABASE_URL
DATABASE_USER
DATABASE_PASSWORD
Make sure your application.properties handles default values:

spring.datasource.url=jdbc:mysql://${DATABASE_HOST:localhost}:${DATABASE_PORT:3306}/${DATABASE_NAME:bookdb}
spring.datasource.username=${DATABASE_USER:root}
spring.datasource.password=${DATABASE_PASSWORD:root}

## Deployment on Render:
Push your backend code to GitHub.
Go to https://dashboard.render.com.
Click New Web Service → Connect your GitHub repo.
Configure:
Environment: Java 17
Build Command: ./mvnw clean install
Start Command: ./mvnw spring-boot:run
Add these Environment Variables:
DATABASE_HOST
DATABASE_PORT
DATABASE_NAME
DATABASE_USER
DATABASE_PASSWORD

## API Documentation:
Base URL
https://your-backend-app.onrender.com/books

Add a New Book
URL: POST /books
Description: Adds a new book to the database.
Request Body (JSON):
{
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "publicationDate": "1988-03-15",
  "isbn": "9780061122415",
  "genre": "Fiction",
  "rating": 5
}
Response Example:
{
  "id": 1,
  "bookId": "B-001",
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "publicationDate": "1988-03-15",
  "isbn": "9780061122415",
  "genre": "Fiction",
  "rating": 5
}


Get All Books
URL: GET /books
Description: Retrieves a list of all books.

Response Example:
  {
    "id": 1,
    "bookId": "B-001",
    "title": "The Alchemist",
    "author": "Paulo Coelho",
    "genre": "Fiction"
  },
  {
    "id": 2,
    "bookId": "B-002",
    "title": "1984",
    "author": "George Orwell",
    "genre": "Sci-Fi"
  }


Get Book by ID
URL: GET /books/{id}
Description: Fetches details of a book by its internal ID.
Example:
GET /books/1
Response Example:
{
  "id": 1,
  "bookId": "B-001",
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "publicationDate": "1988-03-15",
  "isbn": "9780061122415",
  "genre": "Fiction",
  "rating": 5
}

Delete Book
URL: DELETE /books/{id}
Description: Deletes a book by its internal ID.
Example:
DELETE /books/1
Response:
HTTP 204 No Content

Update Book
URL: PUT /books/{id}
Description: Updates the details of an existing book.
Example:
PUT /books/1
Request Body:
{
  "title": "Updated Title",
  "author": "Updated Author",
  "publicationDate": "2020-01-01",
  "isbn": "1234567890123",
  "genre": "Mystery",
  "rating": 4
}
Response Example: Same as updated book object.


## Search via Google Books API (Proxy):
URL: GET /books/search?query={book title}
Description: Searches external book data via Google Books API through the backend.
Example:
GET /books/search?query=The Alchemist
Response Example:
Returns full JSON from Google Books API — including title, description, image links, etc.

## Database Schema (MySQL):
### Table: `books`

| Column Name       | Data Type     | Constraints                |
|-------------------|---------------|----------------------------|
| id                | INT           | Primary Key, Auto Increment |
| book_id           | VARCHAR(20)   | Unique, Not Null           |
| title             | VARCHAR(100)  | Not Null                   |
| author            | VARCHAR(50)   | Not Null                   |
| publication_date  | DATE          | Not Null                   |
| isbn              | VARCHAR(13)   | Unique, Not Null           |
| genre             | VARCHAR(20)   | Not Null                   |
| rating            | INT           | Between 1 and 5            |


