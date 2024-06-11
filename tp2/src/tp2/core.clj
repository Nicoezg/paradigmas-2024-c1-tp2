(ns tp2.core
  (:gen-class)
  (:require [tp2.archivo :as archivo]
            [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [infoArchivo (archivo/leer-archivo (nth args 0))
        angulo (Float/parseFloat (first infoArchivo))
        n-reemplazos (Float/parseFloat (nth args 1))
        axioma (second infoArchivo)
        predecesor1 (nth infoArchivo 2)
        predecesor2 (if (> (count infoArchivo) 3) 
                    (nth infoArchivo 3)     
                    "")]

        (println predecesor2)
)
)
