# Projektname: StudyGo

## Startanleitung

Dieses Dokument führt Sie durch die Schritte, die notwendig sind, um das StudyGo-Projekt auf Ihrem lokalen System zum Laufen zu bringen.

## Voraussetzungen
Stellen Sie sicher, dass folgende Software auf Ihrem System installiert ist:

- Java JDK (Version 17 oder höher)
- Maven (für das Build-Management)
- XAMPP (für MySQL-Datenbank)

## Projekt-Setup
Klonen Sie das Repository oder entpacken Sie das Projektarchiv in einen geeigneten Ordner auf Ihrem Computer.
Navigieren Sie im Terminal oder in der Kommandozeile in das Hauptverzeichnis des Projekts.

## Anwendung starten
Starten Sie die main Methode in StudyGoApplication

## Schritte zur Einrichtung
1. XAMPP und MySQL starten
   Starten Sie XAMPP und aktivieren Sie den MySQL-Dienst.

2. Datenbank und Tabellen erstellen
   Starten Sie phpMyAdmin über das XAMPP-Control-Panel und führen Sie die folgenden Schritte aus:

   1. Erstellen Sie eine neue Datenbank namens studygo.

   2. Wählen Sie die Datenbank studygo aus und öffnen Sie die SQL-Kommandozeile.
   3. Starten Sie die Anwendung über IntelliJ damit die Tabellen erstellt werden.
   4. Führen Sie das folgende SQL-Befehl aus, um die Rolle USER hinzuzufügen: ``INSERT INTO Role (id, name) VALUES (1, 'USER')``

