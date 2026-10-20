# ShopLite — E-Commerce Application

ShopLite is an internship demo e-commerce application built with Java 17, Spring Boot, Spring Data JPA/Hibernate, MySQL, REST APIs, and an HTML/CSS/JavaScript storefront.

## Features
- Product catalog with product/category search
- Shopping cart with quantity changes and totals
- Checkout with simulated payment (no real money or card details)
- Order confirmation and order history endpoints
- Stock validation and inventory reduction after successful checkout
- MySQL persistence and automatic sample product seeding on first startup

## Technology stack
Java 17 · Spring Boot 3.4.5 · Spring Web · Spring Data JPA/Hibernate · MySQL 8+ · Maven · HTML/CSS/JavaScript

## Project structure
```text
ShopLite/
├── pom.xml
├── README.md
├── .gitignore
└── src/main/
    ├── java/com/internship/shoplite/
    │   ├── ShopLiteApplication.java
    │   ├── config/DataSeeder.java
    │   ├── controller/ (ProductController, OrderController, ApiExceptionHandler)
    │   ├── dto/CheckoutRequest.java
    │   ├── model/ (Product, CustomerOrder, OrderItem)
    │   ├── repository/ (ProductRepository, CustomerOrderRepository)
    │   └── service/ShopService.java
    └── resources/
        ├── application.properties
        └── static/index.html
```

## Run on Windows PowerShell
1. Install JDK 17, Maven, and MySQL.
2. Create the database in MySQL Workbench: `CREATE DATABASE shoplite_db;`
3. In the project root, set database credentials in the same PowerShell terminal:
   ```powershell
   $env:DB_USERNAME = "root"
   $env:DB_PASSWORD = Read-Host "Enter your MySQL password"
   ```
   If your MySQL account has no password, use `$env:DB_PASSWORD = ""`. Never commit your real password.
4. Start the app: `mvn spring-boot:run`
5. Open `http://localhost:8080/`.

## REST API
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/products` | List products |
| GET | `/api/products?search=watch` | Search by product name/category |
| GET | `/api/products/{id}` | Get product details |
| POST | `/api/orders` | Place order with simulated payment |
| GET | `/api/orders` | List orders |
| GET | `/api/orders/{id}` | Get one order |

### Example checkout request
```json
{
  "customerName": "Alex Kumar",
  "customerEmail": "alex@example.com",
  "paymentMethod": "DEMO_CARD",
  "items": [{ "productId": 1, "quantity": 2 }]
}
```

The payment status is `SIMULATED_SUCCESS`; this project does not process real payments. `spring.jpa.hibernate.ddl-auto=update` is intended for local development, not production.
