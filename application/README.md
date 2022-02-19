# Bank Application

Application used to keep and provide user's transactions.

## Use cases
- Save transaction
- Get transactions

## Adapters

### Primary (IN)
- http (web)

### Secondary (OUT)
- datasource (transactions)
- email

## Application Structure
    .
    ├── domain
    │   ├── models
    │   ├── ports
    │   └── services
    ├── adapters
    │   ├── in
    │   └── out
    └── ..