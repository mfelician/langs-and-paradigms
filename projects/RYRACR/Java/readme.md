- Default package-et haszn�lok, pedig az nem javasolt technikai okok miatt. Ilyen egyszer� feladatn�l ez megteszi.
- Java alkalmaz�sok tipikusan rengeteg apr� forr�sf�jlokb�l �llnak ami neh�zkess� teszi a ford�t�st build eszk�z�k n�lk�l. �n static nested inner class-okkal oldottam meg azt a gordiuszi csom�t. Szint�n haszn�ltam static initializereket. Egy pillanatra arra gondoltam, hogy a Java t�l k�nnyen megengedi a nem javasolt dolgok elk�vet�s�t - gyan�tom ezzel nincs egyed�l a nyelvek k�z�tt.
- Java extr�m modellez� er�vel rendelkezik, j� esetben csak a feladat ki�r�s�t Java nyelvre kell ford�tani. �n is ezt tettem. �sz n�lk�l lemodelleztem a feladatot. K�zben kider�lt, hogy a feladat ki�r�sa nem a legjobb: az �llapot�tmenet rajzot �t kellett picit rajzolnom, hogy determinisztikus v�ges �llapotg�pr�l besz�lhess�nk.
- A direkt feladat-ki�r�s lek�dol�si megold�si m�dszer a feladatki�r�s egy t�nyleges logikai hib�j�t eg�szen a v�gs� program tesztel�s�ig elod�zta. Az �llapotg�p ki�r�s szerint az 1.01-et nem fogadhatja el. Sz�momra ez a jelens�g megmutatatta, hogy a Java nagyon alkalmas komponens alap� szoftverfejleszt�sre, ahol a komponensek fejleszt�inek csup�n a specifik�ci� r�juk vonatkoz� r�sz�vel kell tiszt�ban lennie.
- Implement�ci� k�zben a Java SE-b�l hi�nyoltam a t�bbkulcsos map-ot, ami j�l j�tt volna az �llapot�tmenet "f�ggv�ny" implement�ci�j�hoz.
- Static initializer-ek haszn�lata nem javasolt, de cs�b�t�
- Eg�sz k�dban nincs switch �s csak 3 db if el�gaz�s!

Futtat�s:
javac Machine.java Runner.java
java Runner input.txt
