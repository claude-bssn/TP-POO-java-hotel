## TP – Cahier des charges

### Créer une application métier qui permet de gérer un hôtel:

- √ Gérer les réservations (vérifier si chambre disponible et nettoyée et libérée) 

- √ Gérer le nettoyage des chambres (vérifier si la chambre a été réservée)

- √ Gérer les clients et leurs commandes (la liste des réservations du client)

### Exclusion

- L’application ne nécessite pas de stockage en base de données, ni d’IHM (Interface Homme Machine)

- Le checkin et checkout ne sont pas pris en compte

### Tests

- L’hôtel a 30 chambres, 10 chambres par étage

- Une femme de ménage peut nettoyer 10 chambres

- Deux clients réserveront au moins 11 chambres la même journée

## TP – Critères dévaluation

### Développer l’application de gestion de l’hôtel en java (20 points)

- Respecter le cahier des charges

- Avoir une application qui fonctionne : des tests automatiques (main) devront permettre de
vérifier le bon fonctionnement de l’application, avec un jeu de données

- Respecter les bonnes pratiques de développement (nommages, commentaires, conception, …)

### Intégrer les éléments de la POO (30 points)

- √ Surcharger une méthode

- √ Créer deux constructeurs

- √ Override toString (pour retourner la class)

- √ Créer un héritage entre deux classes avec extends et implements

- √ Implémenter le pattern singleton

- √ Utiliser l’encapsulation

# conception 
interface Hotel
- getAllRoom
- getReservableRoom

helper GestionHotel singleton
membre => ArrayList\<Reservation\>
- getAllClient
- getRoomByClient
- setReservation 
  - ne peut pas être réservé si :
    - une chambre sale
    - est occupé
  - les réservations se font au jour le jour 

- setCleaningRoom 
  - une chambre doit être nettoyée:
    - seulement si elle est salle
  - pas de délais de nettoyage
  - se fait en début de journée 


class Hotel 
- rooms []
- override de toString pour retourner l'hotel

class Room
- available bool
- clean bool
<!-- - free bool -->
- name

class Reservation
- client name
- chambre name
- date (journée)

les réservations sont d'une durée d'une seule journée à chaque fois

class Client
- name 

<!-- class Nettoyage 
- une chambre propre ne peut pas être nettoyer  -->