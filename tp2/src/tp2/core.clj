(ns tp2.core
  (:gen-class)
  (:require [tp2.archivo :as archivo]
            [clojure.string :as str]
            [tp2.reemplazos :as reemplazos]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [infoArchivo (archivo/leer-archivo (nth args 0))
        angulo (Float/parseFloat (first infoArchivo))
        n-reemplazos (Float/parseFloat (nth args 1))
        axioma (second infoArchivo)
        predecesores-sucesores (archivo/analizar-sl infoArchivo)
        axiomas-reemplazados (reemplazos/reemplazar axioma predecesores-sucesores n-reemplazos)]
    (println axiomas-reemplazados)))