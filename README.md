# FoodTrucks
This is a Web API service for food trucks in the San Francisco area. It offers the following features:

* Randomly select a food truck. Can't decide which one to eat at? Why not roll the dice and pick one. Options include food type, truck type, and distance range.
* Choose a food truck by name. Want to eat at a specific one? Check out its detailed information.


## API Endpoints

### 1. Choose a Food Truck Randomly
**Endpoint:** `/search/foodTruck/random`  
**Method:** `POST`  
**Description:** Selects a food truck randomly based on the given conditions.  
**Request Body:**
```json
{
  "facilityType": "string",
  "food": "string",
  "userLocation": {
    "latitude": double,
    "longitude": double
  },
  "distance": double
}
```
**Response:**
```json
{
  "status": "success",
  "data": {
    "id": long,
    "name": "string",
    "locationDescription": "string",
    "shopHours": "string",
    "latitude": double,
    "longitude": double,
    "foodItems": ["string"]
  }
}
```

### 2. Choose Food Truck by Name
**Endpoint:** `/search/foodTruck/byName`  
**Method:** `GET`  
**Description:** Fetches the details of a food truck by its name.  
**Query Parameters:**
- `foodTruckName`: string  
  **Response:**
```json
{
  "status": "success",
  "data": {
    "id": long,
    "name": "string",
    "locationDescription": "string",
    "shopHours": "string",
    "latitude": double,
    "longitude": double,
    "foodItems": ["string"]
  }
}
```

### TODO
* Improve data storage methods: Due to time constraints, the current system simply parses CSV files without any data storage. For production deployment, it is necessary to store data in a database and consider using caching.
* Add logging
* Implement rate limiting and circuit breaker mechanisms
* Containerization

### Reference
* data source: https://data.sfgov.org/Economy-and-Community/Mobile-Food-Facility-Permit/rqzj-sfat/data