[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5646210&assignment_repo_type=AssignmentRepo)
# Java - TP : Médias

## Contexte

Une société fait appel à vous pour concevoir la première version de son logiciel de recherche de film et série TV.

Étant pressé par le temps ils ne demandent pas d’interface graphique. Il a été convenu que le programme livré sera sous la forme d'une application console compatible sur tous les systèmes d’exploitation du marché (Windows, MacOS et Linux).

Ayant déjà une équipe de développeurs en interne, certaines contraintes techniques ont été appliquées.

## Fonctionnalités

### Menu

L’utilisateur doit pouvoir lancer le logiciel et accéder à un menu lui permettant de faire le choix de la fonctionnalité qu’il souhaite utiliser.

:exclamation: | ATTENTION ! Après chaque utilisation d’une fonctionnalité le programme ne doit pas s’arrêter mais reproposé le menu à l’utilisateur pour qu’il puisse faire un nouveau choix.
:---: | :---:

### Gestion des films et séries

Que ce soit des films ou séries,ces deux objets sont des médias. A vous de créer les classes et interfaces nécessaires au bon fonctionnement de votre programme.

Toutes les fonctionnalités de l'application doivent gérer des médias et ce sans distinctions entre ces deux types.

:information_source: | Il n'est pas nécessaire de gérer les autres types proposé par l'API
:---: | :---:

### Rechercher un média par son nom

Un utilisateur doit pouvoir demander la recherche d’un média (film ou série TV) via son nom. Le logiciel fournira alors la liste des 15 premiers résultats les plus pertinents à l’utilisateur en veillant à donner les informations suivantes :

* Id du média
* Nom du média
* Type du média

### Consulter le détail d'un média

Un utilisateur doit pouvoir connaître les détails d’un média. Il lui sera proposé de saisir l’identifiant unique du média.

:information_source: | L'API gère ces identifiants par catégorie de médias (films, séries, livres, ...). Dans le cas où plusieurs médias auraient le même id, seulement le premier de la liste sera considéré comme valide.
:---: | :---:

Les informations suivantes devront être affichées à l’utilisateur :

* Id
* Nom
* Type
* Description
* Moyenne des votes
* Nombre de vote

Le type de média devra varier de couleur en fonction de celui-ci :

* Bleu pour les films
* Vert pour les séries

### Ouverture du programme avec des paramètres

L’utilisateur doit pouvoir ouvrir l’application avec des paramètres afin de lancer automatiquement une action prédéfini. Ceci doit donc outrepasser le menu par défaut de l’application. Une fois la fonctionnalité terminée, le menu s’affiche de nouveau.

#### Lancer une recherche

Avec l'option "--search VALUE" doit permettre de lancer la recherche d'un média.

#### Afficher le détail d'un média

Avec l'option "--detail VALUE" doit permettre d'obtenir la fiche detail d'un média.

### Gestion des exceptions

Lors de l’exécution du programme il est fort à parier que l’application rencontre des problèmes (coupure Internet, mauvais format de données, …).

Il est impératif qu’un maximum d’exception soit géré. En revanche le programme ne doit pas s’arrêter. 

Celui-ci doit afficher un message d’erreur en rouge afin de prévenir ce dernier d’un problème. C’est seulement après la validation de l’utilisateur suite au message d’erreur, que le programme pourra se stopper.

### Qualité

Dans un soucis de qualité et de passation du projet, votre client souhaite que la grande majorité de votre code soit testé unitairement.
Un objectif minimum de **30%** de couverture de test est attendu.

Bien sûr une couverture plus grande sera grandement apprécié.

### Contraintes techniques

La société vous ayant commandé l’application applique certaines contraintes techniques puisqu’elle compte à terme reprendre elle-même le développement de l’application en 
interne :

* L'application doit être au format console / terminal
* L'application doit fonctionner sur Windows, MacOS et Linux
* L'application doit être codé en Java
* L'application doit respecté le code fourni
* Le modèle objet doit être respecté
* Le projet doit être organisé en namespaces
* L'utlisation de librairie externe est fortement conseillée
* Les convetions Java doivent être respectées
* Le projet aura des tests unitaires permettant de valider le fonctionnement de la majorité des classes
* Plusieurs design patterns doivent être utilisé de manière pertinente dans le code
* Les principes SOLID doivent être respectés

### Outils à disposition

L’API proposé par « The Movie Database » permettra d’avoir accès à une grande quantité de 
film et série : https://developers.themoviedb.org/3/getting-started/introduction