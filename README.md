# Flight Booking API

## Overview
This is a simple Flight Booking API that allows users to register, login, book flights, and manage flight information. The API follows REST principles and provides endpoints for authentication and flight booking.

## Base URLs
- **Authentication Base URL:** `/api/auth`
- **Flight Management Base URL:** `/flights`

---

## API Endpoints

### **1. User Authentication Routes**

#### **Register a User**
- **Endpoint:** `POST /api/auth/register`
- **Request Body:**
  ```json
  {
    "username": "JohnDoe",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "message": "User registered successfully"
  }
  ```
  OR
  ```json
  {
    "message": "Username already exists"
  }
  ```

#### **Login a User**
- **Endpoint:** `POST /api/auth/login`
- **Request Body:**
  ```json
  {
    "username": "JohnDoe",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Login Successful; Welcome, JohnDoe"
  }
  ```
  OR
  ```json
  {
    "message": "Error! No such user"
  }
  ```

#### **Logout a User**
- **Endpoint:** `POST /api/auth/logout`
- **Request Body:**
  ```json
  {
    "username": "JohnDoe"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Logout Successful. Goodbye, JohnDoe"
  }
  ```
  OR
  ```json
  {
    "message": "User is not logged in"
  }
  ```

---

---

## Important Note on Booking Flights
Before booking a flight, **you must first login** using the `/api/auth/login` endpoint. If you try to book a flight without logging in, the API will return the following response:
```json
{
  "message": "You must first Log in!"
}
```
Ensure you authenticate before making a flight booking request.

---

### **2. Flight Management Routes**

#### **Add a Flight**
- **Endpoint:** `POST /flights/addflights`
- **Request Body:**
  ```json
  {
    "id": 1,
    "origin": "Mumbai",
    "destination": "Delhi",
    "booked": false,
    "bookedBy": null
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "origin": "Mumbai",
    "destination": "Delhi",
    "booked": false,
    "bookedBy": null
  }
  ```

#### **Delete a Flight**
- **Endpoint:** `DELETE /flights/deleteflight/{id}`
- **Path Variable:** `id` (Long)
- **Response:**
  ```json
  {
    "message": "Flight Deleted"
  }
  ```
  OR
  ```json
  {
    "message": "Flight Not Found"
  }
  ```

#### **Get All Flights**
- **Endpoint:** `GET /flights/getflights`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "origin": "Mumbai",
      "destination": "Delhi",
      "booked": false,
      "bookedBy": null
    },
    {
      "id": 2,
      "origin": "Delhi",
      "destination": "Bangalore",
      "booked": true,
      "bookedBy": "JohnDoe"
    }
  ]
  ```

#### **Get Available Flights**
- **Endpoint:** `GET /flights/availableflights`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "origin": "Mumbai",
      "destination": "Delhi",
      "booked": false,
      "bookedBy": null
    }
  ]
  ```

#### **Get Specific Flights**
- **Endpoint:** `GET /flights/getspecificflights`
- **Query Parameters:**
  - `origin` (String)
  - `destination` (String)
- **Example Request:**
  `/flights/getspecificflights?origin=Mumbai&destination=Delhi`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "origin": "Mumbai",
      "destination": "Delhi",
      "booked": false,
      "bookedBy": null
    }
  ]
  ```

#### **Book a Flight**
- **Endpoint:** `POST /flights/bookflight`
- **Request Body:**
  ```json
  {
    "username": "JohnDoe",
    "origin": "Mumbai",
    "destination": "Delhi"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Successfully booked!"
  }
  ```
  OR
  ```json
  {
    "message": "No Available Flights!"
  }
  ```
  OR
  ```json
  {
    "message": "You must first Log in!"
  }
  ```

---

## Testing with Postman
You can use **Postman** to test these API endpoints by sending the appropriate requests with the correct request body and checking the responses.

---



