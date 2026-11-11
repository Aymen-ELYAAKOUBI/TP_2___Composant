# TP 10 — Composants Android

Application Android réalisée en Kotlin pour explorer les composants d’interface et les échanges entre fragments.

## Exercices

- **Exercice 1 :** communication entre l’activité et un fragment avec saisie et retour de message.
- **Exercice 2 :** transmission d’un message entre deux fragments.
- **Exercice 3 :** liste d’animaux avec affichage de leur description dans une boîte de dialogue.
- **Exercice 4 :** liste de fruits avec RecyclerView et détails au clic.

Les exercices sont accessibles depuis les onglets de l’écran principal.

## Technologies

- Kotlin
- Android SDK (compile/target SDK 37, minimum SDK 29)
- AndroidX AppCompat, Activity, Core, ConstraintLayout et ViewPager2
- Material Components

## Ouvrir le projet

1. Ouvrez le dossier du projet dans Android Studio.
2. Laissez Gradle synchroniser les dépendances.
3. Lancez la configuration `app` sur un émulateur ou un appareil Android (API 29 ou supérieure).

## Générer l’APK de debug

Depuis la racine du projet :

```bash
./gradlew assembleDebug
```

Sous Windows :

```powershell
.\gradlew.bat assembleDebug
```

L’APK est généré dans `app/build/outputs/apk/debug/`.
