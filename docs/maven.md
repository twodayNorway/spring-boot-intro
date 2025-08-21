# Introduksjon til Maven

Maven er et byggeverktøy for Java-prosjekter (og Kotlin, Scala m.m.) som hjelper med:
- Kompilering
- Testing
- Avhengigheter (dependencies)
- Pakking (f.eks. JAR/war)
- Kjøring
- Deploy
- Prosjektstruktur og standardisering

## Hvorfor bruke Maven?
- Standardisert prosjektstruktur
- Automatisk håndtering av tredjepartsbiblioteker
- Lett å bygge og kjøre prosjekter uansett plattform
- Stort økosystem og integrasjon med de fleste IDE-er (IntelliJ, Eclipse, VS Code)
- Enkelt å bruke i CI/CD-pipelines

## Maven-livssyklus (Lifecycle)
Maven bygger på en definert livssyklus bestående av "phases". Når du kjører f.eks. `mvn package`, vil Maven automatisk kjøre alle fasene før `package` i riktig rekkefølge.

De tre viktigste livssyklusene:

- **default** – den vanlige byggeprosessen (kompilering, testing, pakking osv.)
- **clean** – rydder opp etter forrige bygg (sletter `target/`)
- **site** – genererer dokumentasjon (lite brukt i vanlige prosjekter)

Eksempler på faser i `default`-livssyklusen:
1. `validate` – sjekker at prosjektet er korrekt og komplett
2. `compile` – kompilerer kildekode
3. `test` – kompilerer og kjører tester
4. `package` – pakker prosjektet (f.eks. JAR)
5. `verify` – kjører integrasjonstester (om definert)
6. `install` – installerer artefaktet i lokal repo (~/.m2)
7. `deploy` – publiserer til ekstern repo (f.eks. Nexus)

> 🔁 Når du kjører en senere fase, f.eks. `mvn package`, så kjøres alle forutgående faser automatisk.

---

## Hvordan Maven håndterer avhengigheter

Maven bruker **repositories** (lager) for å finne og laste ned avhengigheter:

- **Eksternt repository**: Maven Central er det mest brukte. Her finner du tusenvis av biblioteker som Spring, JUnit, Apache Commons osv.
- **Lokalt repository**: Maven lagrer alle nedlastede avhengigheter i en lokal mappe (`~/.m2/repository`). Dette gjør at prosjekter kan bygges raskt og uten nett når avhengighetene først er lastet ned.
- **Avhengighetskoordinater**: Hver avhengighet identifiseres unikt med tre hovedverdier:
  - `groupId` – f.eks. `org.springframework.boot`
  - `artifactId` – f.eks. `spring-boot-starter-web`
  - `version` – f.eks. `3.2.0`

Eksempel på avhengighet i `pom.xml`:

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>3.2.0</version>
</dependency>
```

## Agenda: 1 times introduksjon til Maven

### 🕒 0–10 min: Hva er Maven?
- Kort historikk og formål
- Sammenligning med andre byggeverktøy (Gradle, Ant)
- Typisk bruksområde i prosjekter

### 🕒 10–20 min: Prosjektstruktur
- Gjennomgang av standard Maven-struktur (`src/main/java`, `src/test/java`, osv.)
- Forklaring av `pom.xml`
- Enkel demo: navigere i et eksisterende Maven-prosjekt

### 🕒 20–40 min: Bygg og kjør
- Viktige kommandoer:
- `mvn compile`
- `mvn test`
- `mvn package`
- `mvn spring-boot:run` (ved bruk av Spring Boot)
- Hvordan legge til og oppdatere avhengigheter (`<dependencies>` i `pom.xml`)
- Demo: Legge til en avhengighet og bruke den i koden

### 🕒 40–50 min: Testing og plugins
- Hvordan kjøre tester
- Demo: skrive en enkel test og kjøre med `mvn test`
- Bruk av plugins (kort nevnt):
- Surefire Plugin (testing)
- Spring Boot Plugin
- Shade Plugin (lage fat jar)

### 🕒 50–60 min: Oppsummering og spørsmål
- Oppsummering av hovedpunktene
- Tips til videre læring
- Spørsmål og svar

---

## Nyttige kommandoer

```bash
mvn clean         # Rens bygget
mvn compile       # Kompilerer kildekoden
mvn test          # Kjører tester
mvn package       # Lager JAR-fil
mvn install       # Installerer artefakt i lokal repo
mvn spring-boot:run  # Kjører Spring Boot-applikasjonen (dersom Spring Boot-plugin er konfigurert)
```

