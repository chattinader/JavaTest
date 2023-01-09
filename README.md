# JavaTest

### Description
Java test api rest, une implémentation Java Spring Boot de services REST qui permettent de créer un utilisateur, lister tous les utilisateurs et lister les détails d'un utilisateur avec la recherche par **Email**.

### L'aplication contient
- Un programme en Java Spring boot
- Une interface web permettant la mise en pratique graphiquement des méthodes REST

## Lancer l'application
### Prérequis
- Java 11
- MongoDB installé et démarré sur la machine

### Dépendances utilisées
- spring-boot-starter-data-mongodb
- spring-boot-starter-web
- lombok

### Etapes
Captures d'écran sous le dossier [screenshots](https://github.com/chattinader/JavaTest/tree/main/screenshots)

- Cloner le projet (git clone)
- Ouvrir le projet dans un IDE (Eclipse, IntelliJ, ..)
- Exécuter le programme
- 2 moyens de tester les méthodes
  - L'interface graphique
    - Aller dans le dossier **client** et double-cliquer sur **index.html**
    - L'interface graphique se lance sur le navigateur
    - Tester les différentes méthodes présentes
      <img src="https://github.com/chattinader/JavaTest/blob/2de317c839119064a8ef36180e7d4a65b66925c7/screenshots/UI%20search.png" width="75%" heigth="75%">
  - Postman (ou une autre application du même type)
    - 3 méthodes a testé
      - Get all users | GET method, url => http://localhost:8080/api/v1/users, aucun param, aucun body
      - Get user by email | Get method, url => http://localhost:8080/api/v1/user?email=example@email.com, param => email, aucun body
      - Register user | POST method, url => http://localhost:8080/api/v1/register, aucun param, body => JSON contenant les détails utilisateur (ex ci-dessous)
     
      ```
      {
        "firstName": "Jean", 
        "lastName": "Marc", 
        "dateOfBirth": {
          "day": 7, 
          "month": 7, 
          "year": 1992
        }, 
        "email": "jmarc@gmail.com", 
        "gender": "MALE", 
        "address": {
          "number": "15", 
          "street": "Avenue de la liberté", 
          "city": "Nice", 
          "zipCode": "06000", 
          "country": "France"
        }
      }
      ```
