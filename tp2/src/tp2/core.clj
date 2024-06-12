(ns tp2.core
  (:gen-class)
  (:require [tp2.archivo :as archivo]
            [clojure.string :as str]
            [tp2.reemplazos :as reemplazos]))


(defn -main
  "Lee el archivo y aplica los reemplazos especificados."
  [& args]
  (let [infoArchivo (archivo/leer-archivo (nth args 0))
        angulo (Float/parseFloat (first infoArchivo))
        n-reemplazos (Integer/parseInt (nth args 1))
        axioma (second infoArchivo)
        predecesores-sucesores (archivo/analizar-sl infoArchivo)
        axioma-final (reemplazos/n-reemplazos axioma predecesores-sucesores n-reemplazos)]
    (println axioma-final)))