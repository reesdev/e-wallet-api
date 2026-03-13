# E-Wallet API

Simple REST API for managing digital wallet transactions using Spring Boot.

## Features

* Create wallet
* Check wallet balance
* Top up wallet balance
* Make payment
* Transfer balance between wallets

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL / H2
* Maven

## API Endpoints

Create Wallet

POST /wallet

Example Request

{
"owner": "Reesky"
}

---

Get Wallet

GET /wallet/{id}

---

Top Up Balance

POST /wallet/{id}/topup?amount=5000

---

Payment

POST /wallet/{id}/pay?amount=2000

---

Transfer Balance

POST /wallet/transfer?fromId=1&toId=2&amount=1000

## Project Structure

controller
service
repository
entity
dto
exception

## Author

Reesky
