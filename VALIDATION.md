# Validace v HumbleShowcase

Tento dokument popisuje implementovanou validaci v aplikaci.

## 🔍 Přidané validace

### Client model
- **name**: Povinné, 2-100 znaků, pouze písmena a mezery
- **email**: Povinné, platný email formát, max 150 znaků
- **phone**: Povinné, formát +420123456789 nebo 123456789
- **personalNumber**: Povinné, formát 123456/7890
- **address**: Povinné, 5-200 znaků

### Insurance model
- **insuranceType**: Povinné, 3-50 znaků, pouze písmena a mezery
- **client**: Povinné, musí být přiřazen klient

## 🛠️ Implementované funkce

1. **Bean Validation**: Použití Jakarta Validation API
2. **Global Exception Handler**: Centralizované zpracování validačních chyb
3. **Chybové odpovědi**: Strukturované JSON odpovědi s detailními chybami
4. **Testování**: Ukázkové testy pro validaci

## 📝 Příklady chybových odpovědí

### Validační chyba
`json
{
  "message": "Validační chyby",
  "errors": {
    "name": "Jméno nesmí být prázdné",
    "email": "Email musí mít platný formát"
  },
  "status": 400
}
`

### Chyba při hledání klienta
`json
{
  "message": "Klient nebyl nalezen: Client not found with id: 123",
  "status": 400
}
`

## 🧪 Spuštění testů

`ash
./gradlew test
`

## 📚 Použité anotace

- @Valid: Aktivuje validaci
- @NotBlank: Nesmí být prázdné
- @NotNull: Nesmí být null
- @Email: Validace emailu
- @Size: Validace délky
- @Pattern: Validace regulárním výrazem
