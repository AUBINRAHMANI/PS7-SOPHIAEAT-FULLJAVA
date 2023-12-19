# SopiaTech Eats-Team-23-24 



## TEAM O

Wassim BARATLI : Rôle PO

Aubin RAHMANI : Rôle QA

Valentin PODDA : Rôle SA



## .github
   1. Contient sous workflows/maven.yml, une version d'un fichier d'actions qui est déclenché dès que vous poussez du code. 
Sur cette version initiale seule un test Junit5 est déclenché pour vérifier que tout fonctionne.
       - Github Actions (See in .github/workflows) to simply make a maven+test compilation
  2. Contient sous ISSUE_TEMPLATE, les modèles pour les issues user_story et bug. Vous pouvez le compléter à votre guise.

## src
 - pom.xml :  
       - Cucumber 7 et JUnit 5  
       - JDK 17   
       - Etc.  

## Lancement du projet 

Pour lancer les tests, executeer les commandes suivantes à la racine du projet : 

```mvn test```

```mvn clean package```

  

## Principales User Stories




⭐ Choisir un restaurant #1    

As a a customer “Toto” , I want“Toto” choose the restaurant “Nice” so that he will be able to add dishes from the restaurant “Nice”


⭐ Choisir un plat #2

As a a customer “Toto” who has chosen the restaurant “Nice”, I want“Toto” add a dish “Pizza” so that the order price will increase by “Pizza” ‘s price


⭐ Consulter les menus #3

As a customer “Toto”, I want “Toto” want to see the available menu of the restaurant “KebabDelice” so that available menus of the restaurant “KebabDelice” is displayed


⭐ Payer une commande #4

As a customer “Toto”, I want “Toto” pay my order so that my order is ready to cook


⭐ Préparer une commande #5

As a cook, I want to launch the preparation of the order's "Toto" so that the statement of the order is now on "IN PROGRESS"



⭐ Prendre en charge une livraison #6

As a deliverer "Jacky", I want to deliver an order so that it will be marked delivered


⭐ Livrer une commande #7

As a deliverer Jacky, I want to take a charge an order so that i can deliver it


⭐ Valider une préparation #8

As a cook, I want to valid the preparation of an order so that the order statement is changed into "ready to deliver"


⭐ Livrer une commande #9

As a user who has passed an order, I want to delete it so that i can restart it again


⭐ Créer une commande groupée #10

As a customer, I want to create a group order so that I can add simple orders of my friends


⭐ Ajouter Ristorune restaurant #11

As a restaurant I want make discounts on my products so that my regular customers are rewarded

⭐ Recommendation of the order # 16

As a customer, I want to rate my previous order so that i could tell my satisfication

⭐ Commande Buffet # 19

As a collective Polytech, I want to order a buffet to students so that all my students are satisfied


⭐ Changer horaires restaurant #20

As a Restaurant Manager, I want to change my restaurant hours so that i could change my schedule


⭐ Changer infos menu #21

As a Restaurant Manager, I want to change restaurant information so that I can update them with new informations



<!-- ## Ce que fait votre projet


### Principales User stories
Vous mettez en évidence les principales user stories de votre projet.
Chaque user story doit être décrite par 
   - son identifiant en tant que issue github (#), 
   - sa forme classique (As a… I want to… In order to…) (pour faciliter la lecture)
   - Le nom du fichier feature Cucumber et le nom des scénarios qui servent de tests d’acceptation pour la story.
   Les contenus détaillés sont dans l'issue elle-même. 

-->
   

   
