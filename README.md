Spring Boot Movie Watchlist App

A dynamic Java Spring Boot web application for tracking your favorite movies. Built using Spring MVC architecture with form validation, custom models, and production-ready features.

## Features

- Add and manage watchlist items (title, rating, priority, comment)
- Server-side form validation with Thymeleaf
- MVC design pattern using controllers, models, and views
- Auto-incrementing movie IDs
- Redirect view logic with model binding
- Spring Boot Actuator enabled for application monitoring

## Tech Stack

- Java 17+
- Spring Boot
- Thymeleaf
- Maven
- HTML5 + Bootstrap
- IntelliJ IDE

Project Structure

watchlist/ ├── WatchlistController.java ├── WatchlistItem.java └── templates/ └── watchlist.html └── watchlistItemForm.htm

**How to Run**

Clone the repo:
"bash"
git clone https://github.com/Komlavi-Djossou/MVC-Framework.git
Navigate to the project:

bash
cd watchlist-app
Run the application:

bash
./mvnw spring-boot:run
Visit in browser:
http://localhost:8080/watchlist


**Future Enhancements**
Persist data with a database (MySQL / H2)

Add authentication and user-specific watchlists

Connect to a real-world API for movie info

Improve styling with custom CSS

Author
Made by Komlavi
