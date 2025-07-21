# HumbleShowcase

Spring Boot REST API pro správu klientů a pojištění.

## 🛠️ Tech Stack

- Java 21 + Spring Boot
- MySQL + JPA
- Spring Security
- Gradle

## 🚀 Spuštění

1. Vytvořte databázi `humble_data` v MySQL
2. Upravte připojení v `application.properties`
3. Spusťte: `./gradlew bootRun`

## 🔐 Přihlášení
- Username: `user`
- Password: `password`

## API Endpointy

**Klienti:**
- `GET /api/clients` - všichni klienti
- `POST /api/clients` - nový klient
- `PUT /api/clients/{id}` - upravit klienta

**Pojištění:**
- `GET /api/insurances` - všechna pojištění
- `POST /api/insurances?clientId={id}` - nové pojištění
│
