# Rapport Lab06

## Hypothèses de Travail

Pour réaliser ce projet, plusieurs hypothèses de travail ont été établies afin de structurer les implémentations et clarifier les limites du système.

### 1. Gestion des Identifiants Uniques

- **Hypothèse** : Chaque étudiant et chaque enseignant est identifié par un identifiant unique.
- **Justification** : Cela permet de garantir l'unicité des membres et facilite la gestion des groupes en évitant des doublons.
- **Conséquences** : Si un étudiant ou un enseignant se voit attribuer un ID en double, une exception est levée pour maintenir l'intégrité des données.

### 2. Structure de l'Horaire

- **Hypothèse** : Les horaires de cours sont prédéfinis en fonction de créneaux horaires standards.
- **Justification** : Cela simplifie l'affichage et la gestion des leçons en utilisant un tableau prédéfini.
- **Conséquences** : Le système ne permet pas de gérer des cours en dehors de ces plages horaires standards.

### 3. Assignation des Leçons aux Enseignants

- **Hypothèse** : Chaque leçon peut être assignée à un enseignant spécifique ou rester sans enseignant.
- **Justification** : Cela permet de gérer aussi bien les cours encadrés que les cours en projet autonome.
- **Conséquences** : Si une leçon est créée sans enseignant, elle peut être assignée ultérieurement, mais un enseignant ne peut pas être assigné à plusieurs cours au même moment.

### 4. Limitation du Nom des Matières et des Salles

- **Hypothèse** : Les noms des matières et des salles sont limités en longueur.
- **Justification** : Cette contrainte permet d’assurer la lisibilité dans les cellules d'un tableau horaire formaté.
- **Conséquences** : Les noms de matière ou de salle qui excèdent la limite de caractères ne sont pas acceptés.

### 5. Composition des Groupes

- **Hypothèse** : Les groupes sont composés d’un ensemble d'étudiants et ont un nom structuré (orientation, trimestre, numéro de groupe).
- **Justification** : Cette structure rend les noms de groupes uniques et descriptifs.
- **Conséquences** : La modification des groupes n'est pas prévue dynamiquement dans cette version du système.

### 6. Affichage Dynamique des Membres

- **Hypothèse** : Le système utilise le mécanisme de liaison dynamique pour afficher les informations sur les membres de l'école.
- **Justification** : Cela permet de bénéficier de la polymorphie en Java pour présenter les informations des étudiants et des enseignants de manière générique.
- **Conséquences** : Le code est conçu pour afficher les informations de toute personne héritant de la classe `Person`.

## Détails Techniques

- **Classes Principales** :
    - `Person` : Classe de base pour `Student` et `Teacher`.
    - `Group` : Gère les groupes d'étudiants et les leçons assignées.
    - `Lesson` : Définit une leçon avec les attributs comme matière, jour, période, et salle.
- **Gestion des Exceptions** : Des vérifications sont effectuées pour garantir la validité des données (par exemple, la durée de la leçon et le jour de la semaine).

## Limitations Connues

- Le système ne gère pas les cas où un étudiant appartient à plusieurs groupes.
- Les horaires de cours ne sont pas configurables et sont limités aux créneaux définis.
- La gestion des conflits d'horaires pour les leçons n'est pas traitée dans cette version.

## Conclusion

Ce projet fournit une base fonctionnelle pour la gestion des groupes, des étudiants, des enseignants et de l'horaire des cours. Le système est conçu avec des hypothèses claires et des limites de configuration qui simplifient son implémentation et son utilisation. Des améliorations futures pourraient inclure la gestion dynamique des horaires, la détection des conflits de planification, et l'ajout d'une interface utilisateur.

---

**Remarques** : Ce document constitue une première ébauche du rapport technique pour le système. Il est prévu de revoir et d'étendre les hypothèses et limitations à mesure que le système évolue et que des retours utilisateurs sont intégrés.
