

(defn escribir-svg
    "Crea un archivo .svg que permite codificar imagenes"
    [nombre-archivo]
    (with-open [archivo (io/writer nombre-archivo)]
    (.write archivo (str "<svg viewBox= "  "-50 " "-150 " "300 " "200" "\" xmlns=\"http://www.w3.org/2000/svg\">")))


)

(defn escribir-linea
  "Escribe una linea que codifica un trazo"
  [nombre-archivo]
  (with-open [archivo (io/writer nombre-archivo :append true)]
  (.write archivo (str "<line x1=\"" "0" "\" y1=\"" "0" "\" x2=\"" "200" "\" y2=\"" "0" "\" stroke-width=\"1\" stroke=\"black\" />")))
  (escribir-linea nombre-archivo)
)

"<svg viewBox="-50 -150 300 200" xmlns="http://www.w3.org/2000/svg">
  <line x1="0" y1="0" x2="200" y2="0" stroke-width="1" stroke="black" />
  <line x1="200" y1="0" x2="200" y2="-100" stroke-width="1" stroke="black" />
  <line x1="100" y1="-100" x2="0" y2="-100" stroke-width="1" stroke="black" />
</svg>""
