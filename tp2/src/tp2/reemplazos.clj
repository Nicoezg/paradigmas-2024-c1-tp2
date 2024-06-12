(ns tp2.reemplazos
(:require [clojure.string :as str]))

(defn reemplazar
  "Mira caracter por caracter y si es un predecesor lo reemplaza por su sucesor
  y si no lo deja igual, retorna el string resultante después de hacerlo n veces"
  [axioma predecesores-sucesores n]
  (apply str (repeat n
                     (reduce (fn [resultado letra]
                               (str resultado (get predecesores-sucesores letra letra)))
                             ""
                             axioma))))