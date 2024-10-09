# fetch-receipt-processor-challenge
This repository holds my submission for the Fetch Receipt Processor Challenge

## Receipt Processor Challenge

This project implements a receipt processing service that allows users to submit receipts and calculate points based  on the receipt details. The Application is built with Java 21 using the Spring Boot Framework and is Dockerized for easy deployment.

The service exposes two REST API endpoints:
-Submit a receipt to process it.
-Retrieve the reward points for a given receipt by its ID.

## Prerequisites
-Docker: Ensure Dock is installed on your machine.
-Mave: (Optional) If you'd like to build the project manually without Docker.

## Running the Application with Docker

1. Clone the repository:
git clone https://github.com/Zaysman/fetch-receipt-processor-challenge.git
cd receipt_processor_challenge

2. Build the Docker image:
docker build -t receipt-processor .

3. Run the container
docker run -p 8080:8080 receipt-processor

## Usage
Once the Application running, use Postman or your method of choice to access the avaliable endpoints.

Available Endpoints:
-/receipts/process - Returns a response object containing the id of the receipt that was sent to it.
-/receipts/{id}/points - Returns a response object containing the points of the receipt whose Id was passed to it.

##Submit a Receipt
-EndPoint: `POST /receipts/process`
-Content-Type: `application/json`
-Example request body:
{
  "retailer": "Target",
  "purchaseDate": "2022-01-01",
  "purchaseTime": "13:01",
  "items": [
    {
      "shortDescription": "Mountain Dew 12PK",
      "price": "6.49"
    },{
      "shortDescription": "Emils Cheese Pizza",
      "price": "12.25"
    },{
      "shortDescription": "Knorr Creamy Chicken",
      "price": "1.26"
    },{
      "shortDescription": "Doritos Nacho Cheese",
      "price": "3.35"
    },{
      "shortDescription": "   Klarbrunn 12-PK 12 FL OZ  ",
      "price": "12.00"
    }
  ],
  "total": "35.35"
}

## Retrieve Receipt Points
-Endpoint `GET /receipts/{id}/points`
-Replace `{id}` with the ID of the receipt obtained from the receipts/process endpoint.
-Example request link: localhost:8080/receipts/AcjK1ACV-Q8JV-czOp-u6hD-FJNyweTm2nOE/points
--"AcjK1ACV-Q8JV-czOp-u6hD-FJNyweTm2nOE" is the id.
 
