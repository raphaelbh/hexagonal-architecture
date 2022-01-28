# Kotlin + Hexagonal Architecture

## Overview

**Kotlin**

A modern programming language that makes developers happier.

https://kotlinlang.org/


**Hexagonal Architecture**

![alt text](assets/images/arch.png)

The hexagonal architecture, or ports and adapters architecture, is an architectural pattern used in software design. It aims at creating loosely coupled application components that can be easily connected to their software environment by means of ports and adapters. This makes components exchangeable at any level and facilitates test automation.

https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c


## Use cases

### Save user transaction
**Business Rules (Domain)**
- Required input parameters: user, amount, description
- Persist transaction
- Notify user (email)

### Get user transactions
**Business Rules (Domain)**
- Required input parameters: user
- Optional input parameters: date
- When no date informed, returns transactions for the current date
- When date informed, returns transactions from the informed date
- Output: list of transactions (id, user, date time, amount, description)


### Adapters

**Primary (IN)**
- http (web)

**Secondary (OUT)**
- Persistence transaction
- Send e-mail


## Project Structure

```
- domain
--- models
--- services
--- ports
- adapters
--- in (primary)
--- out (secondary)
```
