

(defn escribir-svg
    "Crea un archivo .svg que permite codificar imagenes"
    [nombre-archivo lineas] 
    (with-open [archivo (io/writer nombre-archivo)]
    (.write archivo (str "<svg viewBox= "  (-(x-min lineas) 50) (-(y-min lineas) 50) (+ (x-max lineas) 100 ) (+(abs(y-max lineas) 100) "\" xmlns=\"http://www.w3.org/2000/svg\">"))))
   
)

(defn escribir-linea
  "Escribe una linea que codifica un trazo"
  [nombre-archivo]
  (with-open [archivo (io/writer nombre-archivo :append true)]
  (.write archivo (str "<line x1=\"" "0" "\" y1=\"" "0" "\" x2=\"" "200" "\" y2=\"" "0" "\" stroke-width=\"1\" stroke=\"black\" />")))
)

(defn escribir-final-svg)
  "Escribe la última linea del .svg"
  [nombre-archivo]
  (with-open [archivo (io/writer nombre-archivo :append true)]
  (.write archivo "</svg>\"")
)

"<svg viewBox="-50 -150 300 200" xmlns="http://www.w3.org/2000/svg">
  <line x1="0" y1="0" x2="200" y2="0" stroke-width="1" stroke="black" />
  <line x1="200" y1="0" x2="200" y2="-100" stroke-width="1" stroke="black" />
  <line x1="100" y1="-100" x2="0" y2="-100" stroke-width="1" stroke="black" />
</svg>"

(defn obtener-lineas [s](
  "Se obtiene un vector sin + ni -"
 (clojure.string/split s #"[+-]")
))

(defn obtener-primer-vector [s]
  (loop [remaining s]
    (if (empty? remaining)
      (let [current-char (first remaining)]
        (if (#{\+ \- \g} current-char) (rest remaining)
            ; Check if current character is one of the specified characters
          
          :else  ; If not one of the specified characters, continue iterating
          (recur (rest remaining)))))))  ; Recur with the rest of the string
(defn separar-pluma [])
  

(iterate-characters "hello")
(defn procesar [parte-axioma pila-t]
  (let [caso (some #{"+" "-" "[" "]""f""g"} parte-axioma)
    pila-t(case caso
      "+" (girar)
      "-" (girar)
      "[" (apilar)
      "]" (desapilar)
      "f" (levantar)
      "g" (apoyar)
      pila-t
      )
  (n (count (filter #(#{\F \G} %) parte-axioma)))
  (tortuga-ant (pila-ver-tope pila-t))
  (tortuga-act (avanzar tortuga-ant n))
  (escribirarchivo archivo tortuga-ant tortuga-act)])
)


  

defn 
; ["ffff" "[" "ff" "+" "ffff" "]" "ff" "-" "ffff"]
; if linea[0] in ['+', '-',']','[']:
;  switch (linea[0]) {
 ;   case '+':giras
;    case '-';giras
 ;   case '[':apilar
 ;   case ']':desapilas
;  }
;n=(len(filter (#(x==F o x==G))
;ant=tortugavector(tortuga)
;tortuga=adelante(tortuga, n)
;act=tortugavector(tortuga)
;escribirarchivo(archivo,ant, act,numero de linea)


