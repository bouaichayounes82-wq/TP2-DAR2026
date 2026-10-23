# TP2 — Développement d'applications réparties

**Étudiant :** Younes Bouaicha
**Module :** Développement d'applications réparties
**Langage :** Java
**Environnement :** Eclipse

## Activité 2-1 : Échange de chaînes de caractères par TCP

Le client envoie une expression arithmétique sous forme de chaîne de caractères au serveur. Le serveur analyse l'expression, effectue le calcul et renvoie le résultat au client.

Opérations prises en charge : addition, soustraction, multiplication et division.

## Activité 2-2 : Échange d'objets par TCP

La classe `Operation` implémente `Serializable` et contient les deux nombres ainsi que l'opérateur.

Le client envoie un objet `Operation` au serveur à travers une connexion TCP. Le serveur récupère les données, effectue le calcul et renvoie le résultat au client.

## Packages

- `clientPackage` : contient les classes clientes.
- `serverPackage` : contient les classes serveurs.
- `commonPackage` : contient la classe `Operation`.

## Exécution

1. Lancer le serveur correspondant à l'activité souhaitée.
2. Lancer le client correspondant.
3. Vérifier le résultat affiché dans la console.

## Technologies utilisées

- Java
- Sockets TCP
- Sérialisation des objets Java
- Eclipse IDE
