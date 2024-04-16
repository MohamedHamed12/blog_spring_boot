
# Blog Application

This is a simple blog application built with Spring Boot, featuring authentication and post management functionalities.

## Features

- User registration and authentication
- Creating, reading, updating, and deleting posts
- JSON Web Token (JWT) based authentication
- RESTful API for post management


## Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database (for development)
- Mockito & JUnit (for testing)
- Maven

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/MohamedHamed12/blog_spring_boot.git
   ```

2. Navigate to the project directory:

   ```bash
   cd blog_spring_boot
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   java -jar target/blog-application.jar
   ```

5. Access the application at [http://localhost:8080](http://localhost:8080)

## Configuration

- The application uses an H2 in-memory database by default for development.
- You can configure the database settings in the `application.properties` file.
- Security configurations are defined in the `SecurityConfiguration` class.
- Adjust the configurations as needed for your environment.

## Testing

- Unit tests and integration tests are provided in the `src/test` directory.
- You can run tests using the following command:

  ```bash
  mvn test
  ```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
