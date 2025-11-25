Fragen beantwortet

Müssen Getter und Setter Methoden auch im Diagramm abgebildet werden?
→ Meistens: Nein, wenn man nur die logischen Klassen und ihre HAT/„hat“ (Komposition/Aggregation) Beziehungen darstellt. 
Getter/Setter zählen oft zur Implementierung und werden weggelassen, damit das Diagramm nicht überfrachtet wird. 
Wenn aber im Unterricht verlangt, dass man alle Methoden zeigt, dann kann man sie aufführen, dann aber klar markieren.

Gehört die Klasse mit der main-Methode auch zum Diagramm?
→ Ja, wenn sie Teil des Systems ist und Beziehungen zu den anderen Klassen hat. 
Wenn sie nur einen Einstiegspunkt („nur“ main) darstellt und keine Zustände oder HAT-Beziehungen hat, kann man sie optional weglassen, aber oft ist es guter Stil, sie zumindest als „Startklasse“ zu zeigen.

Wann macht eine bidirektionale Beziehung Sinn?
→ Wenn zum Beispiel Klasse A verweist auf Klasse B und Klasse B verweist aktiv auf Klasse A. 
Also beide wissen voneinander und nutzen einander. 
Beispiel: „Customer“ hat „Orders“ und „Order“ hat eine Referenz zurück zum „Customer“. 
Wenn nur eine Seite die andere kennt, reicht unidirektional.

Reicht es, wenn eine Assoziation ohne Pfeil dargestellt wird?
→ In vielen Fällen ja, eine einfache Linie reicht zur Darstellung einer Assoziation. 
Wenn aber relevante Richtung vorhanden ist (z. B. „verwaltet“/„wird verwaltet von“) oder wenn du hierarchisch oder „nur“ gelesen wird vs. „geschrieben wird“, dann ist ein Pfeil sinnvoll. 
Der Unterricht könnte verlangen: mit Pfeil für klare Richtung, ohne wenn Richtung egal.
