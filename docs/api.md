## Hvordan avtaler vi et API? – API som kontrakt

Når to systemer skal kommunisere, må de bli enige om hvordan. Dette skjer gjennom en **API-kontrakt** – en definisjon av:
- Hvilke endepunkter som finnes (f.eks. `/customers`, `/orders/{id}`)
- Hvilke metoder som støttes (`GET`, `POST`, `PUT`, `DELETE`)
- Hvilke data som forventes inn (request)
- Hvilke data som kommer ut (response)
- Feilmeldinger og statuskoder
- Eventuell sikkerhet (f.eks. tokens, API-nøkler)

### Hvorfor er dette viktig?
- API-et kan utvikles parallelt av ulike team (backend og frontend)
- Endringer må være trygge og forutsigbare
- Automatisk generering av dokumentasjon og klientkode blir mulig
- Mindre misforståelser – færre bugs

### Hvordan avtales kontrakten?

Det finnes flere måter å dokumentere og avtale et API på:

#### ✍️ Manuelt i dokumentasjon
- Enkle API-er kan beskrives i Notion, Confluence eller lignende
- Gjerne med eksempler på JSON inn og ut

#### 📄 Maskinlesbare spesifikasjoner (standard)
- **OpenAPI (Swagger)** – mest brukt i dag for REST
    - JSON eller YAML-format
    - Kan generere både dokumentasjon og kode (f.eks. klienter)
- **GraphQL SDL** – hvis man bruker GraphQL
- **WSDL** – eldre format brukt av SOAP-tjenester

#### 🔄 API-first utvikling
- Man starter med å definere kontrakten (f.eks. i OpenAPI) før man skriver koden
- Koden genereres eller tilpasses ut fra spesifikasjonen

---

### Eksempel: En enkel OpenAPI-definisjon (YAML)

```yaml
paths:
  /customers:
    get:
      summary: Hent alle kunder
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Customer'
components:
  schemas:
    Customer:
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
```

## Hva er REST?

REST står for Representational State Transfer og er den vanligste måten å tilby API-er på i dag.

Et REST-API:
- Er en standard for internettkommunikasjon
- Er stateless – hver forespørsel er uavhengig og komplett
- Kobler klient og tilbyder fra hverandre, så de kan utvikles separat
- Bruker HTTP-metoder: GET, POST, PUT, DELETE, osv.
- Sender og mottar data som oftest i JSON-format
- Opererer på ressurser via URL-er, som f.eks. /customers, /tasks/42

Det finnes også andre alternativer, som SOAP og asynkrone meldingsbaserte tjenester (Kafka, SQS, osv.), men i dette kurset fokuserer vi på REST.

⸻

## Hva er en controller?

En controller er komponenten i backend-applikasjonen som:
- Styrer trafikk inn og ut av applikasjonen
- Definerer API-endepunktene, som f.eks. GET /api/tasks
- Ruter trafikken til riktig tjenestelogikk
- Returnerer data – oftest i JSON

I praksis er det controlleren som «snakker» HTTP og kobler forespørsler fra brukere (f.eks. frontend eller tredjepartssystemer) til backend-logikken.

👉 Dette er grunnlaget for det du straks skal gjøre i praksis:
Du skal lage en REST-tjeneste med Spring Boot der du definerer endepunkter i en controller.

## Hva er en tjeneste (Service)?

En **service** er en komponent i backend-applikasjonen som:

- Utfører **forretningslogikk** (business logic)
- Har ikke ansvar for HTTP eller trafikk, men for det som faktisk skjer «bak kulissene»
- Kan integrere mot andre tjenester, databaser, komponenter og eksterne systemer
- Gjør koden mer modulær og testbar ved å separere logikk fra controller

I et typisk Spring Boot-oppsett vil controlleren håndtere forespørselen, og delegere det som skal gjøres videre til en service.

> 🧱 Du kan tenke på controlleren som dørvakten og servicen som kokken på kjøkkenet.