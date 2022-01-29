# Transactions App

## Overview

App used to keep and provide user's transactions.


## Use cases

### Save transaction
**Business Rules (Domain)**
- Required input parameters: user, amount, description
- Persist transaction
- Notify user (email)

### Get transactions
**Business Rules (Domain)**
- Required input parameters: user
- Optional input parameters: date
- When no date informed, returns transactions for the current date
- When date informed, returns transactions from the informed date
- Output: list of transactions (id, user, date time, amount, description)


### Adapters

**Primary (IN)**
- http (web)
- cli

**Secondary (OUT)**
- datasource transactions
- email


## Project Structure

```
-- domain
----- models
----- services
----- ports
-- adapters
----- in (primary)
----- out (secondary)
```
