# CSV Upload to H2 Database

This project is a Java Spring Boot application that allows users to upload CSV files, store the data in an H2 database, and display the uploaded data on a web interface. The application demonstrates the integration of Spring Boot with an in-memory H2 database, file upload capabilities, and basic data visualization.

## Features

- CSV File Upload: Users can upload CSV files directly from the web interface.
- Data Storage: The application stores the uploaded data in an H2 database.
- Data Display: Users can view the uploaded data in a user-friendly format on the web page.

## Technologies Used

- Java: The primary programming language.
- Spring Boot: For building the RESTful application.
- H2 Database: An in-memory database for storing uploaded data.
- Thymeleaf: For rendering the web interface.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

#### 1. Clone the repository:

```
git clone https://github.com/christiantiquis/csv-upload.git
```

#### 2. Navigate to the project directory:

```
cd csv-upload-h2
```

#### 3. Build the project:

```
mvn clean install
```

#### 4. Run the application:

```
mvn spring-boot:run
```
