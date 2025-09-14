# Hotel Management System (HMS)

## Description

This is a simple console-based Hotel Management System developed in Java. It allows for managing customer information, room services, and generating invoices.

## Features

- Add new customers with room details and type.
- Provide room services (food, cleaning, car service).
- Generate detailed invoices for customer stays.
- Display a list of all current customers.
- Checkout customers and free up rooms.
- Member discount calculation.

## How to Run

1.  **Compile the Java files:**
    ```bash
    javac -d . HMS.java hotelpkg/*.java
    ```
2.  **Run the main application:**
    ```bash
    java HMS
    ```

## Project Structure

```
assignment/
├── HMS.java
└── hotelpkg/
    ├── action.java
    ├── Customer.java
    ├── Hotel.java
    └── member.java
```

## Usage

Follow the on-screen menu to interact with the Hotel Management System. You can add customers, assign rooms, add services, generate invoices, view all customers, and checkout customers.
